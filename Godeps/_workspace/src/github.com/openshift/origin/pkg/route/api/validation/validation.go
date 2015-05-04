package validation

import (
	"fmt"
	"strings"

	kval "github.com/GoogleCloudPlatform/kubernetes/pkg/api/validation"
	"github.com/GoogleCloudPlatform/kubernetes/pkg/util"
	"github.com/GoogleCloudPlatform/kubernetes/pkg/util/fielderrors"

	routeapi "github.com/openshift/origin/pkg/route/api"
)

// ValidateRoute tests if required fields in the route are set.
func ValidateRoute(route *routeapi.Route) fielderrors.ValidationErrorList {
	result := fielderrors.ValidationErrorList{}

	//ensure meta is set properly
	result = append(result, kval.ValidateObjectMeta(&route.ObjectMeta, true, kval.ValidatePodName)...)

	//host is not required but if it is set ensure it meets DNS requirements
	if len(route.Host) > 0 {
		if !util.IsDNS1123Subdomain(route.Host) {
			result = append(result, fielderrors.NewFieldInvalid("host", route.Host, "Host must conform to DNS 952 subdomain conventions"))
		}
	}

	if len(route.Path) > 0 && !strings.HasPrefix(route.Path, "/") {
		result = append(result, fielderrors.NewFieldInvalid("path", route.Path, "Path must begin with /"))
	}

	if len(route.ServiceName) == 0 {
		result = append(result, fielderrors.NewFieldRequired("serviceName"))
	}

	if errs := validateTLS(route); len(errs) != 0 {
		result = append(result, errs.Prefix("tls")...)
	}

	return result
}

// ValidateTLS tests fields for different types of TLS combinations are set.  Called
// by ValidateRoute.
func validateTLS(route *routeapi.Route) fielderrors.ValidationErrorList {
	result := fielderrors.ValidationErrorList{}
	tls := route.TLS

	//no termination, ignore other settings
	if tls == nil || tls.Termination == "" {
		return nil
	}

	switch tls.Termination {
	// reencrypt must specify destination ca cert
	// cert, key, cacert may not be specified because the route may be a wildcard
	case routeapi.TLSTerminationReencrypt:
		if len(tls.DestinationCACertificate) == 0 {
			result = append(result, fielderrors.NewFieldRequired("destinationCACertificate"))
		}
	//passthrough term should not specify any cert
	case routeapi.TLSTerminationPassthrough:
		if len(tls.Certificate) > 0 {
			result = append(result, fielderrors.NewFieldInvalid("certificate", tls.Certificate, "passthrough termination does not support certificates"))
		}

		if len(tls.Key) > 0 {
			result = append(result, fielderrors.NewFieldInvalid("key", tls.Key, "passthrough termination does not support certificates"))
		}

		if len(tls.CACertificate) > 0 {
			result = append(result, fielderrors.NewFieldInvalid("caCertificate", tls.CACertificate, "passthrough termination does not support certificates"))
		}

		if len(tls.DestinationCACertificate) > 0 {
			result = append(result, fielderrors.NewFieldInvalid("destinationCACertificate", tls.DestinationCACertificate, "passthrough termination does not support certificates"))
		}
	// edge cert should only specify cert, key, and cacert but those certs
	// may not be specified if the route is a wildcard route
	case routeapi.TLSTerminationEdge:
		if len(tls.DestinationCACertificate) > 0 {
			result = append(result, fielderrors.NewFieldInvalid("destinationCACertificate", tls.DestinationCACertificate, "edge termination does not support destination certificates"))
		}
	default:
		msg := fmt.Sprintf("invalid value for termination, acceptable values are %s, %s, %s, or emtpy (no tls specified)", routeapi.TLSTerminationEdge, routeapi.TLSTerminationPassthrough, routeapi.TLSTerminationReencrypt)
		result = append(result, fielderrors.NewFieldInvalid("termination", tls.Termination, msg))
	}
	return result
}

package io.fabric8.config;

import io.sundr.builder.annotations.ExternalBuildables;

@ExternalBuildables(validationEnabled = true, builderPackage = "io.fabric8.common", value = {
        "io.fabric8.kubernetes.api.model.KubernetesList",

        "io.fabric8.kubernetes.api.model.Capabilities",
        "io.fabric8.kubernetes.api.model.Container",
        "io.fabric8.kubernetes.api.model.ContainerManifest",
        "io.fabric8.kubernetes.api.model.ContainerPort",
        "io.fabric8.kubernetes.api.model.ContainerState",
        "io.fabric8.kubernetes.api.model.ContainerStateRunning",
        "io.fabric8.kubernetes.api.model.ContainerStateTerminated",
        "io.fabric8.kubernetes.api.model.ContainerStateWaiting",
        "io.fabric8.kubernetes.api.model.ContainerStatus",
        "io.fabric8.kubernetes.api.model.EmptyDirVolumeSource",
        "io.fabric8.kubernetes.api.model.EndpointAddress",
        "io.fabric8.kubernetes.api.model.EndpointObjectReference",
        "io.fabric8.kubernetes.api.model.EndpointPort",
        "io.fabric8.kubernetes.api.model.EndpointSubset",
        "io.fabric8.kubernetes.api.model.Endpoints",
        "io.fabric8.kubernetes.api.model.EndpointsList",
        "io.fabric8.kubernetes.api.model.EnvVar",
        "io.fabric8.kubernetes.api.model.ExecAction",
        "io.fabric8.kubernetes.api.model.GCEPersistentDiskVolumeSource",
        "io.fabric8.kubernetes.api.model.GitRepoVolumeSource",
        "io.fabric8.kubernetes.api.model.GlusterfsVolumeSource",
        "io.fabric8.kubernetes.api.model.HTTPGetAction",
        "io.fabric8.kubernetes.api.model.Handler",
        "io.fabric8.kubernetes.api.model.HostPathVolumeSource",
        "io.fabric8.kubernetes.api.model.ISCSIVolumeSource",
        "io.fabric8.kubernetes.api.model.KubeSchema",
        "io.fabric8.kubernetes.api.model.Lifecycle",
        "io.fabric8.kubernetes.api.model.LivenessProbe",
        "io.fabric8.kubernetes.api.model.Minion",
        "io.fabric8.kubernetes.api.model.MinionList",
        "io.fabric8.kubernetes.api.model.NFSVolumeSource",
        "io.fabric8.kubernetes.api.model.NodeAddress",
        "io.fabric8.kubernetes.api.model.NodeCondition",
        "io.fabric8.kubernetes.api.model.NodeResources",
        "io.fabric8.kubernetes.api.model.NodeStatus",
        "io.fabric8.kubernetes.api.model.NodeSystemInfo",
        "io.fabric8.kubernetes.api.model.ObjectReference",
        "io.fabric8.kubernetes.api.model.Pod",
        "io.fabric8.kubernetes.api.model.PodCondition",
        "io.fabric8.kubernetes.api.model.PodList",
        "io.fabric8.kubernetes.api.model.PodState",
        "io.fabric8.kubernetes.api.model.PodTemplate",
        "io.fabric8.kubernetes.api.model.ReplicationController",
        "io.fabric8.kubernetes.api.model.ReplicationControllerList",
        "io.fabric8.kubernetes.api.model.ReplicationControllerState",
        "io.fabric8.kubernetes.api.model.ResourceRequirements",
        "io.fabric8.kubernetes.api.model.RestartPolicy",
        "io.fabric8.kubernetes.api.model.RestartPolicyAlways",
        "io.fabric8.kubernetes.api.model.RestartPolicyNever",
        "io.fabric8.kubernetes.api.model.RestartPolicyOnFailure",
        "io.fabric8.kubernetes.api.model.SecretVolumeSource",
        "io.fabric8.kubernetes.api.model.Service",
        "io.fabric8.kubernetes.api.model.ServiceList",
        "io.fabric8.kubernetes.api.model.ServicePort",
        "io.fabric8.kubernetes.api.model.TCPSocketAction",
        "io.fabric8.kubernetes.api.model.Volume",
        "io.fabric8.kubernetes.api.model.VolumeMount",
        "io.fabric8.kubernetes.api.model.VolumeSource",
        "io.fabric8.kubernetes.api.model.errors.StatusError",
        "io.fabric8.kubernetes.api.model.runtime.RawExtension",
        "io.fabric8.kubernetes.api.model.resource.Quantity",
        "io.fabric8.kubernetes.api.model.runtime.RawExtension"
})
public class KubernetesConfig {
}

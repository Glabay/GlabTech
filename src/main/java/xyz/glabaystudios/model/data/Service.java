package xyz.glabaystudios.model.data;

import lombok.Getter;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-02-18
 */
@Getter
public enum Service {

    DESTROY         (22.00, "32-pass Data Erase; Followed with physical destruction."),
    REIMAGE         (50.00, "Reinstall the Operating System of a PC/Tablet/Laptop/Mobile device."),
    BACKUP          (25.00, "Create an archived backup of all essential and user files."),
    DIAGNOSTIC      (40.00, "Check the health of the physical Hardware, as well as scan for malicious software"),
    HARDWARE_UPGRADE(20.00, "Install new Hardware and Drivers + Device Hardware health Scan."),
    ON_SITE_TECH    (99.00, "On-Site technician, $99/first hr then $40/hr additional.", false)
    ;

    Service(double servicePrice, String serviceDescription) {
        this(servicePrice, serviceDescription, true);
    }
    Service(double servicePrice, String serviceDescription, boolean fixedRate) {
        this.servicePrice = servicePrice;
        this.serviceDescription = serviceDescription;
        this.fixedRate = fixedRate;
    }

    private final String serviceName = this.name().replace('_', ' ');
    private final String serviceDescription;

    private final double servicePrice;
    private final boolean fixedRate;

}

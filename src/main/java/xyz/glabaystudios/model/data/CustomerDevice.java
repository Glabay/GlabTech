package xyz.glabaystudios.model.data;

import lombok.Getter;
import lombok.Setter;
import xyz.glabaystudios.model.data.uncached.AdditionalThings;
import xyz.glabaystudios.model.data.uncached.DeviceType;

import java.util.Date;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-02-18
 */
@Getter
@Setter
public class CustomerDevice {
    private DeviceType deviceType = DeviceType.UNKNOWN;
    private AdditionalThings additionalThings;
    private Date dropOffDate;
    private String notes;
}

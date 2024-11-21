package xyz.glabaystudios.model.data.uncached;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-02-18
 */
@Getter
public class AdditionalThings {
    private final Map<Integer, String> additionThings = new HashMap<>();

    public void addThing(String thingToAdd) {
        additionThings.put(additionThings.size() + 1, thingToAdd);
    }

}

package xyz.glabaystudios;

import xyz.glabaystudios.model.data.Service;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-02-26
 */
public class GlabTech {

    public static void main(String... args) {
        System.out.println("Hello World!");
        var services = Service.values();

        for (var service : services) {
            System.out.printf("Service Name: %s\tService Cost: %.2f\tService Descriptions: %s%n",
                    service.getServiceName(),
                    service.getServicePrice(),
                    service.getServiceDescription());
        }
    }
}

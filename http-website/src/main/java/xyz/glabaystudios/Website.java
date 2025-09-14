package xyz.glabaystudios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {
    "xyz.glabaystudios.config",
    "xyz.glabaystudios.site_map"
})
public class Website {

    public static void main(String... args) {
        SpringApplication.run(Website.class, args);
    }

    @Bean
    RestClient restClient() {
        return RestClient.builder()
            .requestFactory(new JdkClientHttpRequestFactory())
            .build();

    }
}

package xyz.glabaystudios.net;

import org.springframework.http.MediaType;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2025-10-17
 */
public interface IClient {
    String TOKEN = System.getenv("API_TOKEN");
    String API_URL = "http://localhost:8080/api/";

    default RestClient getRestClient() {
        return RestClient.builder()
            .requestFactory(new JdkClientHttpRequestFactory())
            .defaultHeader("Authorization", "Bearer ".concat(TOKEN))
            .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .build();
    }
}

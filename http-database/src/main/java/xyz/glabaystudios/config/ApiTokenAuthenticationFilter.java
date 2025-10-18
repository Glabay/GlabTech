package xyz.glabaystudios.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2025-10-17
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ApiTokenAuthenticationFilter extends OncePerRequestFilter {

    @Value("${api.security.token}")
    private String validApiToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {

        String requestPath = request.getRequestURI();

        // Only apply this filter to /api/** endpoints
        if (requestPath.startsWith("/api/")) {
            String token = extractTokenFromRequest(request);

            if (StringUtils.hasText(token) && token.equals(validApiToken)) {
                // Token is valid - create authentication
                var authentication = new UsernamePasswordAuthenticationToken(
                    "API_USER",
                    null,
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_API"))
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.debug("Valid API token provided for: {}", requestPath);
            }
            else {
                log.warn("Invalid or missing API token for: {}", requestPath);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Invalid or missing API token\"}");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Extract token from Authorization header (Bearer token) or X-API-Token header
     */
    private String extractTokenFromRequest(HttpServletRequest request) {
        // Try Authorization: Bearer <token>
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        String apiToken = request.getHeader("X-API-Token");
        if (StringUtils.hasText(apiToken)) {
            return apiToken;
        }

        return null;
    }
}

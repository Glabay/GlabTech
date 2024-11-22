package xyz.glabaystudios.model;

import jakarta.persistence.*;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-02-18
 */
@Entity(name = "services")
@Table(name = "SERVICES")
public record Service(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String serviceName,
    String serviceDescription,
    double servicePrice,
    boolean fixedRate
) {}

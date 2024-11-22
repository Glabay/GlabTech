package xyz.glabaystudios.dto;

import java.time.LocalDate;
/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-11-22
 */
public record EmployeeDto(
    String employeeFirstName,
    String employeeLastName,
    LocalDate employeeStartDate,
    LocalDate employeeEndDate,
    String contactNumber,
    String position
) {}
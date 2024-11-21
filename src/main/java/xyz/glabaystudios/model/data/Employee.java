package xyz.glabaystudios.model.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-02-18
 */
@Getter
@Setter
public class Employee {
    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private LocalDate employeeStartDate;
    private LocalDate employeeEndDate;
    private String contactNumber;
    private String position;
}
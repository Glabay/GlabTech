package xyz.glabaystudios.inter.impl;

import xyz.glabaystudios.dto.EmployeeDto;
import xyz.glabaystudios.inter.DtoConverter;
import xyz.glabaystudios.model.Employee;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
*/
public interface EmployeeConverter extends DtoConverter<Employee, EmployeeDto> {
    default EmployeeDto mapToDto(Employee model) {
        return new EmployeeDto(
            model.getEmployeeFirstName(),
            model.getEmployeeLastName(),
            model.getEmployeeStartDate(),
            model.getEmployeeEndDate(),
            model.getContactNumber(),
            model.getPosition()
        );
    }
}

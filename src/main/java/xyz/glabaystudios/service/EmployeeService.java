package xyz.glabaystudios.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.dto.EmployeeDto;
import xyz.glabaystudios.inter.impl.EmployeeConverter;
import xyz.glabaystudios.repo.EmployeeRepository;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
*/
@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeConverter {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .toList();
    }

}

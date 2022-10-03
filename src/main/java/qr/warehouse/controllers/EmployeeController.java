package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.payload.EmployeeDTO;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Employee;
import qr.warehouse.services.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    private Result addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return service.addEmployee(employeeDTO);
    }

    @GetMapping
    private List<Employee> getAllEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/{employeeId}")
    private Employee getEmployeeById(@PathVariable Long employeeId) {
        return service.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    private Result updateEmployee(@PathVariable Long employeeId,
                                  @RequestBody EmployeeDTO employeeDTO) {
        return service.updateEmployee(employeeId, employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    private Result deleteEmployee(@PathVariable Long employeeId) {
        return service.deleteEmployee(employeeId);
    }

}
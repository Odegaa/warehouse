package qr.warehouse.services;

import qr.warehouse.payload.EmployeeDTO;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Employee;

import java.util.List;

public interface EmployeeService {
    Result addEmployee(EmployeeDTO employeeDTO);

    List<Employee> getEmployees();

    Result updateEmployee(Long employeeId, EmployeeDTO employeeDTO);

    Result deleteEmployee(Long employeeId);

    Employee getEmployeeById(Long employeeId);
}

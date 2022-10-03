package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Employee;
import qr.warehouse.models.Warehouse;
import qr.warehouse.payload.EmployeeDTO;
import qr.warehouse.repositories.EmployeeRepository;
import qr.warehouse.repositories.WarehouseRepository;
import qr.warehouse.services.EmployeeService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final WarehouseRepository warehouseRepository;

    @Override
    public Result addEmployee(EmployeeDTO employeeDTO) {
        boolean byPhone = repository.existsEmployeeByPhone(employeeDTO.getPhone());
        boolean byCode = repository.existsEmployeeByCode(employeeDTO.getCode());

        if (byPhone || byCode) {
            return new Result("This phone or code is already exist!", false);
        } else {
            Employee newEmployee = new Employee();
            newEmployee.setSurname(employeeDTO.getSurname());
            newEmployee.setName(employeeDTO.getName());
            newEmployee.setPhone(employeeDTO.getPhone());
            newEmployee.setPassword(employeeDTO.getPassword());
            newEmployee.setCode(UUID.randomUUID().toString());
            newEmployee.setStatus(true);

            Optional<Warehouse> warehouseOptional = warehouseRepository.findById(employeeDTO.getWarehouseId());
            warehouseOptional.ifPresent(warehouse -> newEmployee.setWarehouse(Collections.singleton(warehouse)));

            repository.save(newEmployee);
            return new Result("Employee successful saved!", true);
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Result updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = repository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee updatingEmployee = employeeOptional.get();
            updatingEmployee.setSurname(employeeDTO.getSurname());
            updatingEmployee.setName(employeeDTO.getName());
            updatingEmployee.setPhone(employeeDTO.getPhone());
            updatingEmployee.setPassword(employeeDTO.getPassword());
            updatingEmployee.setCode(UUID.randomUUID().toString());
            updatingEmployee.setStatus(true);
            Optional<Warehouse> warehouseOptional = warehouseRepository.findById(employeeDTO.getWarehouseId());
            warehouseOptional.ifPresent(warehouse -> updatingEmployee.setWarehouse(Collections.singleton(warehouse)));
            repository.save(updatingEmployee);
            return new Result("Employee successfully updating!", true);
        }
        return new Result("Employee not found!", false);
    }

    @Override
    public Result deleteEmployee(Long employeeId) {
        Optional<Employee> employeeOptional = repository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            repository.deleteById(employeeId);
            return new Result("Employee deleted!", true);
        }
        return new Result("Employee not found!", false);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return repository.findById(employeeId).orElse(null);
    }
}
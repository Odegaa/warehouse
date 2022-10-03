package qr.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String surname;
    private String name;
    private String phone;
    private String password;
    private String code;
    private Long warehouseId;
    private Boolean status;
}
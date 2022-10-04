package qr.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputProductsDTO {
    private Long productId;
    private Double amount;
    private String price;
    private Long inputId;
}
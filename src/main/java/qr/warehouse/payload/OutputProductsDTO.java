package qr.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputProductsDTO {
    private Long productId;
    private Double amount;
    private BigDecimal price;
    private Long outputId;
}
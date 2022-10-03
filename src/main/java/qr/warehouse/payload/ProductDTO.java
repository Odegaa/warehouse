package qr.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productName;
    private Long categoryId;
    private Long attachmentId;
    private Long measurementId;
}
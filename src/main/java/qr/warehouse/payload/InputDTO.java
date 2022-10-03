package qr.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDTO {
    private Date dateTimeFormat;
    private Long warehouseId;
    private Long supplierId;
    private Long currencyId;
    private String facture_number;
    private String code;
}
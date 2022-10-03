package qr.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputDTO {
    private Date date;
    private Long warehouseId;
    private Long currencyId;
    private Long clientId;
    private String factureNumber;
    private String generationCode;
}
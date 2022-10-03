package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Currency;
import qr.warehouse.services.CurrencyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService service;

    @PostMapping
    private Result addCurrency(@RequestBody Currency currency) {
        return service.addCurrency(currency);
    }

    @GetMapping
    private List<Currency> getCurrency() {
        return service.getAllCurrencies();
    }

    @GetMapping("/{currencyId}")
    private Currency getCurrencyById(@PathVariable Long currencyId) {
        return service.getCurrencyById(currencyId);
    }

    @PutMapping("/{currencyId}")
    private Result updateCurrency(@PathVariable Long currencyId,
                                  @RequestBody Currency currency) {
        return service.updateCurrency(currencyId, currency);
    }

    @DeleteMapping("/{currencyId}")
    private Result deleteCurrency(@PathVariable Long currencyId) {
        return service.deleteCurrency(currencyId);
    }

}
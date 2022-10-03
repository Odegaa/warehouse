package qr.warehouse.services;

import qr.warehouse.finaly.Result;
import qr.warehouse.models.Currency;

import java.util.List;

public interface CurrencyService {
    Result addCurrency(Currency currency);

    List<Currency> getAllCurrencies();


    Result updateCurrency(Long currencyId, Currency currency);

    Result deleteCurrency(Long currencyId);

    Currency getCurrencyById(Long currencyId);

}

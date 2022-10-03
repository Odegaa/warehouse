package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Currency;
import qr.warehouse.repositories.CurrencyRepository;
import qr.warehouse.services.CurrencyService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository repository;

    @Override
    public Result addCurrency(Currency currency) {
        try {
            boolean currencyName = repository.existsByCurrencyName(currency.getCurrencyName());
            if (currencyName) {
                return new Result("This currency already exist!", false);
            } else {
                Currency newCurrency = new Currency();
                newCurrency.setCurrencyName(currency.getCurrencyName());
                newCurrency.setStatus(true);

                repository.save(newCurrency);
                return new Result("Successfully saved!", true);
            }
        } catch (Exception e) {
            return new Result("An error occurred!", false);
        }
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return repository.findAll();
    }

    @Override
    public Result updateCurrency(Long currencyId, Currency currency) {
        Optional<Currency> optionalCurrency = repository.findById(currencyId);
        if (optionalCurrency.isPresent()) {
            Currency updatingCurrency = optionalCurrency.get();
            updatingCurrency.setCurrencyName(currency.getCurrencyName());
            updatingCurrency.setStatus(true);

            repository.save(updatingCurrency);
            return new Result("Successfully updated!", true);
        }
        return new Result("Currency not found or Exception!", false);
    }

    @Override
    public Result deleteCurrency(Long currencyId) {
        Optional<Currency> optionalCurrency = repository.findById(currencyId);
        if (optionalCurrency.isPresent()) {
            repository.deleteById(currencyId);
            return new Result("Currency successfully deleted!", true);
        }
        return new Result("Currency not found or Exception!", false);
    }

    @Override
    public Currency getCurrencyById(Long currencyId) {
        return repository.findById(currencyId).orElse(null);
    }
}
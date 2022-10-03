package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.repositories.InputProductsRepository;
import qr.warehouse.services.InputProductsService;

@Service
@RequiredArgsConstructor
public class InputProductsServiceImpl implements InputProductsService {

    private final InputProductsRepository repository;

}
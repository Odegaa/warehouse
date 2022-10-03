package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.repositories.OutputProductsRepository;
import qr.warehouse.services.OutputProductsService;

@Service
@RequiredArgsConstructor
public class OutputProductsServiceImpl implements OutputProductsService {

    private final OutputProductsRepository repository;

}
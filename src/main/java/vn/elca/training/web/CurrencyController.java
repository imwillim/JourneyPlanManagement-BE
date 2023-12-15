package vn.elca.training.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.elca.training.common.ApplicationResponse;
import vn.elca.training.model.dto.CurrencyDTO;
import vn.elca.training.service.CurrencyService;

import java.util.Set;

@RestController
@RequestMapping(path = "/api/currencies")
public class CurrencyController extends AbstractApplicationController{
    private final CurrencyService currencyService;

    private final Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        Set<CurrencyDTO> currencies = currencyService.getAll();
        logger.info("Currencies are returned successfully.");

        return ApplicationResponse.GET_SUCCESS(currencies).getResponseEntity();
    }
}

package vn.elca.training.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.elca.training.common.ApplicationResponse;
import vn.elca.training.model.dto.CountryDTO;
import vn.elca.training.model.dto.PlaceDTO;
import vn.elca.training.service.CountryService;

import java.util.Set;

@RestController
@RequestMapping(path = "/api/countries")
public class CountryController extends AbstractApplicationController {
    private final CountryService countryService;
    private final Logger logger = LoggerFactory.getLogger(CountryController.class);


    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }
    @GetMapping
    public ResponseEntity<Object> getAll() {
        Set<CountryDTO> countries = countryService.getAll();
        logger.info("Countries are returned successfully.");
        return ApplicationResponse.GET_SUCCESS(countries).getResponseEntity();
    }

    @GetMapping("/{countryName}/places")
    public ResponseEntity<Object> getPlacesByCountry(@PathVariable String countryName){
        Set<PlaceDTO> places = countryService.getPlacesByCountry(countryName);
        logger.info("Places from country {} are returned successfully.", countryName);
        return ApplicationResponse.GET_SUCCESS(places).getResponseEntity();
    }
}

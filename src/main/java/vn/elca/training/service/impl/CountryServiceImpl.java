package vn.elca.training.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.model.dto.CountryDTO;
import vn.elca.training.model.dto.CurrencyDTO;
import vn.elca.training.model.dto.PlaceDTO;
import vn.elca.training.model.entity.Country;
import vn.elca.training.model.entity.Place;
import vn.elca.training.repository.CountryRepository;
import vn.elca.training.service.CountryService;
import vn.elca.training.service.PlaceService;
import vn.elca.training.util.ApplicationMapper;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final ApplicationMapper applicationMapper;
    private final PlaceService placeService;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, PlaceService placeService, ApplicationMapper applicationMapper) {
        this.countryRepository = countryRepository;
        this.placeService = placeService;
        this.applicationMapper = applicationMapper;
    }
    @Override
    public Country getCountry(String name){
        Optional<Country> country = countryRepository.findByName(name.toUpperCase());
        return country.orElseThrow(() ->
                new IllegalArgumentException(String.format("Country %s is not existed", name))
        );
    }

    @Override
    public Set<CountryDTO> getAll() {
        Set<Country> countries = countryRepository.getAll();
        return countries.stream().map((applicationMapper::getCountryDTOFromCountry
        )).sorted(Comparator.comparing(CountryDTO::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<PlaceDTO> getPlacesByCountry(String country) {
        Set<Place> places = placeService.getPlacesByCountry(country.toUpperCase());
        return places.stream().map(applicationMapper::getPlaceDTOFromPlace)
                .sorted(Comparator.comparing(PlaceDTO::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }
}

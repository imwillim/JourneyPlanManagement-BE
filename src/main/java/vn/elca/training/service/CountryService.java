package vn.elca.training.service;

import vn.elca.training.model.dto.CountryDTO;
import vn.elca.training.model.dto.PlaceDTO;
import vn.elca.training.model.entity.Country;

import java.util.Set;

public interface CountryService {
    Country getCountry(String name);

    Set<CountryDTO> getAll();

    Set<PlaceDTO> getPlacesByCountry(String country);
}
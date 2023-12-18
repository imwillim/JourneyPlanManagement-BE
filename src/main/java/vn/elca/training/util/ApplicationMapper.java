package vn.elca.training.util;


import org.springframework.stereotype.Component;

import vn.elca.training.model.dto.*;
import vn.elca.training.model.entity.Country;
import vn.elca.training.model.entity.Currency;
import vn.elca.training.model.entity.Journey;
import vn.elca.training.model.entity.Place;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class ApplicationMapper {
    public ApplicationMapper() {
        // Mapper utility class
    }
    public Journey getJourneyFromDTO(RequestBodyJourneyDTO journeyDTO) {
        Journey journey = new Journey();
        journey.setName(journeyDTO.getName());
        journey.setDescription(journeyDTO.getDescription());
        journey.setAmount(journeyDTO.getAmount());
        journey.setStartDate(journeyDTO.getStartDate());
        journey.setEndDate(journeyDTO.getEndDate());
        journey.setStatus(Journey.JourneyStatus.valueOf(journeyDTO.getStatus()
                .replace(" ", "_").toUpperCase()));
        if(journeyDTO.getDay() != null) {
            journey.setDays(journeyDTO.getDay());
        }
        if (journeyDTO.getNight() != null) {
            journey.setNights(journeyDTO.getNight());
        }
        return journey;
    }
    public UpdateJourneyDTO getJourneyFormDTOFromJourney(Journey journey) {
        UpdateJourneyDTO journeyDTO = new UpdateJourneyDTO();
        journeyDTO.setName(journey.getName());
        journeyDTO.setDescription(journey.getDescription());
        if (journey.getAmount() != null ) {
            journeyDTO.setAmount(journey.getAmount());
        }
        journeyDTO.setStartDate(journey.getStartDate());
        if (journey.getAmount() != null) {
            journeyDTO.setEndDate(journey.getEndDate());
        }
        journeyDTO.setStatus(journey.getStatus().toString());
        journeyDTO.setCountry(journey.getCountry().getName());
        journeyDTO.setDay(journey.getDays());
        if (journey.getPlaces() != null) {
            journeyDTO.setPlace(journey.getPlaces().stream().map(Place::getName
            ).collect(Collectors.toList()));
        }
        journeyDTO.setNight(journey.getNights());
        if(journey.getCurrency() != null) {
            journeyDTO.setCurrency(journey.getCurrency().getCode());
        }
        journeyDTO.setVersion(journey.getVersion());
        return journeyDTO;
    }

    public JourneyDTO getJourneyDTOFromJourney(Journey journey) {
        JourneyDTO journeyDTO = new JourneyDTO();
        journeyDTO.setName(journey.getName());
        journeyDTO.setId(journey.getId());
        journeyDTO.setDescription(journey.getDescription());
        if (journey.getAmount() != null ) {
            journeyDTO.setAmount(journey.getAmount());
        }
        journeyDTO.setStartDate(journey.getStartDate());
        if(journey.getEndDate() != null) {
            journeyDTO.setEndDate(journey.getEndDate());
        }
        journeyDTO.setStatus(journey.getStatus().toString());
        journeyDTO.setCountry(journey.getCountry().getName());
        if(journey.getCurrency() != null) {
            journeyDTO.setCurrency(journey.getCurrency().getCode());
        }
        journeyDTO.setVersion(journey.getVersion());
        return journeyDTO;
    }


    public CountryDTO getCountryDTOFromCountry(Country country){
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        return countryDTO;
    }

    public PlaceDTO getPlaceDTOFromPlace(Place place){
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(place.getId());
        placeDTO.setName(place.getName());
        return placeDTO;
    }

    public CurrencyDTO getCurrencyDTOFromCurrency(Currency currency){
        CurrencyDTO currencyDTO = new CurrencyDTO();
        currencyDTO.setId(currency.getId());
        currencyDTO.setCode(currency.getCode());
        return currencyDTO;
    }
}


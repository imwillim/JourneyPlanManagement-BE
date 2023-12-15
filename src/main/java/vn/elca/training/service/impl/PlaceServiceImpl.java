package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.model.entity.Place;
import vn.elca.training.repository.PlaceRepository;
import vn.elca.training.service.PlaceService;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Set<Place> getPlaces(List<String> names) {
        return placeRepository.findPlacesByNames(names.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }

    @Override
    public Set<Place> getPlacesByCountry(String country) {
        return placeRepository.findPlacesByCountry(country);
    }
}

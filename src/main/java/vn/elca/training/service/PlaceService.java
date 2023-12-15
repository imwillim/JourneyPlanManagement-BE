package vn.elca.training.service;

import vn.elca.training.model.entity.Place;

import java.util.List;
import java.util.Set;

public interface PlaceService {

    Set<Place> getPlaces(List<String> names);

    Set<Place> getPlacesByCountry(String country);
}

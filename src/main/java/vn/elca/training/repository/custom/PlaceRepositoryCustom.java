package vn.elca.training.repository.custom;

import vn.elca.training.model.entity.Place;

import java.util.List;
import java.util.Set;

public interface PlaceRepositoryCustom {
    Set<Place> findPlacesByNames(List<String> names);

    Set<Place> findPlacesByCountry(String country);
}
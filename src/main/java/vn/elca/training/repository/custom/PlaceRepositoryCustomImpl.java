package vn.elca.training.repository.custom;


import com.querydsl.jpa.impl.JPAQueryFactory;
import vn.elca.training.model.entity.Place;
import vn.elca.training.model.entity.QPlace;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlaceRepositoryCustomImpl implements PlaceRepositoryCustom{
    @PersistenceContext
    private EntityManager em;
    @Override
    public Set<Place> findPlacesByNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            return Collections.emptySet();
        }

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Place> places = queryFactory
                .selectFrom(QPlace.place)
                .where(QPlace.place.name.in(names))
                .fetch();
        Set<String> validPlaceNames = places.stream()
                .map(Place::getName)
                .collect(Collectors.toSet());
        Set<String> invalidPlaceNames = new HashSet<>(names);
        invalidPlaceNames.removeAll(validPlaceNames);
        if (!invalidPlaceNames.isEmpty()) {
            throw new IllegalArgumentException("Invalid place names: " + invalidPlaceNames);
        }
        return new HashSet<>(places);
    }
    @Override
    public Set<Place> findPlacesByCountry(String country) {
        if (country == null)
            return Collections.emptySet();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        List<Place> places = queryFactory
                .select(QPlace.place)
                .from(QPlace.place)
                .leftJoin(QPlace.place.country).fetchJoin()
                .where(QPlace.place.country.name.eq(country))
                .orderBy(QPlace.place.name.lower().asc())
                .fetch();
        return new HashSet<>(places);
    }
}

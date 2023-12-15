package vn.elca.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Place;
import vn.elca.training.repository.custom.PlaceRepositoryCustom;



@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>, QuerydslPredicateExecutor<Place>, PlaceRepositoryCustom {
}

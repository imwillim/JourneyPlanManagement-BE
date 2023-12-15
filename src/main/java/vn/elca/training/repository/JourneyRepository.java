package vn.elca.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Journey;
import vn.elca.training.repository.custom.JourneyRepositoryCustom;

import java.util.Optional;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long>, JourneyRepositoryCustom {
    Optional<Journey> getById(Long id);
}

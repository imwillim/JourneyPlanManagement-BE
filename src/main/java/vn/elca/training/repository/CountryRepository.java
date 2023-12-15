package vn.elca.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Country;
import vn.elca.training.repository.custom.CountryRepositoryCustom;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>, CountryRepositoryCustom {
    Optional<Country> findByName(String name);
}

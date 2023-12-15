package vn.elca.training.repository.custom;

import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Country;

import java.util.Set;

@Repository
public interface CountryRepositoryCustom {
    Set<Country> getAll();
}

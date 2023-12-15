package vn.elca.training.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Journey;

import java.util.Map;


@Repository
public interface JourneyRepositoryCustom  {
    Page<Journey> findBySearchParams(Map<String, String> searchParams, Pageable page, Integer offset);
}


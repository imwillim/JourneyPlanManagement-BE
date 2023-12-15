package vn.elca.training.service;


import vn.elca.training.model.dto.CreateJourneyDTO;
import vn.elca.training.model.dto.UpdateJourneyDTO;
import vn.elca.training.model.entity.Journey;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

public interface JourneyService {

    void create(CreateJourneyDTO createJourneyDTO);

    void update(Long id, UpdateJourneyDTO updateJourneyDTO);
    void delete(Long id) ;

    Map<String, Object>  getAll(Integer page, Map<String, String> search, String sortBy, String order)
            throws IllegalArgumentException;
    Journey getOne(Long id) throws EntityNotFoundException;

    void deleteMultiple(List<Long>ids) throws EntityNotFoundException;

}
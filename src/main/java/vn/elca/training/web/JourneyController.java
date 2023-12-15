package vn.elca.training.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.elca.training.common.ApplicationResponse;
import vn.elca.training.model.dto.CreateJourneyDTO;
import vn.elca.training.model.dto.UpdateJourneyDTO;
import vn.elca.training.model.entity.Journey;
import vn.elca.training.service.JourneyService;
import vn.elca.training.util.ApplicationMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/journeys")
public class JourneyController extends AbstractApplicationController {
    private final JourneyService journeyService;

    private final ApplicationMapper applicationMapper;

    private final Logger logger = LoggerFactory.getLogger(JourneyController.class);

    @Autowired
    public JourneyController(JourneyService journeyService, ApplicationMapper applicationMapper){
        this.journeyService = journeyService;
        this.applicationMapper = applicationMapper;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getJourney(@PathVariable Long id){
        Journey journey = journeyService.getOne(id);
        logger.info("Journey with id: {} is returned", id);
        return ApplicationResponse.GET_SUCCESS(applicationMapper.getJourneyFormDTOFromJourney(journey)).getResponseEntity();
    }

    @PostMapping
    public ResponseEntity<Object> createJourney(@RequestBody CreateJourneyDTO formJourneyDTO) {
        journeyService.create(formJourneyDTO);
        logger.info("Journey is created successfully.");
        return ApplicationResponse.CREATED_SUCCESS(formJourneyDTO).getResponseEntity();

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateJourney(@PathVariable Long id, @RequestBody UpdateJourneyDTO updateJourneyDTO){
        journeyService.update(id, updateJourneyDTO);
        logger.info("Journey is updated successfully.");
        return ApplicationResponse.UPDATE_SUCCESS(updateJourneyDTO).getResponseEntity();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJourney(@Valid @PathVariable Long id)  {
        journeyService.delete(id);
        logger.info("Delete journey successfully with id {}", id);
        return ApplicationResponse.DELETE_SUCCESS.getResponseEntity();

    }

    @GetMapping("")
    public ResponseEntity<Object> getAllJourney(
            @RequestParam(defaultValue = "startDate") String sortBy,
            @RequestParam(defaultValue = "ASC") String order,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) Map<String, String> searchParams
    ) {
        Map<String, Object> result = journeyService.getAll(page, searchParams, sortBy, order);
        return ApplicationResponse.GET_SUCCESS(result).getResponseEntity();
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteMultipleJourneys(@RequestBody List<Long> ids){
        journeyService.deleteMultiple(ids);
        logger.info("Successfully delete journeys");
        return ApplicationResponse.DELETE_SUCCESS.getResponseEntity();
    }

}

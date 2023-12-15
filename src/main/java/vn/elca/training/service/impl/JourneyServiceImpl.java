package vn.elca.training.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.model.dto.CreateJourneyDTO;
import vn.elca.training.model.dto.UpdateJourneyDTO;
import vn.elca.training.model.entity.Journey;
import vn.elca.training.repository.JourneyRepository;
import vn.elca.training.service.CountryService;
import vn.elca.training.service.CurrencyService;
import vn.elca.training.service.JourneyService;
import vn.elca.training.service.PlaceService;
import vn.elca.training.util.ApplicationMapper;


import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class JourneyServiceImpl implements JourneyService {
    private final ApplicationMapper applicationMapper;

    private final JourneyRepository journeyRepository;

    private static final Integer LIMIT = 5;


    private final CountryService countryService;
    private final PlaceService placeService;

    private final List<String> allowSearchParams = new ArrayList<>(Arrays.asList("country","status","currency","name,description","startDate","fromAmount","toAmount","fromEndDate","toEndDate","toStartDate","fromStartDate","description"));


    private final CurrencyService currencyService;

    private final Logger logger = LoggerFactory.getLogger(JourneyServiceImpl.class);

    @PersistenceContext
    private EntityManager em;


    @Autowired
    public JourneyServiceImpl(JourneyRepository journeyRepository, ApplicationMapper applicationMapper, CountryService countryService, PlaceService placeService,
                              CurrencyService currencyService) {
        this.journeyRepository = journeyRepository;
        this.applicationMapper = applicationMapper;
        this.countryService = countryService;
        this.placeService = placeService;
        this.currencyService = currencyService;
    }

    @Override
    public void create(CreateJourneyDTO createJourneyDTO) {
        validateNullFields(createJourneyDTO);
        if (createJourneyDTO.getEndDate() != null && createJourneyDTO.getDay() != null&& createJourneyDTO.getNight()!= null) {
            processIntervalValidation(createJourneyDTO.getStartDate(), createJourneyDTO.getEndDate(), createJourneyDTO.getDay(), createJourneyDTO.getNight());
        }
        Journey journey = applicationMapper.getJourneyFromDTO(createJourneyDTO);
        journey.setCountry(countryService.getCountry(createJourneyDTO.getCountry()));
        if (createJourneyDTO.getPlace() != null && !createJourneyDTO.getPlace().isEmpty()) {
            journey.setPlaces(placeService.getPlaces(createJourneyDTO.getPlace()));
        }
        if (createJourneyDTO.getCurrency() != null) {
            journey.setCurrency(currencyService.getCurrency(createJourneyDTO.getCurrency()));
        }
        journeyRepository.save(journey);
    }

    private void validateNullFields(CreateJourneyDTO createJourneyDTO) {
        if (createJourneyDTO.getName() == null) {
            throw new IllegalArgumentException("Name should not be null");
        }
        if (createJourneyDTO.getDescription() == null) {
            throw new IllegalArgumentException("Description should not be null");
        }
        if (createJourneyDTO.getStartDate() == null) {
            throw new IllegalArgumentException("Start date should not be null");
        }

        if (createJourneyDTO.getStatus() == null) {
            throw new IllegalArgumentException("Status should not be null");
        }

    }

    @Override
    public void update(Long id, UpdateJourneyDTO updateJourneyDTO) {
        Journey journey = getOne(id);
        logger.info("Successfully get journey with id {}", id);
        if (updateJourneyDTO.getEndDate() != null && updateJourneyDTO.getDay() != null && updateJourneyDTO.getNight() != null) {
            processIntervalValidation(updateJourneyDTO.getStartDate(), updateJourneyDTO.getEndDate(), updateJourneyDTO.getDay(), updateJourneyDTO.getNight());
        }
        Journey newJourney = applicationMapper.getJourneyFromDTO(updateJourneyDTO);
        newJourney.setVersion(journey.getVersion());
        newJourney.setCountry(countryService.getCountry(updateJourneyDTO.getCountry()));
        newJourney.setPlaces(placeService.getPlaces(updateJourneyDTO.getPlace()));
        if (updateJourneyDTO.getCurrency() != null) {
            newJourney.setCurrency(currencyService.getCurrency(updateJourneyDTO.getCurrency()));
        }
        newJourney.setId(journey.getId());
        journeyRepository.save(newJourney);
    }

    @Override
    public void delete(Long id) {
        getOne(id);
        logger.info("Successfully get journey with id {}", id);
        journeyRepository.deleteById(id);
    }


    private void validateDate(LocalDate startDate, LocalDate endDate) {
        if (!startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("End date must be larger than start date");
        }
    }

    private void validateDateNightParams(int day, int night) throws IllegalArgumentException {
        if (day <= 0 || night <= 0)
            throw new IllegalArgumentException("Duration field: Value should be greater than 0");
        if (night > day || day - 1 > night) {
            throw new IllegalArgumentException("Invalid value for night");
        }
    }

    private void validateDuration(int day, int duration) throws IllegalArgumentException {
        if (day > duration) {
            throw new IllegalArgumentException("Duration field: Day does not match with Start date and End date.");
        }
    }

    private void processIntervalValidation(LocalDate startDate, LocalDate endDate, int day, int night) {
        validateDate(startDate, endDate);
        validateDateNightParams(day, night);
        Period period = Period.between(startDate, endDate);
        validateDuration(day, period.getDays() + 1);
    }

    @Override
    public void deleteMultiple(List<Long> ids) throws EntityNotFoundException{
        List<Journey> journeys =journeyRepository.findAllById(ids);
        validateJourneys(journeys, ids);
        logger.info("Successfully validate journeys before delete");
        journeyRepository.deleteInBatch(journeys);
    }

    @Override
    public Journey getOne(Long id) throws EntityNotFoundException {
        return journeyRepository.getById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id: %d is not found", id)));
    }

    @Override
    public Map<String, Object> getAll(Integer page, Map<String, String> searchBy, String sortBy, String order)
            throws IllegalArgumentException {
        Integer currentOffset = page * LIMIT;


        Pageable pageable = null;

        validateOrderValue(order);
        validateSortByValue(sortBy);

        if (Objects.equals(sortBy, "country")) {
            pageable = PageRequest.of(page, LIMIT, Sort.by(Sort.Direction.fromString(order), "country.name"));
        } else if (Objects.equals(sortBy, "currency")) {
            pageable = PageRequest.of(page, LIMIT, Sort.by(Sort.Direction.fromString(order), "currency.code"));
        } else {
            pageable = PageRequest.of(page, LIMIT, Sort.by(Sort.Direction.fromString(order), sortBy));
        }
        Page<Journey> pageTuts = null;
        processSearchParams(searchBy);
        if (searchBy.isEmpty()) {
            pageTuts = journeyRepository.findAll(pageable);
        } else {
            pageTuts = journeyRepository.findBySearchParams(searchBy, pageable, currentOffset);
        }
        return enrichPageData(pageTuts);
    }

    private void validateSearchParamsValue(Map<String, String> searchBy) throws IllegalArgumentException {
        for (Map.Entry<String, String> entry : searchBy.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            switch (key) {
                case "fromStartDate":
                case "toStartDate":
                case "fromEndDate":
                case "toEndDate": {
                    validateDate(value);
                    break;
                }
                case "fromAmount":
                case "toAmount": {
                    validateAmount(value);
                    break;
                }
                case "status":
                    if (!isValidStatus(value)) {
                        throw new IllegalArgumentException("Invalid status");
                    }
                    break;
                case "country":
                case "currency":
                    if (!isValidAlphabeticString(value)) {
                        throw new IllegalArgumentException("Can contain only alphabet letter");
                    }
                    break;
                default:
                    break;
            }
        }

    }


    private void processSearchParams(Map<String, String> searchBy) throws IllegalArgumentException {
        searchBy.remove("sortBy");
        searchBy.remove("page");
        searchBy.remove("order");
        for (String params: searchBy.keySet()){
            if (!allowSearchParams.contains(params)){
                throw new IllegalArgumentException(String.format("Param %s is not allowed for search", params));
            }
        }
        validateSearchParamsValue(searchBy);

    }

    private void validateDate(String value) {
        try {
            LocalDate.parse(value);
        } catch (DateTimeParseException exception) {
            logger.info(exception.getMessage());
            throw new IllegalArgumentException(value + " is not a valid date.");
        }
    }

    private void validateAmount(String value) {
        try {
            Double.parseDouble(value);
        }
        catch (NumberFormatException exception) {
            logger.info(exception.getMessage());
            throw new IllegalArgumentException(value + " is not a valid number for amount.");
        }
    }

    private void validateSortByValue(String value) {
        if (!allowSearchParams.contains(value)){
            throw new IllegalArgumentException(String.format("Value %s is not allowed for sort by", value));
        }
    }

    private void validateOrderValue(String value) {
        if (!value.equalsIgnoreCase("DESC") && !value.equalsIgnoreCase("ASC")){
            throw new IllegalArgumentException(String.format("Value %s is not allowed for sort by", value));
        }
    }

    private Map<String, Object> enrichPageData(Page<Journey> page) {
        Map<String, Object> result = new HashMap<>();
        if (page.getTotalPages() < page.getNumber() + 1) {
            result.put("currentPage", page.getTotalPages());
        } else {
            result.put("currentPage", page.getNumber() + 1);
        }
        result.put("totalPage", page.getTotalPages());
        result.put("journeys", page.getContent().stream().map(applicationMapper::getJourneyDTOFromJourney));
        result.put("hasNextPage", page.hasNext());
        result.put("totalElements", page.getTotalElements());
        return result;
    }

    private boolean isValidIntegerBounds(String key) {
        String[] values = key.split(",");
        if (values.length == 2) {
            try {
                int lowerBound = Integer.parseInt(values[0]);
                int upperBound = Integer.parseInt(values[1]);

                return upperBound >= lowerBound;
            } catch (NumberFormatException e) {

                logger.info("Can only contain valid number");
                return false;
            }
        }
        logger.info("Must contain upper and lower values");
        return false;
    }

    private boolean isValidDateBounds(String key) {
        String[] values = key.split(",");
        if (values.length == 2) {
            try {
                LocalDate lowerBoundDate = LocalDate.parse(values[0]);
                LocalDate upperBoundDate = LocalDate.parse(values[1]);

                return !upperBoundDate.isBefore(lowerBoundDate);
            } catch (DateTimeParseException e) {
                logger.info("Only accept date in 'yyyy-mm-dd format!'");
                return false;
            }
        }
        logger.info("Must contain upper and lower values");
        return false;
    }

    private boolean isValidStatus(String status) {
        return status.equalsIgnoreCase("planning") || status.equalsIgnoreCase("in_progress") || status.equalsIgnoreCase("finished");
    }

    private boolean isValidAlphabeticString(String input) {
        return input.matches("^[a-zA-Z]+$");
    }

    private void validateJourneys(List<Journey> journeys, List<Long>ids){
        Set<Long> existedJourneys = journeys.stream()
                .map(Journey::getId)
                .collect(Collectors.toSet());
        Set<Long> unexistedJourneys = new HashSet<>(ids);
        unexistedJourneys.removeAll(existedJourneys);
        if (!unexistedJourneys.isEmpty()) {
            throw new EntityNotFoundException("Journey(s) with ids are not found: " + unexistedJourneys);
        }
    }
}
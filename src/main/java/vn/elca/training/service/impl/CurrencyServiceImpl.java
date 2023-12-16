package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.model.dto.CurrencyDTO;
import vn.elca.training.model.entity.Currency;
import vn.elca.training.repository.CurrencyRepository;
import vn.elca.training.service.CurrencyService;
import vn.elca.training.util.ApplicationMapper;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final ApplicationMapper applicationMapper;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository, ApplicationMapper applicationMapper) {
        this.currencyRepository = currencyRepository;
        this.applicationMapper = applicationMapper;
    }

    @Override
    public Currency getCurrency(String code) throws IllegalArgumentException{
        return currencyRepository.findByCode(code.toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Currency %s code is invalid", code)));
    }

    @Override
    public Set<CurrencyDTO> getAll() {
        List<Currency> currencies = currencyRepository.findAll();
        return currencies.stream().map(applicationMapper::getCurrencyDTOFromCurrency)
                .sorted(Comparator.comparing(CurrencyDTO::getCode))
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }


}

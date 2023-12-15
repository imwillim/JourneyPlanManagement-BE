package vn.elca.training.service;

import vn.elca.training.model.dto.CurrencyDTO;
import vn.elca.training.model.entity.Currency;

import java.util.Set;

public interface CurrencyService {
    Currency getCurrency(String code) throws IllegalArgumentException;

    Set<CurrencyDTO> getAll();
}

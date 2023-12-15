package vn.elca.training.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RequestBodyJourneyDTO {
    private String name;
    private String description;
    private String country;
    private List<String> place;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer day;
    private Integer night;
    private String currency;
    private BigDecimal amount;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getPlace() {
        return place;
    }

    public void setPlace(List<String> place) {
        this.place = place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getNight() {
        return night;
    }

    public void setNight(Integer night) {
        this.night = night;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RequestBodyJourneyDTO(String name, String description, String country, List<String> place, LocalDate startDate, LocalDate endDate, Integer day, Integer night, String currency, BigDecimal amount, String status) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;
        this.day = day;
        this.night = night;
        this.currency = currency;
        this.amount = amount;
        this.status = status;
    }

    public RequestBodyJourneyDTO() {
    }
}

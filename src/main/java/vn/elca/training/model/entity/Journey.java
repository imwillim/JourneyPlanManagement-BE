package vn.elca.training.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Journey extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "journey_place",
            joinColumns = @JoinColumn(name = "journey_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private Set<Place> places;

    @Column(nullable = false)
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToOne
    private Currency currency;

    @Column(name = "amount", precision = 19, scale = 2)
    private BigDecimal amount;

    @Column
    private int days;

    @Column
    private int nights;

    public enum JourneyStatus {
        PLANNING, FINISHED, IN_PROGRESS
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public JourneyStatus status;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public JourneyStatus getStatus() {
        return status;
    }


    public void setStatus(JourneyStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Journey{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country=" + country +
                ", places=" + places +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", currency=" + currency +
                ", amount=" + amount +
                ", days=" + days +
                ", nights=" + nights +
                ", status=" + status +
                '}';
    }
}
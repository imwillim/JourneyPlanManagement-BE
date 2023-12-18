package vn.elca.training.model.dto;


import java.util.Objects;

public class CountryDTO implements Comparable<CountryDTO>{
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDTO() {
    }

    public CountryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(CountryDTO other) {
        return Objects.compare(this.name, other.name, String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CountryDTO that = (CountryDTO) obj;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
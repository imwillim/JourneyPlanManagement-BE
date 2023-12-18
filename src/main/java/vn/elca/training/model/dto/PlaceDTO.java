package vn.elca.training.model.dto;

import vn.elca.training.model.entity.Place;

import java.util.Objects;

public class PlaceDTO implements Comparable<PlaceDTO>{
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

    public PlaceDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PlaceDTO that = (PlaceDTO) obj;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(PlaceDTO other) {
        return Objects.compare(this.name, other.getName(), String.CASE_INSENSITIVE_ORDER);
    }
}

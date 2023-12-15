package vn.elca.training.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Country extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country")
    private List<Place> places;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setCities(List<Place> places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
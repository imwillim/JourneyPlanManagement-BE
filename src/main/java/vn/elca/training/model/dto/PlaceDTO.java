package vn.elca.training.model.dto;

public class PlaceDTO {
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
}

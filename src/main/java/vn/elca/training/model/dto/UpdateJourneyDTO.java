package vn.elca.training.model.dto;

public class UpdateJourneyDTO extends RequestBodyJourneyDTO{
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

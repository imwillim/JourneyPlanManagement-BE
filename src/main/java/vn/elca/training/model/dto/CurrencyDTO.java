package vn.elca.training.model.dto;

public class CurrencyDTO {
    private String code;
    private Long id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyDTO() {
    }

    public CurrencyDTO(String code, Long id) {
        this.code = code;
        this.id = id;
    }
}

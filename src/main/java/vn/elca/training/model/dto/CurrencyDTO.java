package vn.elca.training.model.dto;

import java.util.Objects;

public class CurrencyDTO implements Comparable<CurrencyDTO>{
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
    @Override
    public int compareTo(CurrencyDTO other) {
        return Objects.compare(this.code, other.code, String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CurrencyDTO that = (CurrencyDTO) obj;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

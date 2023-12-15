package vn.elca.training.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Currency extends BaseEntity{
    @Column(length = 3, nullable = false, unique = true)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private String name;
}

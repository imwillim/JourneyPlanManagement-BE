package vn.elca.training.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "NUMBER(19,0)")
    protected Long id;

    @Column(nullable = false, columnDefinition = "NUMBER(10,0)")
    @Version
    private long version;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if(!((object) instanceof BaseEntity)) return false;
        BaseEntity checkedObject = (BaseEntity) object;
        return id.equals(checkedObject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

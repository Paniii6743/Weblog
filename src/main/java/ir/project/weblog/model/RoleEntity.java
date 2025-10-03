package ir.project.weblog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class RoleEntity extends BaseEntity {
    private Role name;

    @Enumerated(EnumType.STRING)
    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}

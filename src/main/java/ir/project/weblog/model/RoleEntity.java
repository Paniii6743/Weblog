package ir.project.weblog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
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

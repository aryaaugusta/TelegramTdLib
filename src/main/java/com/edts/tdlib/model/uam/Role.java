package com.edts.tdlib.model.uam;


import com.edts.tdlib.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role extends BaseEntity {
    private String name = "";
    @OneToMany(
            mappedBy = "role",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE
    )
    private Set<AccessRight> accessRights = new HashSet<>();

    public Set<AccessRight> getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(Set<AccessRight> accessRights) {
        this.accessRights = accessRights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", accessRights=" + accessRights +
                '}';
    }
}

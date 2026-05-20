package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Planet")
public class Planet {
    @Id
    private String id;

    @Column(name = "name", length = 500)
    private String name;

    public Planet() {}

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

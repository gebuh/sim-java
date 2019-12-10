package com.boose.sim.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "animals", schema = "main", catalog = "")
public class AnimalsEntity {
    private short id;
    private String name;
    private String species;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "species")
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalsEntity that = (AnimalsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(species, that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species);
    }
}

package com.adrianpapuc.petclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String adress, String city, String tehephone, Set<Pet> pets) {
        super(id,firstName, lastName);
        this.adress = adress;
        this.city = city;
        this.tehephone = tehephone;
        this.pets = pets;
    }

    @Column(name = "adress")
    private String adress;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String tehephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}

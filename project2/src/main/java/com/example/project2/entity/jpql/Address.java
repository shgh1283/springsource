package com.example.project2.entity.jpql;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;
}

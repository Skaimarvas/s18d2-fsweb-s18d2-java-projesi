package com.example.s18d2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "vegetable", schema = "s18d2")
public class Vegetable extends Plant{



    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;
}

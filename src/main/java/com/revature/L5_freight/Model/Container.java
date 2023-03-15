package com.revature.L5_freight.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * The @Entity is provided by Spring Data to convert this class into an ORM entity with a relationship to the
 * database. All other annotations have been provided by Lombok.
 *
 * Nothing in this class needs to be changed.
 */
@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @Column annotations actually aren't necessary. all fields will be made columns by default.
    private String contents;
    private double weight;
}

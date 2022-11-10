package com.cydeo.entity;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@Where(clause = "is_deleted=false")
public class Role extends BaseEntity {

    private String description;

}

package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@Where(clause = "is_deleted=false")// any repo which is using user entity what ever add this
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;

    @ManyToOne // many users can have same roles-- one user can not have many roles.
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;



}

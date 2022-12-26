package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isDeleted = false;

    // ignore this, is means that keep what comes from db
    // this field can not be null and do not update this filed
    @Column(nullable = false,updatable = false)
    private LocalDateTime insertDateTime;
    @Column(nullable = false,updatable = false)
    private Long insertUserId;
    @Column(nullable = false)
    private LocalDateTime lastUpdateDateTime;
    @Column(nullable = false)
    private Long lastUpdateUserId;



    // this method will be executed when we create user/object
    @PrePersist
    private void onPrePersist(){
        this.insertDateTime = LocalDateTime.now();
        this.lastUpdateDateTime=LocalDateTime.now();
        this.insertUserId=1L;
        this.lastUpdateUserId=1L;
        // this is hardcoded since we do not have data/ it is not connected to database
    }


    // this method will be executed when we updated user/object
    @PreUpdate
    private void onPreUpdate(){
        this.lastUpdateDateTime=LocalDateTime.now();
        this.lastUpdateUserId=1L;
    }




}

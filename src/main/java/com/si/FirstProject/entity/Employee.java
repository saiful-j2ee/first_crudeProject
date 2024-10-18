package com.si.FirstProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name ="employee_id" )
    private long id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_address")
    private String address;

   /* public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/
}

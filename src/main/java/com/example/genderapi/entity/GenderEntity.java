package com.example.genderapi.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "gender")
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer count;
    @Column
    private String gender;
    @Column
    private String name;
    @Column
    private Double probability;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }


    @Override
    public String toString() {
        return "GenderEntity{" +
                "id=" + id +
                ", count=" + count +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", probability=" + probability +
                '}';
    }
}

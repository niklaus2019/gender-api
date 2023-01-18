package com.example.genderapi.dto;


import java.lang.String;

public final class GenderDto {
    private Integer count;

    private String gender;

    private String name;

    private Double probability;

    public GenderDto() {
    }

    public GenderDto(Integer count, String gender, String name, Double probability) {
        this.count = count;
        this.gender = gender;
        this.name = name;
        this.probability = probability;
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


}

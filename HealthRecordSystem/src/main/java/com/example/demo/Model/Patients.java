package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String password;
    private String healthIssue;

    // Medical fields
    private String bp;
    private double hemoglobin;
    private int platelets;
    private String lymphocytes;
    private int sgot;
    private int sgpt;

    public Patients() {}

    public Patients(String name, int age, String gender, String email, String phone, String password, String healthIssue,
                    String bp, double hemoglobin, int platelets, String lymphocytes, int sgot, int sgpt) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.healthIssue = healthIssue;
        this.bp = bp;
        this.hemoglobin = hemoglobin;
        this.platelets = platelets;
        this.lymphocytes = lymphocytes;
        this.sgot = sgot;
        this.sgpt = sgpt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getHealthIssue() { return healthIssue; }
    public void setHealthIssue(String healthIssue) { this.healthIssue = healthIssue; }

    public String getBp() { return bp; }
    public void setBp(String bp) { this.bp = bp; }

    public double getHemoglobin() { return hemoglobin; }
    public void setHemoglobin(double hemoglobin) { this.hemoglobin = hemoglobin; }

    public int getPlatelets() { return platelets; }
    public void setPlatelets(int platelets) { this.platelets = platelets; }

    public String getLymphocytes() { return lymphocytes; }
    public void setLymphocytes(String lymphocytes) { this.lymphocytes = lymphocytes; }

    public int getSgot() { return sgot; }
    public void setSgot(int sgot) { this.sgot = sgot; }

    public int getSgpt() { return sgpt; }
    public void setSgpt(int sgpt) { this.sgpt = sgpt; }
}

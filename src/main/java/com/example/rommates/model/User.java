package com.example.rommates.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private Integer age;
    private Integer academicYear;
    private String priceRange;
    private String shortDescription;
    private String longDescription;
    private String login;
    private String password;
    private String contactInformation;
    private Boolean superadmin;





    @OneToMany(mappedBy = "user")
    private List<ListUser> listUsers;

    // Getters
    public Boolean getSuperadmin() {
        return superadmin;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public List<ListUser> getListUsers() {
        return listUsers;
    }

    // Setters
    public void setSuperadmin(Boolean superadmin) {

        this.superadmin = superadmin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public void setListUsers(List<ListUser> listUsers) {
        this.listUsers = listUsers;
    }

    // equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                ", academicYear='" + academicYear + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", listUsers=" + listUsers +
                '}';
    }


}

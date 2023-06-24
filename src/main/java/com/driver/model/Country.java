// Note: Do not write @Enumerated annotation above CountryName in this model.
package com.driver.model;

import javax.persistence.*;
@Table
@Entity
public class Country{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private CountryName countryname;
    private String code;

    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider;

    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
    private User user;

    public Country() {
    }

    public Country(int id, CountryName countryname, String code, ServiceProvider serviceProvider, User user) {
        this.id = id;
        this.countryname = countryname;
        this.code = code;
        this.serviceProvider = serviceProvider;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CountryName getCountryname() {
        return countryname;
    }

    public void setCountryname(CountryName countryname) {
        this.countryname = countryname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<ServiceProvider> serviceProviderList = new ArrayList<>();

    public Admin() {
    }

    public Admin(int id, String userName, String password, List<ServiceProvider> serviceProviderList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.serviceProviderList = serviceProviderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }
}

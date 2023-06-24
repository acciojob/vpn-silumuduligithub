package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
        Admin admin = new Admin();
        admin.setUserName(username);
        admin.setPassword(password);
        adminRepository1.save(admin);
        return admin;
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(providerName);
        Admin admin = adminRepository1.findById(adminId).get();
        admin.getServiceProviderList().add(serviceProvider);
        serviceProvider.setAdmin(admin);
        serviceProviderRepository1.save(serviceProvider);
        return admin;
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
        if(countryName.length() != 3){
            throw new Exception("Country not found");
        }
        countryName = countryName.toLowerCase();
        ServiceProvider serviceProvider = serviceProviderRepository1.findById(serviceProviderId).get();
        if(countryName.equals("ind") || countryName.equals("aus") || countryName.equals("usa") || countryName.equals("chi") || countryName.equals("jpn")){
            Country country = new Country();
            if(countryName.equals("ind")){
                country.setCountryName(CountryName.IND);
                country.setServiceProvider(serviceProvider);
                serviceProvider.getCountryList().add(country);
            }else if(countryName.equals("aus")){
                country.setCountryName(CountryName.AUS);
                country.setServiceProvider(serviceProvider);
                serviceProvider.getCountryList().add(country);
            }else if(countryName.equals("usa")){
                country.setCountryName(CountryName.USA);
                country.setServiceProvider(serviceProvider);
                serviceProvider.getCountryList().add(country);
            }else if(countryName.equals("chi")){
                country.setCountryName(CountryName.CHI);
                country.setServiceProvider(serviceProvider);
                serviceProvider.getCountryList().add(country);
            }else{
                country.setCountryName(CountryName.JPN);
                country.setServiceProvider(serviceProvider);
                serviceProvider.getCountryList().add(country);
            }
        }else{
            throw new Exception("Country not found");
        }
        serviceProviderRepository1.save(serviceProvider);
        return serviceProvider;
    }
}

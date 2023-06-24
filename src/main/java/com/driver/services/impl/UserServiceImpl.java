package com.driver.services.impl;

import com.driver.model.CountryName;
import com.driver.model.User;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(countryName.equals("IND")){
            user.setOriginalIp(CountryName.IND.toCode()+"."+user.getId());
        }else if(countryName.equals("USA")){
            user.setOriginalIp(CountryName.USA.toCode()+"."+user.getId());
        }else if(countryName.equals("AUS")){
            user.setOriginalIp(CountryName.AUS.toCode()+"."+user.getId());
        }else if(countryName.equals("CHI")){
            user.setOriginalIp(CountryName.CHI.toCode()+"."+user.getId());
        }else if(countryName.equals("JPN")){
            user.setOriginalIp(CountryName.JPN.toCode()+"."+user.getId());
        }
        user.setConnected(false);
        user.setMaskedIp(null);
        userRepository3.save(user);
        return user;
    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {
        User user = userRepository3.findById(userId).get();
        user.getServiceProviderList().add(serviceProviderRepository3.findById(serviceProviderId).get());
        userRepository3.save(user);
        return user;
    }
}

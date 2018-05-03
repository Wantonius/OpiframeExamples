/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.service;

import com.opiframe.java.ReactiveCarShop.domain.HillBilly;
import com.opiframe.java.ReactiveCarShop.domain.IUserRepo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author Oula
 */
@Service
public class HillBillyService {

    @Autowired
    IUserRepo userRepo;

    private Map<String, HillBilly> loggedUsers;

    private boolean isFound;
    private String token;

    public HillBillyService() {
        loggedUsers = new HashMap<>();
        token = "";
    }

    public Mono<HillBilly> findById(String id) {
        return userRepo.findById(id);
    }

    public Mono<HillBilly> findByUserName(String name) {
        if (!"".equals(name) && name != null) {
            return userRepo.findByUserName(name);
        }
        return null;
    }

    public String login(String userName, String passphrase) {
        Mono<HillBilly> user = this.findByUserName(userName);
        if (user != null) {
            user.hasElement().subscribe(data -> this.isFound = data);
            if (this.isFound) {
                user.subscribe(data -> {
                    if (data.getPassphrase() == null ? passphrase == null : data.getPassphrase().equals(passphrase)) {
                        this.token = Tokenizer.createToken();
                        this.loggedUsers.put(this.token, data);
                    }
                });
                if (token != "") {
                    String temp = this.token;
                    this.token = "";
                    return temp;
                }
            }
        }
        return "";
    }

    public boolean logout(String token) {
        if (loggedUsers.containsKey(token)) {
            loggedUsers.remove(token);
            return true;
        }
        return false;
    }

    public boolean isUserLogged(String token) {
        if (loggedUsers.containsKey(token)) {
            return true;
        }
        return false;
    }

    public boolean register(HillBilly user) {
        try {
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }        
    }
}

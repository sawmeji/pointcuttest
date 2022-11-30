package com.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MyAccountService {

    public void create(int amount){
        System.out.println("Create Account with :: "+amount);
    }
}

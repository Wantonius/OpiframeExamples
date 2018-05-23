/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.service;

import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author Oula
 */
public class Tokenizer {

    public static String createToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[256];
        random.nextBytes(bytes);

        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        return token;
    }
}

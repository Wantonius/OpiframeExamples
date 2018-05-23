/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.HelloReactiveWeb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Oula
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private String payload;
    private String target;
    private String sender;
}

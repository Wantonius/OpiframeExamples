/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.currencyconverter;

/**
 *
 * @author Opiframe
 */
public class EuroConverter implements ICurrencyConvertable {
  
  @Override
  public double convert(int currencyType, double amount) {
    switch(currencyType){
      case 1:
        return amount / Rates.EURO_TO_DOLLAR;
      case 2:
        return amount;
      case 3:
        return amount / Rates.EURO_TO_YEN;
      default:
        return amount;
    }
  } 
}

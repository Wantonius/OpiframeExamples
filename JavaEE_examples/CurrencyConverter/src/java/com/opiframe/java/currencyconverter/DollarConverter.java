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
public class DollarConverter implements ICurrencyConvertable{

  @Override
  public double convert(int currencyType, double amount) {
    switch(currencyType){
      case 1:
        return amount;
      case 2:
        return amount / Rates.DOLLAR_TO_EURO;
      case 3:
        return amount / Rates.DOLLAR_TO_YEN;
      default:
        return amount;
    }
  }  
}

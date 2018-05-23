/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.currencyconverter;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Opiframe
 */
@Named(value = "currencyBean")
@RequestScoped
public class CurrencyBean {
  
  @Inject @CurrenciesAnnotation(Currencies.DOLLAR) ICurrencyConvertable dollar;
  @Inject @CurrenciesAnnotation(Currencies.EURO) ICurrencyConvertable euro;
  @Inject @CurrenciesAnnotation(Currencies.YEN) ICurrencyConvertable yen;
  
  private double currencyAmount;
  private int currencyType;
  private double asDollar, asEuro, asYen;
  /**
   * Creates a new instance of CurrencyBean
   */
  public CurrencyBean() {
  }

  /**
   * @return the currencyAmount
   */
  public double getCurrencyAmount() {
    return currencyAmount;
  }

  /**
   * @param currencyAmount the currencyAmount to set
   */
  public void setCurrencyAmount(double currencyAmount) {
    this.currencyAmount = currencyAmount;
  }

  /**
   * @return the currencyType
   */
  public int getCurrencyType() {
    return currencyType;
  }

  /**
   * @param currencyType the currencyType to set
   */
  public void setCurrencyType(int currencyType) {
    this.currencyType = currencyType;
  }

  /**
   * @return the asDollar
   */
  public double getAsDollar() {
    return dollar.convert(currencyType, currencyAmount);
  }

  /**
   * @param asDollar the asDollar to set
   */
  public void setAsDollar(double asDollar) {
    this.asDollar = asDollar;
  }

  /**
   * @return the asEuro
   */
  public double getAsEuro() {
    return euro.convert(currencyType, currencyAmount);
  }

  /**
   * @param asEuro the asEuro to set
   */
  public void setAsEuro(double asEuro) {
    this.asEuro = asEuro;
  }

  /**
   * @return the asYen
   */
  public double getAsYen() {
    return yen.convert(currencyType, currencyAmount);
  }

  /**
   * @param asYen the asYen to set
   */
  public void setAsYen(double asYen) {
    this.asYen = asYen;
  }
  
}

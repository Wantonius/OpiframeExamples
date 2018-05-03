/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.currencyconverter;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Opiframe
 */
@SessionScoped
public class CurrencyConverterFactory implements Serializable {

  private DollarConverter dollarConverter = null;
  private EuroConverter euroConverter = null;
  private YenConverter yenConverter = null;

  @Produces
  @CurrenciesAnnotation(Currencies.DOLLAR)
  public ICurrencyConvertable getDollarConverter() {
    if (dollarConverter == null) {
      dollarConverter = new DollarConverter();
    }
    return dollarConverter;
  }

  @Produces
  @CurrenciesAnnotation(Currencies.EURO)
  public ICurrencyConvertable getEuroConverter() {
    if (euroConverter == null) {
      euroConverter = new EuroConverter();
    }
    return euroConverter;
  }

  @Produces
  @CurrenciesAnnotation(Currencies.YEN)
  public ICurrencyConvertable getYenConverter() {
    if (yenConverter == null) {
      yenConverter = new YenConverter();
    }
    return yenConverter;
  }
}

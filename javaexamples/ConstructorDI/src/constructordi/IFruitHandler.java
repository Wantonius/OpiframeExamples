/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructordi;

/**
 *
 * @author erno
 */
public interface IFruitHandler {
    public static final String APPLES = "Apple";
    public static final String ORANGES = "Orange";
    public static final String BANANAS = "Banana";
    public String getFruitType();
    public int getNumberOfFruits();
    public void setNumberOfFruits(int fruits);
}

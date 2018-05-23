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
public class Bananas implements IFruitHandler {
    
    private int numberOfFruits;
    @Override
    public String getFruitType() {
        return IFruitHandler.BANANAS;
    }

    @Override
    public int getNumberOfFruits() {
        return this.numberOfFruits;
    }

    @Override
    public void setNumberOfFruits(int fruits) {
        this.numberOfFruits = fruits;
    }
    @Override
    public String toString() {
        return ""+this.numberOfFruits+" "+this.getFruitType();
    }
    
}

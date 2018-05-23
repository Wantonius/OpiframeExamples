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
public class FruitManager {
    private IFruitHandler currentFruit;

    public FruitManager() {
        
    }
    
    public FruitManager(IFruitHandler handler) {
        this.currentFruit = handler;
    }
    public IFruitHandler getCurrentFruit() {
        return currentFruit;
    }

    public void setCurrentFruit(IFruitHandler currentFruit) {
        this.currentFruit = currentFruit;
    }
    
    public String getCurrentFruitType() {
        return currentFruit.getFruitType();
    }
    
    public void setNumberOfFruits(int fruits) {
        currentFruit.setNumberOfFruits(fruits);
    }
    
    public int getNumberOfFruits(){
        return currentFruit.getNumberOfFruits();
    }
}

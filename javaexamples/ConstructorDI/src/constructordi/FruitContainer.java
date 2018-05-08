/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructordi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erno
 */
public class FruitContainer {
    private List<FruitManager> managerList = new ArrayList<>();   
    private List<IFruitHandler> fruitList = new ArrayList<>();
    
    public FruitManager getManager(String fruit) {
        for (FruitManager manager : managerList) {
             if (manager.getCurrentFruit().getFruitType().isEmpty()) {
                 continue;
             } else if (manager.getCurrentFruit().getFruitType().equals(fruit)) {
                 return manager;
             }
        }
        IFruitHandler tempfruit = null;
        if (fruit.equals(IFruitHandler.APPLES)) {
            tempfruit  = new Apples();
        }
        if (fruit.equals(IFruitHandler.BANANAS)) {
            tempfruit  = new Bananas();
        }
        if (fruit.equals(IFruitHandler.ORANGES)) {
            tempfruit  = new Oranges();
        }
        fruitList.add(tempfruit);
        FruitManager temp = new FruitManager(tempfruit);
        managerList.add(temp);
        return temp;  
    }
    
    public void removeManager(FruitManager manager) {
        if (managerList.contains(manager)) {
            managerList.remove(manager);
        }
    }
    
    public int sizeOfList() {
        return managerList.size();
    }
    
    
}

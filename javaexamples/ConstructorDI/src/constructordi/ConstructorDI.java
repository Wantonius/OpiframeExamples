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
public class ConstructorDI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FruitContainer container = new FruitContainer();
        FruitManager appleManager = container.getManager(IFruitHandler.APPLES);
        FruitManager orangeManager = container.getManager(IFruitHandler.ORANGES);
        FruitManager bananaManager = container.getManager(IFruitHandler.BANANAS);
        FruitManager appleManager2 = container.getManager(IFruitHandler.APPLES);
        FruitManager orangeManager2 = container.getManager(IFruitHandler.ORANGES);
        FruitManager bananaManager2 = container.getManager(IFruitHandler.BANANAS);
        appleManager.setNumberOfFruits(5);
        orangeManager.setNumberOfFruits(7);
        bananaManager.setNumberOfFruits(11);
        System.out.println(appleManager.getCurrentFruit());
        System.out.println(orangeManager.getCurrentFruit());    
        System.out.println(bananaManager.getCurrentFruit()); 
        System.out.println(appleManager2.getCurrentFruit());         
        System.out.println(orangeManager2.getCurrentFruit());    
        System.out.println(bananaManager2.getCurrentFruit());   
        System.out.println("Number of managers:"+container.sizeOfList());
    }
    
}

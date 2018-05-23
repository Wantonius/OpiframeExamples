/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singletonexample;

/**
 *
 * @author erno
 */
public class BananaGenerator {
    
    private static Banana banana = null;

    public static Banana singletonBanana() {
        if (banana != null) {
            return banana;
        } else {
            banana = new Banana();
            return banana;
        }
    }
    

}

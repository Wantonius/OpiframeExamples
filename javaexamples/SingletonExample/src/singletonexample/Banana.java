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
public class Banana {
    private String bananaName;

    public String getBananaName() {
        return bananaName;
    }

    public void setBananaName(String bananaName) {
        this.bananaName = bananaName;
    }
    
    public synchronized void accessDatabase() {
        
    }
}

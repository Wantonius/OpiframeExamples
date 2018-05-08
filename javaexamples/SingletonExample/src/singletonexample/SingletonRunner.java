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
public class SingletonRunner {
    
    Banana banana;
    Banana banana2;
    public void run() {
        banana = BananaGenerator.singletonBanana();
        banana.setBananaName("MyBanana");
        banana2 = BananaGenerator.singletonBanana();
        System.out.println(banana2.getBananaName());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerinjectordi.service;

/**
 *
 * @author erno
 */
public class WindowWashService implements Service{

    @Override
    public void processService() {
        System.out.println("Washing your windows");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerinjectordi.injector;

import containerinjectordi.container.Container;
import containerinjectordi.service.Service;
import containerinjectordi.service.WindowWashService;
import java.util.List;

/**
 *
 * @author erno
 */
public class WindowwashInjector implements Injector {
    private final Container container;
    
    public WindowwashInjector(Container container) {
        this.container = container;
    }
    
    @Override
    public Service getServiceFromContainer() {
        System.out.println("Injecting Window Wash Service!");
        List<Service> tempServiceList = container.getServiceList();
        for (Service service: tempServiceList) 
            if (service instanceof WindowWashService) {
                return service;
        }
        System.out.println("Creating new since none exists");
        WindowWashService temp = new WindowWashService();
        container.addService(temp);
        return temp;
    }
    
    @Override
    public String getType() {
        return Injector.WINDOWWASH;
    }
}

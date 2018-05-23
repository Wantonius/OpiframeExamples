/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerinjectordi.injector;

import containerinjectordi.container.Container;
import containerinjectordi.service.CarwashService;
import containerinjectordi.service.Service;
import java.util.List;

/**
 *
 * @author erno
 */
public class CarwashInjector implements Injector{
    
    private final Container container;
    
    public CarwashInjector(Container container) {
        this.container = container;
    }
    
    @Override
    public Service getServiceFromContainer() {
        System.out.println("Injecting Car Wash Service!");
        List<Service> tempServiceList = container.getServiceList();
        for (Service service: tempServiceList) 
            if (service instanceof CarwashService) {
                return service;
        }
        System.out.println("Creating new since none exists");
        CarwashService temp = new CarwashService();
        container.addService(temp);
        return temp;
    }
    @Override
    public String getType() {
        return Injector.CARWASH;
    }
}

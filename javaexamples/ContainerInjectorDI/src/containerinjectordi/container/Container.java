/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerinjectordi.container;

import containerinjectordi.injector.CarwashInjector;
import containerinjectordi.injector.Injector;
import containerinjectordi.injector.WindowwashInjector;
import containerinjectordi.service.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erno
 */
public class Container {
    private List<Service> serviceList = new ArrayList<>();
    private List<Injector> injectorList = new ArrayList<>();   

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Injector> getInjectorList() {
        return injectorList;
    }

    public void setInjectorList(List<Injector> injectorList) {
        this.injectorList = injectorList;
    }
    
    public void addService(Service service) {
        this.serviceList.add(service);
    }
    
    public Service getService(String serviceType) {
        if (serviceType.equals(Injector.CARWASH)) {
            System.out.println("Service type: Car Wash");
            for (Injector inject:injectorList) {
                if (inject.getType().equals(Injector.CARWASH)) {
                    return inject.getServiceFromContainer();
                }            
            }
            CarwashInjector temp = new CarwashInjector(this);
            injectorList.add(temp);
            return temp.getServiceFromContainer();
        }
        if (serviceType.equals(Injector.WINDOWWASH)) {
            System.out.println("Service type: Window Wash");
            for (Injector inject:injectorList) {
                if (inject.getType().equals(Injector.WINDOWWASH)) {
                    return inject.getServiceFromContainer();
                }           
            }
            WindowwashInjector temp = new WindowwashInjector(this);
            injectorList.add(temp);
            return temp.getServiceFromContainer();
        }
        return null;
    }
    

}

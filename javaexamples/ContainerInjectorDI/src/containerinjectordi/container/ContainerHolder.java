/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerinjectordi.container;

import containerinjectordi.service.Service;

/**
 *
 * @author erno
 */
public class ContainerHolder {
    private static Container container;
    
    public ContainerHolder() {
    }
    
    public static Service getService(String serviceType) {
        if (container == null) {
            container = new Container();
        }
        return container.getService(serviceType);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerinjectordi.injector;

import containerinjectordi.service.Service;

/**
 *
 * @author erno
 */
public interface Injector {
    public static final String CARWASH = "carwash";
    public static final String WINDOWWASH= "windowwash";   
    public Service getServiceFromContainer();
    public String getType();
}

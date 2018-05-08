/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerinjectordi;
import containerinjectordi.container.ContainerHolder;
import containerinjectordi.injector.Injector;
import containerinjectordi.service.Service;

/**
 *
 * @author erno
 */
public class RunService {
        private static int runtimes = 0;
        Service service;
        
        public void run() {
            service = ContainerHolder.getService(Injector.CARWASH);
            service.processService();
            service = ContainerHolder.getService(Injector.WINDOWWASH);
            service.processService();            
            service = ContainerHolder.getService(Injector.CARWASH);
            service.processService();            
            service = ContainerHolder.getService(Injector.WINDOWWASH);
            service.processService();
            if (runtimes == 0) {
                runtimes++;
                RunService runservice = new RunService();
                runservice.run();
            }
        }
}

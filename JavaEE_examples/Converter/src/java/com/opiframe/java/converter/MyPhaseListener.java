/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.converter;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Opiframe
 */
public class MyPhaseListener implements PhaseListener{

  @Override
  public void afterPhase(PhaseEvent event) {
    System.out.println("After executing: " + event.getPhaseId());
  }

  @Override
  public void beforePhase(PhaseEvent event) {
    System.out.println("Before executing: " + event.getPhaseId());
  }

  @Override
  public PhaseId getPhaseId() {
    return PhaseId.ANY_PHASE;
  }
  
}

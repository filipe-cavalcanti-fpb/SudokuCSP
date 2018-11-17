/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.intersectState;

import java.util.List;

/**
 *
 * @author assert
 */
public abstract class IntersectState {
    private IntersectState nextState;
    private List<Integer> valuesState;
    
    public IntersectState(List<Integer> valuesState){
        this.valuesState = valuesState;
    }
    
    abstract IntersectState getNextState()
}

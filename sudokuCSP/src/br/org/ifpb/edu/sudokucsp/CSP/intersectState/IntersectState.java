/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.intersectState;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public abstract class IntersectState {
    public static List<Integer> INTERSECT_STATE_VALUES = new ArrayList<>();
    private IntersectState deadEnd;
    private IntersectState nextState;
    private List<Integer> valuesState;
    
    public IntersectState(List<Integer> valuesState, IntersectState nextState){
        this.deadEnd = new IntersectStateDeadEnd(null, null);
        this.valuesState = valuesState;
        this.nextState = nextState;
    }
    
    public IntersectState(){
        this.deadEnd = new IntersectStateDeadEnd(null, null);
        this.valuesState = null;
        this.nextState = null;
    }
    
    public IntersectState getNextState(){
        return this.nextState;
    }
    
    abstract IntersectState getNextState(int value);
    
    public List<Integer> getValuesState(){
        return this.valuesState;
    }
    
    public IntersectState getDeadEnd(){
        return this.deadEnd;
    }

    public void setNextState(IntersectState nextState) {
        this.nextState = nextState;
    }

    public void setValuesState(List<Integer> valuesState) {
        this.valuesState = valuesState;
    }
}

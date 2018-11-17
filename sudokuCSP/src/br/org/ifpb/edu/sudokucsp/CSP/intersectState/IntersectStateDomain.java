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
public class IntersectStateDomain extends IntersectState{

    public IntersectStateDomain(List<Integer> valuesState, IntersectState nextState) {
        super(valuesState, nextState);
    }
    
    public IntersectStateDomain(){
        super();
    }

    @Override
    public IntersectState getNextState(int value) {
        if (super.getValuesState().contains(value)){
            try {
                return super.getNextState().getNextState(value);
            } catch (NullPointerException nE) {
                IntersectState.INTERSECT_STATE_VALUES.add(value);
                return this;
            }
        }
        else{
            return super.getDeadEnd();
        }
    }
    
}

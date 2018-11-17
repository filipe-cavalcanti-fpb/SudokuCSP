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
public class IntersectStateDeadEnd extends IntersectState{

    public IntersectStateDeadEnd(List<Integer> valuesState, IntersectState nextState) {
        super(valuesState, nextState);
    }

    @Override
    IntersectState getNextState(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

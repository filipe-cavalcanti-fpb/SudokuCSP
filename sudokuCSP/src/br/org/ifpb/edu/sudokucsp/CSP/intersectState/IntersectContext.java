/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.intersectState;

import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class IntersectContext {
    List<IntersectState> states;
    
    public IntersectContext(){
        this.states = new ArrayList<>();
    }
    
    public void setStates(Variable var){
        var.getDomains().forEach((_item) -> {
            this.states.add(new IntersectStateDomain());
            this.states.get(this.states.size()-1).setValuesState(_item.getDomainFlyweight());
            try {
                this.states.get(0).setNextState(this.states.get(1));
            } catch (Exception e) {
            }
        });
    }
}

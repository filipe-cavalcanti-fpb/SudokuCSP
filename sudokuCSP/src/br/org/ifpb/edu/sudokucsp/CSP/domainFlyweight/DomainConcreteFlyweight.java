/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight;

import br.org.ifpb.edu.sudokucsp.graph.Graph;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class DomainConcreteFlyweight implements DomainFlyweight{
    private List<Integer> poolValues;
    
    public DomainConcreteFlyweight(){
        this.poolValues = new ArrayList<>();
        for(int value = 0; value < Graph.SQRT_81; value++){
            this.poolValues.add(value);
        }
    }

    @Override
    public void removeFromDomain(int value) {
        this.poolValues.remove(value);
    }

    @Override
    public DomainFlyweight getConcretFlyweight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public String toString(){
        return this.poolValues.toString();
    }
}

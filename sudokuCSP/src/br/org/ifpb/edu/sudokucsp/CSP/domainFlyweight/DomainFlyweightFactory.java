/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight;

import java.util.ArrayList;
import java.util.List;
import br.org.ifpb.edu.sudokucsp.graph.Graph;

/**
 *
 * @author assert
 */
public class DomainFlyweightFactory {
    public List<DomainFlyweight> poolFlyweight;
    
    public DomainFlyweightFactory(){
        this.poolFlyweight = new ArrayList<>();
    }
    
    public DomainFlyweight getDomainLineFlyweight(int node){
        try {
            return this.poolFlyweight.get(node%Graph.SQRT_81);
        } catch (Exception e) {
            this.poolFlyweight.add(new DomainConcreteFlyweight());
            return this.poolFlyweight.get(node%Graph.SQRT_81);
        }
    }
    
    public DomainFlyweight getDomainColumnFlyweight(int node){
        try {
            return this.poolFlyweight.get((int)node/Graph.SQRT_81);
        } catch (Exception e) {
            this.poolFlyweight.add(new DomainConcreteFlyweight());
            return this.poolFlyweight.get((int)node/Graph.SQRT_81);
        }
    }
}

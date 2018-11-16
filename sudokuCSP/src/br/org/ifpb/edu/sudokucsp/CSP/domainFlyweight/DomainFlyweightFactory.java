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
    private List<DomainFlyweight> poolFlyweightsLine;
    private List<DomainFlyweight> poolFlyweightsColumn;
    private DomainFlyweight poolFlyweightsPrimaryDiagonal;
    private DomainFlyweight poolFlyweightsSecondDiagonal;
    
    public DomainFlyweightFactory(){
        this.poolFlyweightsLine = new ArrayList<>();
        this.poolFlyweightsColumn = new ArrayList<>();
        this.poolFlyweightsPrimaryDiagonal = new DomainConcreteFlyweight();
        this.poolFlyweightsSecondDiagonal = new DomainConcreteFlyweight();
        for(int index = 0; index < 2*Graph.SQRT_81+2;index++){
            this.poolFlyweightsLine.add(new DomainConcreteFlyweight());
            this.poolFlyweightsColumn.add(new DomainConcreteFlyweight());
        }
    }
    
    public DomainFlyweight getDomainLineFlyweight(int node){
        return this.poolFlyweightsLine.get((int)node/Graph.SQRT_81);
    }
    
    public DomainFlyweight getDomainColumnFlyweight(int node){
        return this.poolFlyweightsLine.get(node%Graph.SQRT_81);
    }
    
    public DomainFlyweight getDomainPrimaryDiagonalFlyweight(int node){
        return new DomainConcreteFlyweight();
    }
}

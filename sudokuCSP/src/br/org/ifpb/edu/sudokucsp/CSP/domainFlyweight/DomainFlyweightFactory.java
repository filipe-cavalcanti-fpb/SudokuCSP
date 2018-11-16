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
    
    public List<DomainFlyweight> getAllDomains(int node){
        List<DomainFlyweight> domains = new ArrayList<>();
        domains.add(this.getDomainLineFlyweight(node));
        domains.add(this.getDomainColumnFlyweight(node));
        try { 
            domains.add(this.getDomainPrimaryDiagonalFlyweight(node));
        } catch (NullPointerException e) {
            System.err.println(e);
        }
        try {
            domains.add(this.getDomainSecondDiagonalFlyweight(node));
        } catch (NullPointerException e) {
            System.err.println(e);
        }
        return domains;
    }
    
    private DomainFlyweight getDomainLineFlyweight(int node){
        return this.poolFlyweightsLine.get((int)node/Graph.SQRT_81);
    }
    
    private DomainFlyweight getDomainColumnFlyweight(int node){
        return this.poolFlyweightsLine.get(node%Graph.SQRT_81);
    }
    
    private DomainFlyweight getDomainPrimaryDiagonalFlyweight(int node) throws NullPointerException{
        if(node%Graph.MULT_PRIMARY_DIAGONAL==0){
            return this.poolFlyweightsPrimaryDiagonal;
        }
        else{
            throw new NullPointerException("Não pertence a diagonal");
        }
    }
    
    private DomainFlyweight getDomainSecondDiagonalFlyweight(int node)throws NullPointerException{
        if(node%(Graph.MULT_SECOND_DIAGONAL) == 0){
            return this.poolFlyweightsSecondDiagonal;
        }
        else{
            throw new NullPointerException("Não pertence a diagonal secundaria");
        }
    }
}

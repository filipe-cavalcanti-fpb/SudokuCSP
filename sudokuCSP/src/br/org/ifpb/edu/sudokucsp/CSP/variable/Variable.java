/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.variable;

import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.DomainFlyweight;
import java.util.List;

/**
 *
 * @author assert
 */
public abstract class Variable {
    private int subMatrixIndex;
    private List<Integer> point;
    private int value;
    protected List<DomainFlyweight> domains;
    protected int node;

    public void setSubMatrixIndex(int subMatrixIndex) {
        this.subMatrixIndex = subMatrixIndex;
    }

    public void setPoint(List<Integer> point) {
        this.point = point;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDomains(List<DomainFlyweight> domains) {
        this.domains = domains;
    }
    
    public void setNode(int node){
        this.node = node;
    }

    public List<DomainFlyweight> getDomains() {
        return domains;
    }
    abstract protected DomainFlyweight getIntersect();
    
    public void updateDomain(int value){
        for(DomainFlyweight domainItem: this.domains){
            domainItem.removeFromDomain(value);
        }
    }
    
    public int getValue(){
        return this.value;
    }
    
    @Override
    public String toString(){
        return "{\"node\":"+this.node+", \"value\":"+this.value+"}";
    }
    
}

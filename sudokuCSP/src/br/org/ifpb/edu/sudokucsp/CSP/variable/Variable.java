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
    private List<DomainFlyweight> domains;

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
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod;

import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.DomainConcreteFlyweight;
import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.DomainFlyweight;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;

/**
 *
 * @author assert
 */
public class ConcreteVariable extends Variable{
    
    @Override
    public DomainFlyweight getIntersect() {
        return new DomainConcreteFlyweight();
    }
    
}

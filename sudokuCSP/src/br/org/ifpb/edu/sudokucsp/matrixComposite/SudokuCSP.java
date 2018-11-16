/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrixComposite;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphConcreteBuilder;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphDirector;
import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.*;
/**
 *
 * @author assert
 */
public class SudokuCSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DomainFlyweight d1,d2,d3;
        DomainFlyweightFactory df = new DomainFlyweightFactory();
        d1 = df.getDomainColumnFlyweight(5);
        d2 = df.getDomainColumnFlyweight(14);
        d3 = df.getDomainColumnFlyweight(23);
        d1.removeFromDomain(1);
        System.err.println(d3);
    }
    
}

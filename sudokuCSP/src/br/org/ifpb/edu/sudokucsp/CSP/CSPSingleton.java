/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP;

import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.VariableConcreteCreator;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.VariableCreator;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphBuilder;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphDirector;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphConcreteBuilder;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author assert
 */
public class CSPSingleton {
    private static CSPSingleton instance;
    private List<Variable> variables;
    private Graph graphReference;
    private GraphBuilder graphBuilderReference;
    private GraphDirector graphDirectorReference;
    private VariableCreator variableCriatorReference;
    
    private CSPSingleton(){
        this.variables = new ArrayList<>();
        this.graphBuilderReference = new GraphConcreteBuilder();
        this.graphDirectorReference = new GraphDirector(graphBuilderReference);
        this.graphDirectorReference.builder();
        this.variableCriatorReference = new VariableConcreteCreator();
        this.variables = this.variableCriatorReference.getProduct();
        this.graphReference =((GraphConcreteBuilder)this.graphBuilderReference).getGraphReferenceProduct();
    }
    
    public static CSPSingleton getInstance(){
        if(CSPSingleton.instance == null){
            CSPSingleton.instance = new CSPSingleton();
        }
        return CSPSingleton.instance;
    }
    
}

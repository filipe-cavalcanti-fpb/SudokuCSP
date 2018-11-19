/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP;

import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.ConcreteVariable;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.VariableConcreteCreator;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.VariableCreator;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphBuilder;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphDirector;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphConcreteBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author assert
 */
public class CSPSingleton {
    private Random generateNode;
    private static CSPSingleton instance;
    public List<Variable> variables;
    private Graph graphReference;
    private GraphBuilder graphBuilderReference;
    private GraphDirector graphDirectorReference;
    private VariableCreator variableCriatorReference;
    
    private CSPSingleton(){
        this.generateNode = new Random();
        this.variables = new ArrayList<>();
        this.graphBuilderReference = new GraphConcreteBuilder();
        this.graphDirectorReference = new GraphDirector(graphBuilderReference);
        this.graphDirectorReference.builder();
        this.variableCriatorReference = new VariableConcreteCreator();
        ((VariableConcreteCreator)this.variableCriatorReference).variableFactoryMethod();
        this.variables = ((VariableConcreteCreator)this.variableCriatorReference).getProduct();
        this.graphReference =((GraphConcreteBuilder)this.graphBuilderReference).getGraphReferenceProduct();
    }
    
    public static CSPSingleton getInstance(){
        if(CSPSingleton.instance == null){
            CSPSingleton.instance = new CSPSingleton();
        }
        return CSPSingleton.instance;
    }
    
    public void setValuesVariable(){
        for(List<Integer> subMatrix: ((GraphConcreteBuilder)this.graphBuilderReference).getSubMatrixs()){
            for(int quant = 0; quant < this.generateNode.nextInt(3) + 3;quant++){
                Integer variableIndex = subMatrix.get(this.generateNode.nextInt(subMatrix.size()));
                List<Integer> availableValues = ((ConcreteVariable)this.variables.get(variableIndex)).getIntersect().getDomainFlyweight();
                try {
                    int valueGenereted = availableValues.get(this.generateNode.nextInt(availableValues.size()));
                    this.variables.get(variableIndex).setValue(valueGenereted);
                    this.variables.get(variableIndex).updateDomain(valueGenereted);
                } catch (Exception e) {
                }
            }
        }
    }
}

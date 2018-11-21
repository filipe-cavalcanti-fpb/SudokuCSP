/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP;

import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.DomainFlyweight;
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
    
    public DomainFlyweight getAvailableValues(int node){
        return ((ConcreteVariable)this.variables.get(node)).getIntersect();
    }
    
    public void setValue(int node, int value){
        this.variables.get(node).updateDomain(value);
    }
    public void getAvGr(int node){
        List<Integer> allValues = this.getAllValues();
        for(Byte variable:this.graphReference.getAdjacence(node)){
            if(this.variables.get(variable).getValue() !=0){
                allValues.set(this.variables.get(variable).getValue(),0);
            }
        }
        Integer i = 0;
        while (allValues.contains(i)) {            
            allValues.remove(i);
        }
        System.out.println(allValues);
    }
    
    public List<Integer> getAllValues(){
        List<Integer> allValues = new ArrayList<>();
        for(int i = 0; i <= Graph.SQRT_81;i++){
            allValues.add(i);
        }
        return allValues;
    }
}

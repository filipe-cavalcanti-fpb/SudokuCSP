/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrixComposite;
import br.org.ifpb.edu.sudokucsp.CSP.CSPSingleton;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphConcreteBuilder;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphDirector;
import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.*;
import br.org.ifpb.edu.sudokucsp.CSP.intersectState.*;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.ConcreteVariable;
import java.util.List;
/**
 *
 * @author assert
 */
public class SudokuCSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CSPSingleton cs = CSPSingleton.getInstance();
        cs.setValuesVariable();
        for(int i = 0;i < cs.variables.size();i++){
            if(i%9==0){
                System.out.print('\n');
            }
            System.out.print(cs.variables.get(i));
        }
        System.out.println("\n"+cs.variables.get(0).getDomains());
        cs.getAvGr(0);
    }
    
}

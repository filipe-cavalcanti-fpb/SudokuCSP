/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrixComposite;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphConcreteBuilder;
/**
 *
 * @author assert
 */
public class SudokuCSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphConcreteBuilder d = new GraphConcreteBuilder();
        //d.constructEdgeColumn();
        //d.constructEdgeLine();
        //d.constructEdgePrimaryDiagonal();
        //d.constructEdgeSecondDiagonal();
        d.constructEdgeSubMatrix();
        //System.err.println(d.getGraphReferenceProduct().getAdjacence(43));
        //System.err.println(d);
    }
    
}

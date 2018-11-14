/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.graph.builder;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
/**
 *
 * @author assert
 */
public class GraphConcreteBuilder implements GraphBuilder{
    private Graph graphReferenceProduct;
    
    public GraphConcreteBuilder(){
        this.graphReferenceProduct = new Graph();
    }
    
    @Override
    public void constructEdgeLine() {
        for(int i = 0; i < Graph.SIZE;i++){
            this.constructLineEdgeNode(i);
        }
    }

    @Override
    public void constructEdgeColumn() {
        for(int i = 0; i < Graph.SIZE;i++){
            this.constructColumnEdgeNode(i);
        }
    }

    @Override
    public void constructEdgePrimaryDiagonal() {
        for(int i = 0;i <= Graph.SIZE; i+=Graph.MULT_PRIMARY_DIAGONAL){
            this.constructEdgePrimaryDiagonalNode(i);
        }
    }

    @Override
    public void constructEdgeSecondDiagonal() {
        for(int i = Graph.MULT_SECOND_DIAGONAL;i < Graph.SIZE; i+=Graph.MULT_SECOND_DIAGONAL){
            this.constructEdgeSecondDiagonalNode(i);
        }
    }
    /**
     * 
     * @return 
     */
    public Graph getGraphReferenceProduct(){
        return this.graphReferenceProduct;
    }
    
    @Override
    public String toString(){
        return this.graphReferenceProduct.toString();
    }
    /**
     * 
     * @param node 
     */
    private void constructLineEdgeNode(int node){
        for (int i = node+1; i < Graph.SQRT_81 + Graph.SQRT_81*node;i++){
            if(i%Graph.SQRT_81 == 0){
                break;
            }
            this.graphReferenceProduct.setEdge(node, i);
        }
    }
    /**
     * 
     * @param node 
     */
    private void constructColumnEdgeNode(int node){
        for (int i = node+Graph.SQRT_81; i <= 72+node;i+=Graph.SQRT_81){
            try {
                this.graphReferenceProduct.setEdge(node, i);
            } catch (IndexOutOfBoundsException e) {
            }
        }
    }
    /**
     * 
     * @param node 
     */
    private void constructEdgePrimaryDiagonalNode(int node){
        for (int i = node + Graph.MULT_PRIMARY_DIAGONAL; i <= Graph.SIZE-1; i+=Graph.MULT_PRIMARY_DIAGONAL){
            this.graphReferenceProduct.setEdge(node, i);
        }
    }
    
    /**
     * 
     * @param node 
     */
    private void constructEdgeSecondDiagonalNode(int node){
        for (int i = node + Graph.MULT_SECOND_DIAGONAL; i <= Graph.SIZE-Graph.SQRT_81; i+=Graph.MULT_SECOND_DIAGONAL){
            this.graphReferenceProduct.setEdge(node, i);
        }
    }

    @Override
    public void constructEdgeSubMatrix() {
        for(int i = 0; i < Graph.SIZE;i++){
            //System.err.println(i+", "+(i%Graph.SQRT_81));
        }
        this.constructEdgeSubMatrixNode(3);
    }
    
    /**
     * constructEdgeSubMatrixNode constroí as arestas para ligar os elementos
     * de cada uma das sub-matrizes
     * @param node 
     */
    private void constructEdgeSubMatrixNode(int node){
        /*for(int j = node + 1; j <= node+Graph.SUB_DIAGONAL_LIMIT;j++){
            if(j % Graph.SQRT_81 < Graph.SQRT_9){
                this.graphReferenceProduct.setEdge(node, j);
            }
            else if(j + 1 == Graph.SIZE){
                break;
            }
        }*/
        int limitSup = 0;
        for(int[] tuple:Graph.SUB_DIAGONAL){
            if(node >= tuple[0]){
                limitSup = tuple[1];
                break;
            }
        }
        System.out.println(limitSup);
        for(int i = 0; i < Graph.SQRT_9;i++){
            for(int j = node; j < node + Graph.SQRT_9;j++){
                //System.err.println(j);
            }
        }
    }
}

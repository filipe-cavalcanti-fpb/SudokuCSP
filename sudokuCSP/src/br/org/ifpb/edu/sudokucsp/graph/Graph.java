/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class Graph {
    public static final int SIZE = 81;
    public static final int SQRT_81 = 9;
    public static final int SQRT_9 = 3;
    public static final int MULT_PRIMARY_DIAGONAL = 10;
    public static final int MULT_SECOND_DIAGONAL = 8;
    private static final int LINK = 10;
    public static final int SUB_DIAGONAL_LIMIT = 20;
    public static final int SUB_DIAGONAL[][] = {{0,20},{3,23},{6,26}, {27,47}, 
        {30,50}, {33,53}, {54,74},{57,77},{60,80}};
    private List<List<Byte>> adjacenceMatrix;
    
    public Graph(){
        this.adjacenceMatrix = new ArrayList<>();
        this.constructLine();
        this.constructColunm();
    }
    private void constructLine(){
        for(int i =0;i < Graph.SIZE; i++){
            this.adjacenceMatrix.add(new ArrayList<>());
        }
    }
    private void constructColunm(){
        for(int i = 0;i < Graph.SIZE; i++){
            for(int j = 0; j < Graph.SIZE; j++){
                this.adjacenceMatrix.get(i).add((byte)0);
            }
        }
    }
    public void setEdge(int lineIndex, int columnIndex){
        this.adjacenceMatrix.get(lineIndex).set(columnIndex, (byte)Graph.LINK);
    }
    
    @Override
    public String toString(){
        String str = "";
        for(int i =0; i < Graph.SIZE; i ++ ){
            for(int j =0; j < Graph.SIZE; j ++ ){
                str+=this.adjacenceMatrix.get(i).get(j)+",";
            }
            str+="\n";
        }
        return str;
    }
    
    public List<Byte> getAdjacence(int nodeIndex){
        List<Byte> result = new ArrayList<>();
            for(int j = 0; j < Graph.SIZE;j ++ ){
                if(this.adjacenceMatrix.get(nodeIndex).get(j) == Graph.LINK){
                    result.add((byte)j);
                }
                if(this.adjacenceMatrix.get(j).get(nodeIndex) == Graph.LINK){
                    if(!result.contains((byte)j)){
                        result.add((byte)(j));
                    }
                }
            }
        return result;
    }
}
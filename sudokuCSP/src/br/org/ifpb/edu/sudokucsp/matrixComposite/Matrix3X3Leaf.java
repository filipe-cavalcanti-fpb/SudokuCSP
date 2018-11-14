/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrixComposite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 * @param <T>
 */
public class Matrix3X3Leaf<T> extends MatrixComponent<T>{
    private List<List<T>> matrix3X3Reference;
    
    /**
     * 
     * @param indexLine
     * @return 
     */
    @Override
    public List<T> getLine(int indexLine){
        return this.matrix3X3Reference.get(indexLine);
    }
    /**
     * 
     * @param indexColumn
     * @return 
     */
    @Override
    public List<T> getColumn(int indexColumn){
        List<T> result = new ArrayList<>();
        return result;
    }
    
    /**
     * 
     * @param lineIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public T getItem(int lineIndex, int columnIndex){
        return this.matrix3X3Reference.get(lineIndex).get(columnIndex);
    }
        
    /**
     *
     * @param indexLIne
     * @param indexColumn
     * @param item
     */
    @Override
    public void add(int indexLine, int indexColumn, T item){
        this.matrix3X3Reference.get(indexLine).add(indexColumn, item);
    }
    /**
     * 
     * @param item 
     */
    @Override
    void add(List<T> item) {
        this.matrix3X3Reference.add(item);
    }

    @Override
    void addComponent(MatrixComponent<T> component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void removeComponent(MatrixComponent<T> component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrixComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author assert
 */
public class Matrix3X3Composite<T> extends MatrixComponent<T>{
    private List<MatrixComponent<T>> matrix3X3Components = new ArrayList<>();
    
    /**
     * 
     * @param indexLine
     * @return 
     */
    @Override
    public List<T> getLine(int indexLine) {
        List<T> result = new ArrayList<>();
        this.matrix3X3Components.forEach((item) -> {
            result.addAll(item.getLine(indexLine));
        });
        return result;
    }

    @Override
    public List<T> getColumn(int indexColumn) {
        List<T> result = new ArrayList<>();
        this.matrix3X3Components.forEach((item) -> {
            result.addAll(item.getColumn(indexColumn));
        });
        return result;
    }

    @Override
    public T getItem(int lineIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(List<T> item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(int indexLine, int indexColumn, T item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    void addComponent(MatrixComponent<T> component) {
        this.matrix3X3Components.add(component);
    }

    @Override
    void removeComponent(MatrixComponent<T> component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matrix3X3Composite<T> other = (Matrix3X3Composite<T>) obj;
        if (!Objects.equals(this.matrix3X3Components, other.matrix3X3Components)) {
            return false;
        }
        return true;
    }
}

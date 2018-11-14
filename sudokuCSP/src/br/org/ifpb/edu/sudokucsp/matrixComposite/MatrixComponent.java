/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrixComposite;

import java.util.List;

/**
 *
 * @author assert
 * @param <T>
 */
public abstract class MatrixComponent<T> {
    abstract List<T> getLine(int indexLine);
    abstract List<T> getColumn(int indexColumn);
    abstract T getItem(int lineIndex, int columnIndex);
    abstract void add(List<T> item);
    abstract void add(int indexLine, int indexColumn, T item);
    abstract void addComponent(MatrixComponent<T> component);
    abstract void removeComponent(MatrixComponent<T> component);
    
}

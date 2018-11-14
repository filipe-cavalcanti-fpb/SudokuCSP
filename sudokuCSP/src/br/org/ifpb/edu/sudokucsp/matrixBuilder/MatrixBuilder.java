/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrixBuilder;

import br.org.ifpb.edu.sudokucsp.matrixComposite.Matrix3X3Composite;
import br.org.ifpb.edu.sudokucsp.matrixComposite.MatrixComponent;
import br.org.ifpb.edu.sudokucsp.matrixComposite.Matrix3X3Leaf;


/**
 *
 * @author assert
 */
public interface MatrixBuilder {
    MatrixComponent<Integer> buildPart();
}

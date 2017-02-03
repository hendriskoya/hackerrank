package com.hendris.hackerhank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author hendris
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 2/3/17 7:36 PM
 */
public class AlgorithmicCrushSolutionTest {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("AlgorithmicCrushInput.txt"));

        new AlgorithmicCrushSolution().main(null);
    }
}

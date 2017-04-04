package com.hendris.hackerhank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author hendris
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 2/3/17 7:36 PM
 */
public class AlgorithmicCrushSolutionV2Exec {

    public static void main(String[] args) throws FileNotFoundException {
        /*System.setIn(new FileInputStream("AlgorithmicCrushInput01.txt"));

        new AlgorithmicCrushSolution().main(null);

        System.setIn(new FileInputStream("AlgorithmicCrushInput02.txt"));

        new AlgorithmicCrushSolution().main(null);

        System.setIn(new FileInputStream("AlgorithmicCrushInput03.txt"));

        new AlgorithmicCrushSolution().main(null);*/

        final long start = System.currentTimeMillis();
        System.setIn(new FileInputStream("HackerHankAlgorithmicCrushInput04.txt"));

        new AlgorithmicCrushSolutionV2().main(null);

        final long end = System.currentTimeMillis();

        System.out.println(end - start);

        //5855 milliseconds
    }
}

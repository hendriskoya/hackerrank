package com.hendris.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import com.hendris.hackerrank.AlgorithmicCrushSolution.RangeValue;

/**
 * @author hendris
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 2/6/17 10:37 AM
 */
public class AlgorithmicCrushSolutionTest {

    @Test()
    public void testMergeNotInside() {

        RangeValue r1 = new RangeValue(1l, 2l, 10l);
        RangeValue r2 = new RangeValue(3l, 4l, 10l);

        RangeValue mergedRangeValue = AlgorithmicCrushSolution.merge(r1, r2);
        assertNotNull(mergedRangeValue);
        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(4l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(3l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(4l));

        mergedRangeValue = AlgorithmicCrushSolution.merge(r2, r1);
        assertNotNull(mergedRangeValue);
        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(4l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(3l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(4l));

        r1 = new RangeValue(1l, 2l, 10l);
        r2 = new RangeValue(4l, 5l, 10l);

        mergedRangeValue = AlgorithmicCrushSolution.merge(r1, r2);
        assertNotNull(mergedRangeValue);
        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(5l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(0l), mergedRangeValue.getValue(3l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(4l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(5l));

        mergedRangeValue = AlgorithmicCrushSolution.merge(r2, r1);
        assertNotNull(mergedRangeValue);
        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(5l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(0l), mergedRangeValue.getValue(3l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(4l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(5l));
    }

    @Test()
    public void testMergePartiallyInside1() {

        RangeValue r1 = new RangeValue(1l, 2l, 10l);
        RangeValue r2 = new RangeValue(2l, 3l, 10l);

        RangeValue mergedRangeValue = AlgorithmicCrushSolution.merge(r1, r2);
        assertNotNull(mergedRangeValue);

        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(3l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(3l));

        mergedRangeValue = AlgorithmicCrushSolution.merge(r2, r1);
        assertNotNull(mergedRangeValue);

        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(3l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(3l));
    }

    @Test()
    public void testMergePartiallyInside2() {

        RangeValue r1 = new RangeValue(1l, 3l, 10l);
        RangeValue r2 = new RangeValue(2l, 4l, 10l);

        RangeValue mergedRangeValue = AlgorithmicCrushSolution.merge(r1, r2);
        assertNotNull(mergedRangeValue);

        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(4l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(3l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(4l));

        mergedRangeValue = AlgorithmicCrushSolution.merge(r2, r1);
        assertNotNull(mergedRangeValue);

        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(4l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(3l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(4l));
    }

    @Test()
    public void testMergeInside() {

        RangeValue r1 = new RangeValue(1l, 4l, 10l);
        RangeValue r2 = new RangeValue(2l, 3l, 10l);

        RangeValue mergedRangeValue = AlgorithmicCrushSolution.merge(r1, r2);
        assertNotNull(mergedRangeValue);

        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(4l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(3l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(4l));

        mergedRangeValue = AlgorithmicCrushSolution.merge(r2, r1);
        assertNotNull(mergedRangeValue);

        assertEquals(Long.valueOf(1l), mergedRangeValue.getStart());
        assertEquals(Long.valueOf(4l), mergedRangeValue.getEnd());
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(1l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(2l));
        assertEquals(Long.valueOf(20l), mergedRangeValue.getValue(3l));
        assertEquals(Long.valueOf(10l), mergedRangeValue.getValue(4l));
    }

    @Test
    public void testInput01() throws FileNotFoundException {
        System.setIn(new FileInputStream("AlgorithmicCrushInput01.txt"));

        final PrintStream out = System.out;

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        AlgorithmicCrushSolution.PRINT_MAX_VALUE = false;
        AlgorithmicCrushSolution.PRINT_MERGED_FINAL_RANGE = true;
        new AlgorithmicCrushSolution().main(null);

        System.out.flush();
        System.setOut(out);

        RangeValue expected = new RangeValue(1l, 5l, 0l);
        expected.add(1l, 100l);
        expected.add(2l, 200l);
        expected.add(3l, 200l);
        expected.add(4l, 200l);
        expected.add(5l, 100l);

        assertEquals(expected.toString(), stream.toString().replaceAll("(\\r|\\n)", ""));
    }

    @Test
    public void testInput02() throws FileNotFoundException {
        System.setIn(new FileInputStream("AlgorithmicCrushInput02.txt"));

        final PrintStream out = System.out;

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        AlgorithmicCrushSolution.PRINT_MAX_VALUE = false;
        AlgorithmicCrushSolution.PRINT_MERGED_FINAL_RANGE = true;
        new AlgorithmicCrushSolution().main(null);

        System.out.flush();
        System.setOut(out);

        RangeValue expected = new RangeValue(1l, 4l, 0l);
        expected.add(1l, 100l);
        expected.add(2l, 100l);
        expected.add(3l, 100l);
        expected.add(4l, 100l);

        assertEquals(expected.toString(), stream.toString().replaceAll("(\\r|\\n)", ""));
    }

    @Test
    public void testInput03() throws FileNotFoundException {
        System.setIn(new FileInputStream("AlgorithmicCrushInput03.txt"));

        final PrintStream out = System.out;

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        AlgorithmicCrushSolution.PRINT_MAX_VALUE = false;
        AlgorithmicCrushSolution.PRINT_MERGED_FINAL_RANGE = true;
        new AlgorithmicCrushSolution().main(null);

        System.out.flush();
        System.setOut(out);

        RangeValue expected = new RangeValue(1l, 9l, 0l);
        expected.add(1l, 110l);
        expected.add(2l, 110l);
        expected.add(3l, 110l);
        expected.add(4l, 160l);
        expected.add(5l, 60l);
        expected.add(6l, 60l);
        expected.add(7l, 260l);
        expected.add(8l, 260l);
        expected.add(9l, 60l);

        assertEquals(expected.toString(), stream.toString().replaceAll("(\\r|\\n)", ""));
    }
}

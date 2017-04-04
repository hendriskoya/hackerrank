package com.hendris.hackerhank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hendris
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 2/3/17 7:20 PM
 */
public class AlgorithmicCrushSolutionV2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final String firstLine = in.nextLine();
        final String[] split = firstLine.split(" ");
        final Integer N = Integer.valueOf(split[0]);
        final Integer M = Integer.valueOf(split[1]);

        final long[] values = new long[4001];

        for (int i = 0; i < M; i++) {
            final String rangeValueLine = in.nextLine();
            final String[] rangeValueSplit = rangeValueLine.split(" ");
            final Integer start = Integer.valueOf(rangeValueSplit[0]);
            final Integer end = Integer.valueOf(rangeValueSplit[1]);
            final Long value = Long.valueOf(rangeValueSplit[2]);

            for (int j = start.intValue(); j <= end; j++) {
                values[j] += value;
            }
        }

        Arrays.sort(values);
        System.out.println(values[values.length - 1]);
    }
}

package com.hendris.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hendris
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 2/3/17 7:20 PM
 */
public class AlgorithmicCrushSolutionV3 {

    public static void main(String[] args) {

//        System.out.println(Math.ceil(3900 / 200));

        Scanner in = new Scanner(System.in);

        final String firstLine = in.nextLine();
        final String[] split = firstLine.split(" ");
        final Long N = Long.valueOf(split[0]);
        final Long M = Long.valueOf(split[1]);

        final Long MAX = 20000l;

        final Integer MOD = Math.toIntExact(N % MAX);

        final long[][] values = new long[(int) Math.ceil(N / MAX)][];
        for (int i = 0; i < values.length - 1; i++) {
            values[i] = new long[Math.toIntExact(MAX)];
        }
        if (MOD > 0)
            values[values.length -1] = new long[MOD];
        else
            values[values.length -1] = new long[Math.toIntExact(MAX)];

        for (int i = 0; i < M; i++) {
            final String rangeValueLine = in.nextLine();
            final String[] rangeValueSplit = rangeValueLine.split(" ");
            final Integer start = Integer.valueOf(rangeValueSplit[0]);
            final Integer end = Integer.valueOf(rangeValueSplit[1]);
            final Long value = Long.valueOf(rangeValueSplit[2]);

            for (int j = start.intValue()-1; j < end; j++) {
                int a = (int) Math.floor(j / MAX);
                int x = (int) (j % MAX);
                values[a][x] += value;
            }
        }

        long total = 0;
        for (int i = 0; i < values.length; i++) {
            Arrays.sort(values[i]);
            if (total < values[i][values[i].length - 1])
                total = values[i][values[i].length - 1];
        }
        System.out.println(total);
    }
}

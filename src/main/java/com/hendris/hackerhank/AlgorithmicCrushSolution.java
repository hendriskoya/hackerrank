package com.hendris.hackerhank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hendris
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 2/3/17 7:20 PM
 */
public class AlgorithmicCrushSolution {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);

        final String firstLine = in.nextLine();
        final String[] split = firstLine.split(" ");
        final Long M = Long.valueOf(split[0]);
        final Long N = Long.valueOf(split[1]);

        final List<RangeValue> ranges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            final String rangeValueLine = in.nextLine();
            final String[] rangeValueSplit = rangeValueLine.split(" ");
            final RangeValue range = new RangeValue(Long.valueOf(rangeValueSplit[0]), Long.valueOf(rangeValueSplit[1]),
                    Long.valueOf(rangeValueSplit[2]));
            ranges.add(range);
        }

        for (RangeValue range: ranges) {
            System.out.println(range);
        }*/

        RangeValue r1 = new RangeValue(0l, 1l, 100l);
        RangeValue r2 = new RangeValue(2l, 5l, 100l);

        merge(r1, r2);

        r1 = new RangeValue(1l, 2l, 100l);
        r2 = new RangeValue(2l, 5l, 100l);

        merge(r1, r2);

        r1 = new RangeValue(2l, 3l, 100l);
        r2 = new RangeValue(2l, 5l, 100l);

        merge(r1, r2);

        r1 = new RangeValue(4l, 6l, 100l);
        r2 = new RangeValue(2l, 5l, 100l);

        merge(r1, r2);

        /*print(r2.getValue(2l));
        r2.add(2l, 50l);
        print(r2.getValue(2l));*/
    }

    public static void print(Object value) {
        System.out.println(value);
    }

    private static void merge (final RangeValue r1,
            final RangeValue r2) {
        if (r1.getStart() < r2.getStart()) {
            if (r1.getEnd() < r2.getStart()) {
                System.out.println("r1 is out");
            } else {

                final long diff = r1.getEnd() - r2.getStart();

                RangeValue newRange = new RangeValue(r1.getStart(), r2.getEnd(), 0l);
                for (long i = r1.getStart(); i <= r1.getEnd(); i++) {
                    newRange.add(i, r1.getValue(i));
                }
                for (long i = r2.getStart(); i <= r2.getEnd(); i++) {
                    newRange.add(i, r2.getValue(i));
                }
                print(newRange);

                System.out.println("r1.end is partially inside");
            }
        } else if (r1.getEnd() <= r2.getEnd()) {
            System.out.println("r1 is inside");
        } else {
            System.out.println("r1.start is partially inside");
        }
    }

    static class RangeValue {

        Long start;
        Long end;
        Long initialValue;

        Map<Long, Long> values = new HashMap<>();

        public RangeValue (final Long start, final Long end, final Long initialValue) {
            this.start = start;
            this.end = end;
            this.initialValue = initialValue;
        }

        public Long getStart () {
            return start;
        }

        public Long getEnd () {
            return end;
        }

        public Long getInitialValue () {
            return initialValue;
        }

        public void add(final Long position, final Long value) {
            if (values.containsKey(position)) {
                values.put(position, values.get(position) + value);
            } else {
                values.put(position, initialValue + value);
            }
        }

        public Long getValue(final Long position) {
            if (values.containsKey(position)) {
                return values.get(position);
            } else {
                return initialValue;
            }
        }

        @Override
        public String toString () {
            final StringBuilder builder = new StringBuilder()//
                    .append("Range [")//
                    .append("start=")//
                    .append(start)//
                    .append(",end=")//
                    .append(end)//
                    .append(",initialValue=")//
                    .append(initialValue)//
                    .append("]");

            if (!values.isEmpty()) {
                builder.append("[");
                for (Map.Entry<Long, Long> entry : values.entrySet()) {
                    builder.append(entry.getKey());
                    builder.append("=");
                    builder.append(entry.getValue());
                    builder.append(",");
                }
                builder.append("]");
            }

            return builder.toString();
        }
    }
}

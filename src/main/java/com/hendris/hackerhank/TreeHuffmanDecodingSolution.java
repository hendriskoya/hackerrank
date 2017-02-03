package com.hendris.hackerhank;

/**
 * @author hendris
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 1/11/17 10:50 AM
 */
public class TreeHuffmanDecodingSolution {

    public static void main(String[] args) {
        Node nodeB = new Node();
        nodeB.frequency = 1;
        nodeB.data = 'B';

        Node nodeC = new Node();
        nodeC.frequency = 1;
        nodeC.data = 'C';

        Node node2 = new Node();
        node2.frequency = 2;
        node2.data = '\0';
        node2.left = nodeB;
        node2.right = nodeC;

        Node nodeA = new Node();
        nodeA.frequency = 3;
        nodeA.data = 'A';

        Node node5 = new Node();
        node5.frequency = 5;
        node5.data = '\0';

        node5.left = node2;
        node5.right = nodeA;

        System.out.println(node5);

        new TreeHuffmanDecodingSolution().decode("1001011", node5);
    }

    void decode(String value, Node root) {
        StringBuffer result = new StringBuffer();
        for (int j = 0; j < value.length(); j++) {
            final char c = value.charAt(j);
            result.append(decodeChar(c, root));
        }
    }

    private char decodeChar(final char c, final Node root) {

        return '\0';
    }

    static class Node {
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;
    }
}

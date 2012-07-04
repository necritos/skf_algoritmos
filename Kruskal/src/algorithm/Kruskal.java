package algorithm;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author williams
 */
import java.io.*;
import java.util.*;

public class Kruskal {

    private final int MAX_NODES = 21;
    private HashSet nodes[];
    private TreeSet allEdges;
    private Vector allNewEdges;

    Kruskal() {
        // Constructor
        nodes = new HashSet[MAX_NODES];
        allEdges = new TreeSet(new Edge());
        allNewEdges = new Vector(MAX_NODES);
    }

    public void readInGraphData(String fileName) {
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(file);
            String line = buff.readLine();
            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line, " ");
                int from = Integer.valueOf(tok.nextToken()).intValue();
                int to = Integer.valueOf(tok.nextToken()).intValue();
                int cost = Integer.valueOf(tok.nextToken()).intValue();

                allEdges.add(new Edge(from, to, cost));
                if (nodes[from] == null) {

                    nodes[from] = new HashSet(2 * MAX_NODES);
                    nodes[from].add(new Integer(from));
                }

                if (nodes[to] == null) {

                    nodes[to] = new HashSet(2 * MAX_NODES);
                    nodes[to].add(new Integer(to));
                }

                line = buff.readLine();
            }
            buff.close();
        } catch (IOException e) {
        }
    }

    public void performKruskal() {
        int size = allEdges.size();
        for (int i = 0; i < size; i++) {
            Edge curEdge = (Edge) allEdges.first();
            if (allEdges.remove(curEdge)) {
                if (nodesAreInDifferentSets(curEdge.from, curEdge.to)) {
                    HashSet src, dst;
                    int dstHashSetIndex;
                    if (nodes[curEdge.from].size() > nodes[curEdge.to].size()) {
                        src = nodes[curEdge.to];
                        dst = nodes[dstHashSetIndex = curEdge.from];
                    } else {
                        src = nodes[curEdge.from];
                        dst = nodes[dstHashSetIndex = curEdge.to];
                    }
                    Object srcArray[] = src.toArray();
                    int transferSize = srcArray.length;
                    for (int j = 0; j < transferSize; j++) {
                        if (src.remove(srcArray[j])) {
                            dst.add(srcArray[j]);
                            nodes[((Integer) srcArray[j]).intValue()] = nodes[dstHashSetIndex];
                        } else {
                            System.out.println("error en la union de arboles");
                            System.exit(1);
                        }
                    }
                    allNewEdges.add(curEdge);
                }
            } else {
                System.out.println("el conjunto contiene esto elementos");
                System.exit(1);
            }
        }
    }

    private boolean nodesAreInDifferentSets(int a, int b) {
        return (!nodes[a].equals(nodes[b]));
    }

    public void printFinalEdges() {
        System.out.println("Arbol de expancion minima"
                + "\nalgoritmo de kruskal: ");
        while (!allNewEdges.isEmpty()) {
            Edge e = (Edge) allNewEdges.firstElement();
            System.out.println("Nodos: (" + e.from + ", " + e.to
                    + ") tiene costo: " + e.cost);
            allNewEdges.remove(e);
        }
    }

    class Edge implements Comparator {

        public int from, to, cost;

        public Edge() {
        }

        public Edge(int f, int t, int c) {
            from = f;
            to = t;
            cost = c;
        }

        public int compare(Object o1, Object o2) {
            int cost1 = ((Edge) o1).cost;
            int cost2 = ((Edge) o2).cost;
            int from1 = ((Edge) o1).from;
            int from2 = ((Edge) o2).from;
            int to1 = ((Edge) o1).to;
            int to2 = ((Edge) o2).to;

            if (cost1 < cost2) {
                return (-1);
            } else if (cost1 == cost2 && from1 == from2 && to1 == to2) {
                return (0);
            } else if (cost1 == cost2) {
                return (-1);
            } else if (cost1 > cost2) {
                return (1);
            } else {
                return (0);
            }
        }

        public boolean equals(Object obj) {
            Edge e = (Edge) obj;
            return (cost == e.cost && from == e.from && to == e.to);
        }
    }
}

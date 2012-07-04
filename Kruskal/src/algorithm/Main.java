package algorithm;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author williams
 */
public class Main {
    public static void main(String args[]) {
        Kruskal k = new Kruskal();
        k.readInGraphData("data.in");
        k.performKruskal();
        k.printFinalEdges();
    }
}

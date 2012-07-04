/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author williams
 */
public class Main {

    public static void main(String[] args) {
        int mat[][] = {
            {99999, 3, 10, 99999, 99999},
            {3, 99999, 99999, 5, 99999},
            {10, 99999, 99999, 6, 15},
            {99999, 5, 6, 99999, 4},
            {99999, 99999, 15, 4, 99999}
        };
        
        for (int j = 0; j < mat.length; j++) {
            for (int i = 0; i < mat[j].length; i++) {
                if(mat[j][i]==99999){
                    System.out.print(" "+"INF");
                }else{
                    System.out.print(" " + mat[j][i]);
                }                
            }
            System.out.println("");
        }
        
        Floyd floyd  = new Floyd();
        mat = floyd.algorithm(mat);
        
        for (int j = 0; j < mat.length; j++) {
            for (int i = 0; i < mat[j].length; i++) {
                System.out.print(" " + mat[j][i]);
            }
            System.out.println("");
        }
    }
}

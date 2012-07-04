/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author williams
 */
public class Floyd {

    public int[][] algorithm(int[][] mat) {
        for (int k = 0; k < mat.length; k++) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
        return mat;
    }
}

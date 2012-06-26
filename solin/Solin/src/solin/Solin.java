/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solin;


import java.util.ArrayList;
import java.util.List;
import solin.controller.Application;

/**
 *
 * @author Manuel
 */
public class Solin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<List<Integer>> m=new ArrayList<List<Integer>>();
        List<Integer> a=new ArrayList<Integer>();
        a.add(-1);a.add(3);a.add(1);a.add(-1);a.add(-1);a.add(-1);a.add(-1);
        m.add(a);
        a=new ArrayList<Integer>();
        a.add(3);a.add(-1);a.add(8);a.add(7);a.add(5);a.add(-1);a.add(-1);
        m.add(a);
        a=new ArrayList<Integer>();
        a.add(1);a.add(8);a.add(-1);a.add(-1);a.add(-1);a.add(-1);a.add(-1);
        m.add(a);
        a=new ArrayList<Integer>();
        a.add(-1);a.add(7);a.add(-1);a.add(-1);a.add(6);a.add(-1);a.add(9);
        m.add(a);
        a=new ArrayList<Integer>();
        a.add(-1);a.add(5);a.add(-1);a.add(6);a.add(-1);a.add(1);a.add(2);
        m.add(a);
        a=new ArrayList<Integer>();
        a.add(-1);a.add(-1);a.add(-1);a.add(-1);a.add(1);a.add(-1);a.add(4);
        m.add(a);
        a=new ArrayList<Integer>();
        a.add(-1);a.add(-1);a.add(-1);a.add(9);a.add(2);a.add(4);a.add(-1);
        m.add(a);
        Application apl=new Application();
        apl.setM(m);
        apl.action();
        apl.result();
    }
}

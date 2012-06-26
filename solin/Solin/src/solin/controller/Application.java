/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solin.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class Application {
    List<List<Integer>> M;
    List<Integer> colums=new ArrayList<Integer>();
    List<Integer> rows=new ArrayList<Integer>();
    List<Integer> values=new ArrayList<Integer>();
    List<List<Integer>> m;
    Integer currentCol;
    
     public Application(){
         init();
    }
    
    private void init() {
        
    }
    private void crossCol(int col){
        for (int i = 0; i < M.size(); i++) {
            List<Integer> list = M.get(i);
            list.set(col, -1);
        }
    }
    private int searchValue(){
        Integer val=Integer.MAX_VALUE;
        int row=0;
        int col=0;
        for (int i = 0; i < colums.size(); i++) {
            
            List<Integer> list = M.get(colums.get(i));
            
            for (int j = 0; j < list.size(); j++) {
                Integer integer = list.get(j);
                if(integer<val&&integer!=-1){
                    val=integer;
                    col=j;
                    row=colums.get(i);
                }
            }
        }
        //int cc=currentCol;
        System.out.println(" columna:"+col+" fila:"+row+" valor:"+val);
        m.get(row).set(col, val);
        crossCol(col);
        
        colums.add(col);
        rows.add(row);
        values.add(val);
        return val;
    }
    private Integer searchFirstValue(){
         Integer val=Integer.MAX_VALUE;
        int row=0;
        int col=0;
        for (int i = 0; i < M.size(); i++) {
            List<Integer> list = M.get(i);
            for (int j = 0; j < list.size(); j++) {
                Integer integer = list.get(j);
                if(integer<val&&integer!=-1){
                    val=integer;
                    col=j;
                    row=i;
                    
                }
            }
        }
        System.out.println(" columna:"+col+" fila:"+row+" valor:"+val);
        m.get(row).set(col, val);
        crossCol(col);
        
        colums.add(col);
        rows.add(row);
        values.add(val);
        return val;
    }
    
    public void action(){
        int a=searchFirstValue();
        System.out.println(":::::::::::::::matriz final:::::::::::::::");
        while(M.size()>colums.size()){
            
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            for (int i = 0; i < M.size(); i++) {
                List<Integer> list = M.get(i);
                for (int j = 0; j < list.size(); j++) {
                    Integer integer = list.get(j);
                    System.out.print("   "+integer+"   "); 
                    
                }
                System.out.println();
            }
            searchValue();
        }
    }
    public void result(){
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
        
      
        for (int i = 0; i < m.size(); i++) {
                List<Integer> list = m.get(i);
                for (int j = 0; j < list.size(); j++) {
                    Integer integer = list.get(j);
                    System.out.print("   "+integer+"   "); 
                }
                System.out.println();
       }
    }
    public List<List<Integer>> getM() {
        return M;
        
    }

    public void setM(List<List<Integer>> M) {
        m=new ArrayList<List<Integer>>();
        for (int i = 0; i < M.size(); i++) {
            List<Integer> ll=new ArrayList<Integer>();
            for (int j = 0; j < M.size(); j++) {
                ll.add(-1);
                
            }
            m.add(ll);
        }
        this.M = M;
    }
    
    
}

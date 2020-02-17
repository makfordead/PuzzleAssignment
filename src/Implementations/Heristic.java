package Implementations;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author umaan
 */
public class Heristic implements Interfaces.HeristicFunction{
    
    static int[][] goal = {
      {0, 1, 2, 3}, 
      {4, 5,6 , 7},
      {8,  9, 10,  11},
      {12 ,  13, 14, -1}
};

    public int getFunctionValue(int[][] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=goal[i][j])
                    count++;
            }
        }
        return count;
    }
}

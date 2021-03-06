package Implementations;

import AbstractClasses.PuzzleBlock;

import java.util.LinkedList;
import java.util.List;

public class PuzzleBlockImpl extends PuzzleBlock {



    public void printDetails() {
        int[][] Array = this.getArr();
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array.length; j++) {
                System.out.print(Array[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public List<int[][]> makeAllPossibleMoves() {
        int empty_row=0;
        int empty_col=0;

        for(int i=0;i<Array.length;i++){
            for(int j=0;j<Array[i].length;j++){
                if(Array[i][j]==-1)
                {
                    empty_row=i;
                    empty_col=j;
                    break;
                }
            }
        }
        LinkedList<int[][]> list = new LinkedList<int[][]>();
        int[][] temp= new int[Array.length][Array.length];
        int str;
        try {//move left
            for(int i=0;i<Array.length;i++){
                for(int j=0;j<Array[i].length;j++){
                    temp[i][j]=Array[i][j];
                }
            }
            str=temp[empty_row][empty_col];
            temp[empty_row][empty_col]=temp[empty_row][empty_col-1];
            temp[empty_row][empty_col-1]=str;
            list.add(temp);
        } catch (Exception e) {
            System.out.println("Not possible");
        }
        temp= new int[Array.length][Array.length];
        try {//move right
            for(int i=0;i<Array.length;i++){
                for(int j=0;j<Array[i].length;j++){
                    temp[i][j]=Array[i][j];
                }
            }
            str=temp[empty_row][empty_col];
            temp[empty_row][empty_col]=temp[empty_row][empty_col+1];
            temp[empty_row][empty_col+1]=str;
            list.add(temp);
        } catch (Exception e) {
            System.out.println("Not Possible");
        }
        temp= new int[Array.length][Array.length];
        try {//move up
            for(int i=0;i<Array.length;i++){
                for(int j=0;j<Array[i].length;j++){
                    temp[i][j]=Array[i][j];
                }
            }
            str=temp[empty_row][empty_col];
            temp[empty_row][empty_col]=temp[empty_row-1][empty_col];
            temp[empty_row-1][empty_col]=str;
            list.add(temp);
        } catch (Exception e) {
            System.out.println("Not possible");
        }
        temp= new int[Array.length][Array.length];
        try {//move down
            for(int i=0;i<Array.length;i++){
                for(int j=0;j<Array[i].length;j++){
                    temp[i][j]=Array[i][j];
                }
            }
            str=temp[empty_row][empty_col];
            temp[empty_row][empty_col]=temp[empty_row+1][empty_col];
            temp[empty_row+1][empty_col]=str;
            list.add(temp);
        } catch (Exception e) {
            System.out.println("Not possible");
        }
        return list;
    }
}

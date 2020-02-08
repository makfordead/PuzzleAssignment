package Implementations;

import AbstractClasses.PuzzleBlock;

import java.util.List;

public class PuzzleBlockImpl extends PuzzleBlock {




    @Override
    public WrapperForRowAndColumn getEmptySpace() {
        int[][] Array = this.getArr();
        for (int i = 0; i < Array.length ; i++) {
            for (int j = 0; j < Array.length; j++) {
                if(Array[i][j] == -1)
                {
                    WrapperForRowAndColumn wrapperForRowAndColumn = new WrapperForRowAndColumn(i , j);
                    return wrapperForRowAndColumn;
                }
            }
        }
        return null;
    }

    @Override
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
    public List<Integer[][]> makeAllPossibleMoves() {
        return null;
    }
}

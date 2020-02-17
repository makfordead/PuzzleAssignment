package AbstractClasses;

import Interfaces.HeristicFunction;

import java.util.List;

public abstract class PuzzleBlock {
    public int[][] Array;
    private HeristicFunction heristicFunction;


    public abstract void printDetails();

    public abstract List<int[][]> makeAllPossibleMoves();

    public HeristicFunction getHeristicFunction() {
        return heristicFunction;
    }

    public void setHeristicFunction(HeristicFunction heristicFunction) {
        this.heristicFunction = heristicFunction;
    }

    public int getValue(int[][] arr)
    {
        return heristicFunction.getFunctionValue(arr);
    }
    public int[][] getArr() {
        return Array;
    }

    public void setArr(int[][] arr) {
        this.Array = arr;
    }
}


package AbstractClasses;

import Interfaces.HeristicFunction;

import java.util.List;

public abstract class PuzzleBlock {
    public Integer[][] Array;
    private HeristicFunction heristicFunction;


    public abstract void printDetails();

    public abstract List<Integer[][]> makeAllPossibleMoves();

    public HeristicFunction getHeristicFunction() {
        return heristicFunction;
    }

    public void setHeristicFunction(HeristicFunction heristicFunction) {
        this.heristicFunction = heristicFunction;
    }

    public int getValue(Integer[][] arr)
    {
        return heristicFunction.getFunctionValue(arr);
    }
    public Integer[][] getArr() {
        return Array;
    }

    public void setArr(Integer[][] arr) {
        this.Array = arr;
    }
}


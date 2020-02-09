package AbstractClasses;

import Implementations.WrapperForRowAndColumn;
import Interfaces.HeristicFunction;

import java.util.LinkedList;
import java.util.List;

public abstract class PuzzleBlock {
    public int[][] Array;
    private HeristicFunction heristicFunction;


    public abstract WrapperForRowAndColumn getEmptySpace();

    public abstract void printDetails();

    public abstract List<Integer[][]> makeAllPossibleMoves();

    public HeristicFunction getHeristicFunction() {
        return heristicFunction;
    }

    public void setHeristicFunction(HeristicFunction heristicFunction) {
        this.heristicFunction = heristicFunction;
    }

    public int getValue()
    {
        return heristicFunction.getFunctionValue(this.Array);
    }
    public int[][] getArr() {
        return Array;
    }

    public void setArr(int[][] arr) {
        this.Array = arr;
    }
}


package AbstractClasses;

import Implementations.WrapperForRowAndColumn;
import Interfaces.HeristicFunction;

import java.util.LinkedList;
import java.util.List;

public abstract class PuzzleBlock {
    private int[][] arr;
    private HeristicFunction heristicFunction;


    public abstract WrapperForRowAndColumn getEmptySpace();
    public abstract  void printDetails();
    public abstract List<Integer[][]> makeAllPossibleMoves();

    public HeristicFunction getHeristicFunction() {
        return heristicFunction;
    }

    public void setHeristicFunction(HeristicFunction heristicFunction) {
        this.heristicFunction = heristicFunction;
    }

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }
}


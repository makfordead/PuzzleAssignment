package AbstractClasses;

import Interfaces.HeristicFunction;

import java.util.LinkedList;
import java.util.List;

public abstract class PuzzleBlock {
    int[][] arr;
    HeristicFunction heristicFunction;


    public void setHeristicFunction(){};
    private void getHeristicFunctionValue(){};
    private Integer getEmptySpace(){return null;};
    public void printDetails(){};
    private List<Integer[][]> makeAllPossibleMoves;





}

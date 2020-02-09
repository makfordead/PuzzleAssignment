import AbstractClasses.PuzzleBlock;
import Implementations.Heristic;
import Implementations.PuzzleBlockImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Heristic heristic = new Heristic();
        System.out.println(heristic.getFunctionValue(new int[][]{{12, 13, 12, -1}, {8, 9, 10, 11}, {4, 5, 6, 7}, {0, 1, 2, 3}}));
        PuzzleBlock puzzleBlock = new PuzzleBlockImpl();
        puzzleBlock.setArr(new int[][]{{0,1,2,3}, {4,5,6,7}, {8,9,10,11}, {12,13,14,-1}});
        List<Integer[][]> list = puzzleBlock.makeAllPossibleMoves();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.print(list.get(i)[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("_________");
        }
    }
}

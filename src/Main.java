import AbstractClasses.Node;
import AbstractClasses.PuzzleBlock;
import Implementations.Heristic;
import Implementations.PuzzleBlockImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
      Node node = new Node();
      Integer[][] arr = {
              {0, 1, 2, 3},
              {4, 5,-1 , 7},
              {8,  9, 10,  11},
              {12 ,  13, 14, 6}
      };
      PuzzleBlock puzzleBlock =   new PuzzleBlockImpl();
      puzzleBlock.setArr(arr);
      puzzleBlock.setHeristicFunction(new Heristic());
      List<Integer[][]> list = puzzleBlock.makeAllPossibleMoves();
        for (Integer[][] temp: list
             ) {
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp.length; j++) {
                    System.out.print(temp[i][j] + " ") ;
                }
                System.out.println();
            }
            System.out.println("____________________________");
            System.out.println(puzzleBlock.getHeristicFunction().getAnotherFunction(temp));
            System.out.println("____________________________");

        }
        node.setPuzzleBlock(puzzleBlock);
        System.out.println(node.findMinimumValue(list));
        System.out.println(node.findNumberOfMinimumValuesThatOccur(list, node.findMinimumValue(list)));
        System.out.println(node.findTheIndex(list));



    }
    }


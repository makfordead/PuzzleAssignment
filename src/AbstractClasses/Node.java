package AbstractClasses;

import Implementations.Heristic;
import Implementations.PuzzleBlockImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Node {
    PuzzleBlock puzzleBlock;
    Node node;

    public Node()
    {
        PuzzleBlock puzzleBlock = new PuzzleBlockImpl();
        puzzleBlock.setArr(Node.Random());
        System.out.println(puzzleBlock.getArr());
        puzzleBlock.setHeristicFunction(new Heristic());
        this.puzzleBlock = puzzleBlock;

    }
    public  void setPuzzleBlock(PuzzleBlock puzzleBlock){
        this.puzzleBlock=puzzleBlock;
    }
    public void search()
    {
        PuzzleBlock temp = this.puzzleBlock;
        System.out.println(this.puzzleBlock.getValue(puzzleBlock.Array));

        List<Integer[][]> allStates = temp.makeAllPossibleMoves();
        // 4 se 3 dekhni ha

        Integer[] HeristicValues = new Integer[allStates.size()];

        for (int i = 0; i < HeristicValues.length; i++) {

            HeristicValues[i] = temp.getValue(allStates.get(i));
            System.out.println(HeristicValues[i]);
        }
    }
    public static Integer[][] Random()
    {
        int counter = 0;
        Integer[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,-1};
        List<Integer> l = Arrays.asList(a);
        Collections.shuffle(l);
        l.toArray(a);
        int count = -1;
        Integer[][] arr = new Integer[4][4];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                arr[i][j] = a[counter++];
            }
        }
        check(arr);
        return arr;
    }
    public static void check(Integer[][] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean isGoalState(Integer[][] arr)
    {
        int[][] goal = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,-1}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] != goal[i][j])
                    return false;
            }
        }
        return true;
    }

}

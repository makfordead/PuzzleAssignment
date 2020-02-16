package AbstractClasses;

import Implementations.Heristic;
import Implementations.PuzzleBlockImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node {
    PuzzleBlock puzzleBlock;
    Node node;
    public Node()
    {
        this.puzzleBlock= new PuzzleBlockImpl();
        this.puzzleBlock.setHeristicFunction(new Heristic());
    }

    public Node(Boolean bool)
    {
        PuzzleBlock puzzleBlock = new PuzzleBlockImpl();
        puzzleBlock.setArr(Node.Random());

        puzzleBlock.setHeristicFunction(new Heristic());
        this.puzzleBlock = puzzleBlock;

    }
    public  void setPuzzleBlock(PuzzleBlock puzzleBlock){
        this.puzzleBlock=puzzleBlock;
    }
    public Boolean isGoalState()
    {
        int[][] goal = {
                {0, 1, 2, 3},
                {4, 5,6 , 7},
                {8,  9, 10,  11},
                {12 ,  13, 14, -1}
        };
        for (int i = 0; i < puzzleBlock.Array.length; i++) {
            for (int j = 0; j < puzzleBlock.Array.length; j++) {
                if(puzzleBlock.Array[i][j] != goal[i][j])
                    return false;
            }
        }
        return true;
    }

    public void search()
    {
        Node temp = this;

        while (!temp.isGoalState())
        {

            System.out.println("1");
            PuzzleBlock toInclude = new PuzzleBlockImpl();
            List<Integer[][]> choices = temp.puzzleBlock.makeAllPossibleMoves();
            Integer index = findTheIndex(choices);
            System.out.println("INDEX : " + index);
            toInclude.setArr(choices.get(index));
            toInclude.setHeristicFunction(new Heristic());
            Node nodeToAdd = new Node();
            nodeToAdd.setPuzzleBlock(toInclude);
            temp.node = nodeToAdd;
            temp=temp.node;
            System.out.println("___________");
            System.out.println(temp);
            System.out.println("___________");
            print(temp.puzzleBlock.Array);

        }
    }
    public  Integer findTheIndex(List<Integer[][]> list)
    {
        Integer minimumValue = findMinimumValue(list);
        Integer occurencedOfMinimumValue = findNumberOfMinimumValuesThatOccur(list,minimumValue);
        List<Integer> index  = findIndexesOfMinimumValue(list, minimumValue);
        if(occurencedOfMinimumValue > 1)
        {
            Collections.shuffle(index);
            return index.get(0);

        }
        else
        {
            return index.get(0);
        }

            }
    public Integer findMinimumValue(List<Integer[][]> list)
    {
        Integer minValue= Integer.MAX_VALUE;
        for (Integer[][] arr: list)
        {
            int temp =   this.puzzleBlock.getHeristicFunction().getFunctionValue(arr);
            if(temp < minValue)
            {
                minValue = temp;
            }
        }
        return minValue;
    }
    public Integer findNumberOfMinimumValuesThatOccur(List<Integer[][]> list,Integer val)
    {
        Integer counter=0;
        for (Integer[][] arr: list
             ) {
            if(this.puzzleBlock.getHeristicFunction().getFunctionValue(arr) == val)
                counter++;
        }
        return counter;
    }
    public List<Integer> findIndexesOfMinimumValue(List<Integer[][] >list,Integer val)
    {
        List<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer[][] temp = list.get(i);
            if(this.puzzleBlock.getHeristicFunction().getFunctionValue(temp)==val)
                indexes.add(i);
        }
        return indexes;
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
    public void print(Integer[][] arr)
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

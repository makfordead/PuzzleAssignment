    package AbstractClasses;

    import Implementations.Astar;
    import Implementations.Heristic;
    import Implementations.PuzzleBlockImpl;

    import java.util.Arrays;
    import java.util.Collections;
    import java.util.LinkedList;
    import java.util.List;

    public class Node {
        public static int[][] lastState = new int[4][4];
        public PuzzleBlock puzzleBlock;
        public Node node;
        public static int depth =0;

        public Node() {

            this.puzzleBlock = new PuzzleBlockImpl();
            this.puzzleBlock.setHeristicFunction(new Heristic());
        }

        public Node(Boolean bool) {

            PuzzleBlock puzzleBlock = new PuzzleBlockImpl();
            System.out.println("START");
            //1,3,4,5,12,2,14,6,11,0,8,15,10,13,9,7
            int[][] TESTING = {{1,3,4,5},{12,2,14,6},{11,-1,8,15},{10,13,9,7}};
            int[][] goal = {
                    {1, 5, 3, 7},
                    {0, 6,2, -1},
                    {4,  9, 10,  11},
                    { 8,  12, 13, 14}
            };
            check(goal);
            puzzleBlock.setArr(goal);
            System.out.println("END");
            puzzleBlock.setHeristicFunction(new Heristic());
            this.puzzleBlock = puzzleBlock;


        }

        public void setPuzzleBlock(PuzzleBlock puzzleBlock) {
            this.puzzleBlock = puzzleBlock;
        }

        public Boolean isGoalState() {
            int [][] goal = {
                    {0, 1, 2, 3},
                    {4, 5, 6, 7},
                    {8, 9, 10, 11},
                    {12, 13, 14, -1}
            };
            for (int i = 0; i < puzzleBlock.Array.length; i++) {
                for (int j = 0; j < puzzleBlock.Array.length; j++) {
                    if (puzzleBlock.Array[i][j]!=( goal[i][j]))
                        return false;
                }
            }
            return true;
        }

        public void search() {
            this.puzzleBlock.setHeristicFunction(new Heristic());
            int counter = 0;
            List<int[][]> firstChoices = this.puzzleBlock.makeAllPossibleMoves();
            System.out.println("____________");
            System.out.println("_____________");
            System.out.println("THE NUMBER OF CHOICES ARE " + firstChoices.size());
            for (int[][] p:
                    firstChoices) {print(p);
                System.out.println("                    ");

            }
            System.out.println("_____________");
            System.out.println("_____________");

            int include = this.findTheIndex(firstChoices);


            PuzzleBlockImpl newpuzzleBlock = new PuzzleBlockImpl();
            newpuzzleBlock.setArr(firstChoices.get(include));


            newpuzzleBlock.setHeristicFunction(new Heristic());
            Node newnode = new Node();
            newnode.setPuzzleBlock(newpuzzleBlock);
            copyTheArray(lastState, this.puzzleBlock.getArr());
            this.node= newnode;

            Node temp = this.node;
            System.out.println("_________CHOICE INCLUDED");
            print(temp.puzzleBlock.getArr());
            System.out.println("________________");
            System.out.println("________LAST STATE");
            print(lastState);
            System.out.println("____________");
            while(!temp.isGoalState() )
            {

                List<int[][]> choices = temp.puzzleBlock.makeAllPossibleMoves();
                System.out.println("THE NUMBER OF CHOICES ARE " + choices.size());
                for (int[][] p:
                        choices) {print(p);
                    System.out.println("                    ");

                }
                System.out.println("______________________");
                temp.deletePreviousStateChoices(choices);
                for (int[][] p:
                        choices) {print(p);
                    System.out.println("                    ");

                }
                System.out.println("after DELETION THE SIZE IS" + choices.size() );
                int index =findTheIndex(choices);
                PuzzleBlockImpl newPuzzleBlock = new PuzzleBlockImpl();
                newPuzzleBlock.setHeristicFunction(new Heristic());
                newPuzzleBlock.setArr(choices.get(index));
                Node newNode = new Node();
                newNode.setPuzzleBlock(newPuzzleBlock);
                copyTheArray(lastState, temp.puzzleBlock.getArr());
                temp.node = newNode;
                temp = temp.node;
                print(temp.puzzleBlock.getArr());
                counter ++;
                System.out.println("THIS IS THE SELECTED StATE ________");
                print(temp.puzzleBlock.getArr());
                System.out.println("______________END______________");
            }
        }

        public void search2() {
            this.puzzleBlock.setHeristicFunction(new Astar());
            int counter = 0;
            List<int[][]> firstChoices = this.puzzleBlock.makeAllPossibleMoves();
            System.out.println("____________");
            System.out.println("_____________");
            System.out.println("THE NUMBER OF CHOICES ARE " + firstChoices.size());
            for (int[][] p:
                    firstChoices) {print(p);
                System.out.println("                    ");

            }
            System.out.println("_____________");
            System.out.println("_____________");

            int include = this.findTheIndex(firstChoices);


            PuzzleBlockImpl newpuzzleBlock = new PuzzleBlockImpl();
            newpuzzleBlock.setArr(firstChoices.get(include));


            newpuzzleBlock.setHeristicFunction(new Astar());
            Node newnode = new Node();
            newnode.setPuzzleBlock(newpuzzleBlock);
            copyTheArray(lastState, this.puzzleBlock.getArr());
            this.node= newnode;

            Node temp = this.node;
            System.out.println("_________CHOICE INCLUDED");
            print(temp.puzzleBlock.getArr());
            System.out.println("________________");
            System.out.println("________LAST STATE");
            print(lastState);
            System.out.println("____________");
            while(!temp.isGoalState() )
            {

                List<int[][]> choices = temp.puzzleBlock.makeAllPossibleMoves();
                System.out.println("THE NUMBER OF CHOICES ARE " + choices.size());
                for (int[][] p:
                        choices) {print(p);
                    System.out.println("                    ");

                }
                System.out.println("______________________");
                temp.deletePreviousStateChoices(choices);
                for (int[][] p:
                        choices) {print(p);
                    System.out.println("                    ");

                }
                System.out.println("after DELETION THE SIZE IS" + choices.size() );
                int index =findTheIndex(choices);
                PuzzleBlockImpl newPuzzleBlock = new PuzzleBlockImpl();
                newPuzzleBlock.setHeristicFunction(new Astar());
                newPuzzleBlock.setArr(choices.get(index));
                Node newNode = new Node();
                newNode.setPuzzleBlock(newPuzzleBlock);
                copyTheArray(lastState, temp.puzzleBlock.getArr());
                temp.node = newNode;
                temp = temp.node;
                Node.depth++;
                print(temp.puzzleBlock.getArr());
                counter ++;
                System.out.println("THIS IS THE SELECTED StATE ________");
                print(temp.puzzleBlock.getArr());
                System.out.println("______________END______________");
            }
        }

        public boolean isSameAsLastState(int[][] arr) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (arr[i][j]!=(lastState[i][j]) )

                        return false;
                }
            }
            return true;
        }
        public void deletePreviousStateChoices(List<int[][] > list)
        {
            int i = 0;
            for (; i < list.size(); i++) {
                System.out.println(isSameAsLastState(list.get(i)));
                if(isSameAsLastState(list.get(i))) {
                    System.out.println("removed");
                    list.remove(i);
                    break;
                }

            }


        }

        public void copyTheArray(int[][] to, int[][] from) {

            for (int i = 0; i < to.length; i++) {
                for (int j = 0; j < from.length; j++) {
                    to[i][j] = from[i][j];
                }
            }
        }

        public int findTheIndex(List<int[][]> list) {

            int minimumValue = findMinimumValue(list);
            List<Integer> index = findIndexesOfMinimumValue(list, minimumValue);
            Collections.shuffle(index);
            System.out.println("INDEX IS " + index.get(0));
            return index.get(0);


        }




        public int findMinimumValue(List<int[][]> list)
        {
            int minValue= Integer.MAX_VALUE;
            for (int[][] arr: list)
            {
                int temp =   this.puzzleBlock.getHeristicFunction().getFunctionValue(arr);

                if(temp<(minValue) )
                {
                    minValue = temp;
                }
            }
            return minValue;
        }

        public List<Integer> findIndexesOfMinimumValue(List<int[][] >list,int val)
        {

            List<Integer> indexes = new LinkedList<>();
            for (int i = 0; i < list.size(); i++) {
                int[][] temp = list.get(i);
                if(this.puzzleBlock.getHeristicFunction().getFunctionValue(temp)==val)
                    indexes.add(i);
            }
            return indexes;
        }



        public static int[][] Random()
        {
            int counter = 0;
            Integer[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,-1};
            List<Integer> l = Arrays.asList(a);
            Collections.shuffle(l);
            l.toArray(a);
            int count = -1;
            int[][] arr = new int[4][4];
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
        public static void check(int[][] arr)
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
        public boolean isGoalState(int[][] arr)
        {
            int[][] goal = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,-1}};
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if(arr[i][j] !=( goal[i][j]) )
                        return false;
                }
            }
            return true;
        }
        public void print(int[][] arr)
        {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

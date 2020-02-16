package Implementations;
import  AbstractClasses.Node;
public class NotMyGrade
{
    Node n = new Node();
    static int depth = 0;
    static Integer[][] LastState = null;

public void mainloop(Integer[][] a)
{
    while(!n.isGoalState(a))
    {
        //APPROACH = EACH STATE is Heuristic (h(x)) + Depth (d(x))
        LastState = a;
    }
}
}

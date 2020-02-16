package Implementations;
import AbstractClasses.Node;
public class StatePackage {
    Integer[][] state;
    int depth;
    int heu;

    public StatePackage(Integer[][] state, int depth, int heu) {
        this.state = state;
        this.depth = depth;
        this.heu = heu;
    }

    public Integer[][] getInteger(){
        return state;
    }

    public int getDepth(){
        return depth;
    }

    public int getHeu(){
        return heu;
    }
}

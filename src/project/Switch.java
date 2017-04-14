package project;

import java.util.*;

/**
 * osztaly ami a valtot valositja meg
 */
public class Switch extends Node {

    /**
     * Default constructor
     */
    public Switch(){
        this.x=0;
        this.y=0;
        this.nextNode=null;
        this.next2Node= null;
        this.prevNode=null;
    }


    /**
     * 
     */
    private Node next2Node;


    /**
     * @param x koordinata
     * @param y koordinata
     * @param n egyik kimenetcsomopont
     * @param n2 masik kimenetcsomopont
     * @param p elozo csomopont
     */
    public Switch(int x, int y, Node n, Node n2, Node p) {
        // TODO implement here
        this.x = x;
        this.y=y;
        this.nextNode = n;
        this.next2Node = n2;
        this.prevNode  = p;
    }

    /**
     * megcsereli a valto kimenetet
     */
    public void changeOutput() {
        // TODO implement here
        Node temp = nextNode;
        nextNode = next2Node;
        next2Node = temp;
    }

    /**
     * @return visszater masik kimenetcsomoponttal
     */
    public Node getSecond() {
        // TODO implement here
        return next2Node;
    }

    /**
     * @param n2 beallitja a masik kimenetcsomopontot
     */
    public void setSecond(Node n2) {
        // TODO implement here
        this.next2Node = n2;
    }

}
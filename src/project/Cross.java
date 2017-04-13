package project;

import java.util.*;

/**
 * A kereszteződést megvalósító osztály
 */
public class Cross extends Rail {

    //******************************//
    //         Tagvaltozok          //
    //******************************//
    /**
     *
     */
    private Node next2Node;

    /**
     *
     */
    private Node prev2Node;


    //******************************//
    //         Konstruktorok        //
    //******************************//
    /**
     * Default constructor
     */
    public Cross() {
        super(0,0,null,null);
        next2Node=null;
        prev2Node=null;
    }

    /**
     * Konstruktor
     * @param x A keresztezősés x koordinátája.
     * @param y A kereszteződés y koordinátája.
     * @param n Az egyik irányból a következő csomópont.
     * @param p Az egyik irányból az előző csomópont.
     * @param n2 A másik irányból a következő csomópont.
     * @param p2 A másik irányból az előző csomóont.
     */
    public Cross(int x, int y, Node n, Node p, Node n2, Node p2) {
        super(x, y, n, p);
        this.next2Node = n2;
        this.prev2Node = p2;
    }


    //******************************//
    //          Metodusok           //
    //******************************//
    @Override
    public Node getNextNode(Train t){
        Node ret = null;

        if(t.getPrevNode().equals(nextNode))
            ret = prevNode;
        else if(t.getPrevNode().equals(prevNode))
            ret = nextNode;
        else if(t.getPrevNode().equals(next2Node))
            ret = prev2Node;
        else if(t.getPrevNode().equals(prev2Node))
            ret = next2Node;

        return ret;
    }


    //******************************//
    //       Getterek/Setterek      //
    //******************************//
    public Node getNext2() {
        return next2Node;
    }

    public void setNext2(Node next2Node) {
        this.next2Node = next2Node;
    }

    public Node getPrev2() {
        return prev2Node;
    }

    public void setPrev2(Node prev2Node) {
        this.prev2Node = prev2Node;
    }


}
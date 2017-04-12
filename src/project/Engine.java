package project;

import java.util.*;

/**
 * A mozdonyt megvalósító osztály
 */
public class Engine extends Train {

    //******************************//
    //         Konstruktorok        //
    //******************************//
    /**
     * Default constructor
     */
    public Engine() {
    }

    /**
     * @param x 
     * @param y 
     * @param xE 
     * @param yE 
     * @param c
     */
    public Engine(int x, int y, int xE, int yE, Node onNode, Color c) {
        super(x, y, xE, yE, onNode, c);
    }


    //******************************//
    //          Metodusok           //
    //******************************//
    @Override
    public Status move(){

        // CRASH

        Node next = onNode.getNextNode(this);
        prevNode = onNode;
        onNode = next;

        return nextCar.move();
    }

}
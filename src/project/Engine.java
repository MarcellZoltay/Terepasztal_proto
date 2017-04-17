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
        super(0,0,0,0,null, Color.ENGINE);
    }

    /**
     * @param x 
     * @param y 
     * @param xE 
     * @param yE 
     */
    public Engine(int x, int y, int xE, int yE, Node onNode) {
        super(x, y, xE, yE, onNode, Color.ENGINE);
    }


    //******************************//
    //          Metodusok           //
    //******************************//
    @Override
    public Status move(){

        List<Train> on = onNode.getNextNode(this).getTrains();
        if(!on.isEmpty()) return Status.CRASHED;

        Node next = onNode.getNextNode(this);
        prevNode = onNode;
        onNode = next;

        prevNode.removeTrain(this);
        onNode.addTrain(this);

        return nextCar.move();
    }

}
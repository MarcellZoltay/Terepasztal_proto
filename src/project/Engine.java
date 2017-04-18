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

        if(onNode.getNextNode(this)==null){
            return Status.NOT_EMPTY_CAR;
        }
        List<Train> on = onNode.getNextNode(this).getTrains();
        for(int i = 0 ; i<on.size();i++){
            System.out.println(on.toString());
        }
        if(!on.isEmpty()) return Status.CRASHED;

        Node next = onNode.getNextNode(this);
        prevNode = onNode;
        onNode = next;

        prevNode.removeTrain(this);
        onNode.addTrain(this);

        //System.out.println(nextCar.toString());
        return nextCar.move();
    }

}
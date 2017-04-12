package project;

import java.util.*;

/**
 * 
 */
public abstract class Node extends MapItem {

    /**
     * Default constructor
     */
    public Node() {
    }

    /**
     * 
     */
    protected Train[] trainsOn;

    /**
     * 
     */
    protected Node nextNode;

    /**
     * 
     */
    protected Node prevNode;


    /**
     * @param t
     */
    public void addTrain(Train t) {
        // TODO implement here
    }

    /**
     * @param t
     */
    public void removeTrain(Train t) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Train[] getTrains() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Node getNext() {
        // TODO implement here
        return null;
    }

    /**
     * @param n
     */
    public void setNext(Node n) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Node getPrev() {
        // TODO implement here
        return null;
    }

    /**
     * @param p
     */
    public void setPrev(Node p) {
        // TODO implement here
    }

    /**
     * @param t 
     * @return
     */
    public Node getNextNode(Train t) {
        // TODO implement here
        return null;
    }

}
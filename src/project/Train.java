package project;

import java.util.*;

/**
 * 
 */
public abstract class Train extends MapItem {

    /**
     * Default constructor
     */
    public Train() {
    }

    /**
     * 
     */
    protected int xEnd;

    /**
     * 
     */
    protected int yEnd;

    /**
     * 
     */
    protected Node onNode;

    /**
     * 
     */
    protected Node prevNode;

    /**
     * 
     */
    protected Train nextCar;

    /**
     * 
     */
    protected Color color;



    /**
     * @return
     */
    public Status move() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getEndX() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getEndY() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Node getOnNode() {
        // TODO implement here
        return null;
    }

    /**
     * @param n
     */
    public void setOneNode(Node n) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Node getPrevNode() {
        // TODO implement here
        return null;
    }

    /**
     * @param p
     */
    public void setPrevNode(Node p) {
        // TODO implement here
    }

    /**
     * 
     */
    public void getNextCar() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setNextCar() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Color getColor() {
        // TODO implement here
        return null;
    }

}
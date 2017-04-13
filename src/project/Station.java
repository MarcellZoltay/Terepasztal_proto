package project;

import java.util.*;

/**
 * osztaly ami megvalositja a
 */
public class Station extends Node {

    public Station(){
        this.x = 0;
        this.y = 0;
        this.nextNode = null;
        this.prevNode = null;
        this.color = null;
    }

    /**
     * 
     */
    private Color color;


    /**
     * @param x 
     * @param y 
     * @param n 
     * @param p 
     * @param c
     */
    public Station(int x, int y, Node n, Node p, Color c) {
        // TODO implement here
        this.x = x;
        this.y = y;
        this.nextNode = n;
        this.prevNode = p;
        this.color = c;
    }

    /**
     * @return
     */
    public Color getColor() {
        // TODO implement here
        return color;
    }

    public void setColor(Color c){
        this.color=c;
    }

}
package project;

import java.util.*;

/**
 * A sínt megvalósító osztály
 */
public class Rail extends Node {

    //******************************//
    //         Konstruktorok        //
    //******************************//
    /**
     * Default constructor
     
    public Rail() {
    }*/

    /**
     * @param x 
     * @param y 
     * @param n 
     * @param p
     */
    public Rail(int x, int y, Node n, Node p) {
        this.x = x;
        this.y = y;
        this.nextNode = n;
        this.prevNode = p;
    }

}
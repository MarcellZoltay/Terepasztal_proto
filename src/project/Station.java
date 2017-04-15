package project;

import java.util.*;

/**
 * osztaly ami megvalositja a
 */
public class Station extends Node {

    //******************************//
    //         Tagvaltozok          //
    //******************************//
    /**
     * 
     */
    private Color color;


    //******************************//
    //         Konstruktorok        //
    //******************************//

    /**
     * Default constructor
     */
    public Station(){
        super(0, 0, null, null);
        this.color = null;
    }

    /**
     * @param x 
     * @param y 
     * @param n 
     * @param p 
     * @param c
     */
    public Station(int x, int y, Node n, Node p, Color c) {
        super(x, y, n, p);
        this.color = c;
    }


    //******************************//
    //       Getterek/Setterek      //
    //******************************//
    /**
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param c
     */
    public void setColor(Color c){
        this.color = c;
    }

}
package project;

import java.util.*;

/**
 * absztrakt osztaly ami a mapitembol szarmazik es egy csomopontot valosit meg
 */
public abstract class Node extends MapItem {

    //******************************//
    //         Tagvaltozok          //
    //******************************//
    /**
     * A csomóponton lévő vonatrészek listája
     */
    protected ArrayList<Train> trainsOn = new ArrayList<>();

    /**
     * a kovetkezo csomopont
     */
    protected Node nextNode;

    /**
     * az elozo csomopont
     */
    protected Node prevNode;


    //******************************//
    //         Konstruktorok        //
    //******************************//
    /**
     * Konstruktor
     */
    public Node(int x, int y, Node n, Node p){
        super(x, y);
        this.nextNode = n;
        this.prevNode = p;
    }


    //******************************//
    //          Metodusok           //
    //******************************//
    /**
     * Hozzáadja a paraméterül kapott változót a vonatrészeket tároló tömbhöz.
     * @param t A listához adandó vonatrész.
     */
    public void addTrain(Train t) {
        trainsOn.add(t);
    }

    /**
     * Törli a paraméterül kapott vonatrészt a listából.
     * @param t A törlendő vonatrész.
     */
    public void removeTrain(Train t) {
        trainsOn.remove(t);
    }

    /**
     * Meghatarozza a kovetkezo csomopontot, amerre a vonatnak mennie kell
     * @param t vonatot kap parameterkent aminek lekerdezi az elozo Node-jat és ez alapjan eldonti merre kell tovabb mennie
     * @return A haladási iránynak megfelelő következő csomópont.
     */
    public Node getNextNode(Train t) {
        Node temp = t.prevNode;

        if (temp.equals(nextNode)){
            return prevNode;
        }
        else if(temp.equals(prevNode)){
            return nextNode;
        }

        return null;
    }


    //******************************//
    //       Getterek/Setterek      //
    //******************************//
    /**
     * @return visszatér a csomoponton levo vonatok listajaval
     */
    public ArrayList<Train> getTrains() {
        return trainsOn;
    }

    /**
     * @return visszater a kovetkezo Node-al
     */
    public Node getNext() {
        return nextNode;
    }

    /**
     * @param n beallitja a parameterkent kapott Nodeot kovetkezonek
     */
    public void setNext(Node n) {
        this.nextNode = n;
    }

    /**
     * @return visszater az elozo csomoponttal
     */
    public Node getPrev() {
        return prevNode;
    }

    /**
     * @param p beallitja elozo csopomontkent a parameterkent átadottat
     */
    public void setPrev(Node p) {
        this.prevNode = p;
    }

}
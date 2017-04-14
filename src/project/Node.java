package project;

import java.lang.reflect.Array;
import java.util.*;

/**
 * absztrakt osztaly ami a mapitembol szarmazik es egy csomopontot valosit meg
 */
public abstract class Node extends MapItem {

    /**
     * Default constructor
     */
    public Node() {
        super();
        this.nextNode=null;
        this.prevNode=null;
    }

    /**
     * lecsereltem a tombot listara hogy konzisztens legyen a doksival
     */
    //protected Train[] trainsOn;
    protected ArrayList<Train> trainsOn = new ArrayList<>();
    /**
     * a kovetkezo csomopont
     */
    protected Node nextNode;

    /**
     * az elozo csomopont
     */
    protected Node prevNode;


    /**
     * @param t Traint kap és hozzaadja a listahoz
     */
    public void addTrain(Train t) {
        // TODO implement here
        //trainsOn[trainsOn.length] = t;
        trainsOn.add(t);
    }

    /**
     * @param t Traint kap és ezt ha megtalálta a listába akkor eltávolítja
     */
    public void removeTrain(Train t) {
        // TODO implement here
        for(int i = 0; i<trainsOn.size();i++){
            if(trainsOn.get(i) == t){
                trainsOn.remove(i);
            }
        }
    }

    /**
     * @return
     */
    /*public Train[] getTrains() {
        // TODO implement here
        return trainsOn;
    }*/

    /**
     * @return visszatér a csomoponton levo vonatok listajaval
     */
    public ArrayList<Train> getTrains() {
        // TODO implement here
        return trainsOn;
    }

    /**
     * @return visszater a kovetkezo Node-al
     */
    public Node getNext() {
        // TODO implement here
        return nextNode;
    }

    /**
     * @param n beallitja a parameterkent kapott Nodeot kovetkezonek
     */
    public void setNext(Node n) {
        // TODO implement here
        this.nextNode = n;
    }

    /**
     * @return visszater az elozo csomoponttal
     */
    public Node getPrev() {
        // TODO implement here
        return prevNode;
    }

    /**
     * @param p beallitja elozo csopomontkent a parameterkent átadottat
     */
    public void setPrev(Node p) {
        // TODO implement here
        this.prevNode = p;
    }

    /**
     * @param t vonatot kap parameterkent aminek lekerdezi az elozo Nodejat és ez alapjan eldonti merre kell mennie tovabb
     * @return visszater azzal a node-al amerre a vonat haladni fog
     */
    public Node getNextNode(Train t) {
        // TODO implement here
        Node temp = t.prevNode;
        if (temp == nextNode){
            return prevNode;
        }
        else if(temp == prevNode){
            return nextNode;
        }
        return  null;
        /*if(t.getPrevNode() == prevNode ){
            return nextNode;
        }
        if(t.getPrevNode()==nextNode || t.getPrevNode()==ne){
            return prevNode;
        }*/

    }

}
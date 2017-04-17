package project;
import java.util.*;

//Zahorán László 2017.04.06
/**
 * A Car osztály, Vagon megvalósítása.
 */
public class Car extends Train {

    //******************************//
    //         Tagvaltozok          //
    //******************************//
    /**
     * A Train elemet, a szerevénybe megelöző Train elem.
     */
    private Train prevTrain;


    //******************************//
    //         Konstruktorok        //
    //******************************//

    /**
     * Default constructor
     */
    public Car(){
        super();
        prevTrain=null;
    }

    /**
     * Car osztály konstruktora.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onNode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     */
    public Car(int x, int y,int xEnd,int yEnd, Node onNode, Color color, Train nextCar) {
        super(x, y, xEnd, yEnd, onNode, color, nextCar);
    }
    /**
     * Car osztály konstruktora.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onNode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe
     */
    public Car(int x, int y,int xEnd,int yEnd, Node onNode, Color color) {
        super(x, y, xEnd, yEnd, onNode, color);
    }


    //******************************//
    //          Metodusok           //
    //******************************//
    /**
     * A vagonban utazó utasok leszállítása, azonos színű állomáson
     * üres vagon színe-->Gray
     */
    public void getOffPassengers() {
        if (!color.isEmpty())
            color=color.opposit();
    }
    /**
     *A vagonban utazó utasok felszállítása, azonos színű állomáson
     * üres vagon színe-->Gray
     */
    public void getOnPassengers() {
        if (color.isEmpty())
            color=color.opposit();
    }

    /**
     * A kocsi mozgatása
     * @return Status, A mozgatás során játék kimenetére ható események visszajelzése.
     */
    @Override
    public Status move(){
        prevNode=onNode;
        onNode=onNode.getNextNode(this);
        onNode.addTrain(this);
        //x=onNode.getX();
        //y=onNode.getY();
        //yEnd=onNode.getY();
        //xEnd=onNode.getX();
        prevNode.removeTrain(this);

        Status ret = null;
        if(nextCar != null)
            ret = nextCar.move();

        if(ret.equals(Status.NOT_EMPTY_CAR))
            return ret;
        else {
            if (!color.isEmpty()) return Status.NOT_EMPTY_CAR;
            if (color.isEmpty()) return Status.DELETE_TRAIN;
        }
        return null;
    }


    //******************************//
    //       Getterek/Setterek      //
    //******************************//
    /**
     * Getter metódus
     * @return A Train elemet, a szerevénybe megelöző Train elem lekérdezése.
     */
    public Train getPrevTrain() {
        return prevTrain;
    }
    /**
     * Setter metódus
     * @param t A Train elemet, a szerevénybe megelöző Train elem beállítása.
     */
    public void setPrevTrain(Train t) {
        prevTrain=t;
    }

}
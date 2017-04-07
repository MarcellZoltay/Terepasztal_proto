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
     * Car osztály konstruktora.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     */
    public Car(int x, int y,int xEnd,int yEnd, Node onnode, Color color, Train nextCar) {
        super(x, y, xEnd, yEnd,onnode, color, nextCar);
    }
    /**
     * Car osztály konstruktora.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     */
    public Car(int x, int y,int xEnd,int yEnd, Node onnode, Color color) {
        super(x, y, xEnd, yEnd,onnode, color);
    }

    //******************************//
    //          Metodusok           //
    //******************************//
    /**
     *A vagonban utazó utasok leszállítása, azonos színű állomáson
     * üres vagon színe-->Gray
     */
    public void getOffPassengers() {
        //color=new Color(color+"-Gray");
    }
    /**
     *
     *A vagonban utazó utasok felszállítása, azonos színű állomáson
     * üres vagon színe-->Gray
     */
    public void getOnPassengers() {
        //color=new Color("Ami voltm, szürke kiszedve");
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
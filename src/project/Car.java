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
     * Car/Vagon osztály konstruktora.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     */
    public Car(Node onnode, Color color, Train nextCar, int xEnd, int yEnd) {
        super(onnode, color, nextCar, xEnd, yEnd);
    }
    /**
     *Car/Vagon osztály konstruktora.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     */
    public Car(Node onnode, Color color, Train nextCar) {
        super(onnode, color, nextCar);
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
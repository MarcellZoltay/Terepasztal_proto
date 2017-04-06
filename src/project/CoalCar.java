package project;
import java.util.*;

//Zahorán László 2017.04.06
/**
 * A CoalCar osztály, Szenes vagon megvalósítása.
 */
public class CoalCar extends Train {
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
     * CoalCar osztály konstruktora.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     */
    public CoalCar(Node onnode, Color color, Train nextCar, int xEnd, int yEnd) {
        super(onnode, color, nextCar, xEnd, yEnd);
    }
    /**
     * CoalCar osztály konstruktora.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     */
    public CoalCar(Node onnode, Color color, Train nextCar) {
        super(onnode, color, nextCar);
    }


    //******************************//
    //          Metodusok           //
    //******************************//
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
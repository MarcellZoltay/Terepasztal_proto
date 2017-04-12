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
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     */
    public CoalCar(int x, int y,int xEnd, int yEnd, Node onnode, Color color, Train nextCar) {
        super(x, y, xEnd, yEnd,onnode, color, nextCar);
    }
    /**
     * CoalCar osztály konstruktora.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     */
    public CoalCar(int x, int y,int xEnd, int yEnd, Node onnode, Color color) {
        super(x, y, xEnd, yEnd,onnode, color);
    }
    /**
     * CoalCar osztály konstruktora.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     */
    public CoalCar(int x, int y,int xEnd, int yEnd, Node onnode, Train nextCar) {
        super(x, y, xEnd, yEnd,onnode, new Color(), nextCar);
    }
    /**
     * CoalCar osztály konstruktora.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     */
    public CoalCar(int x, int y,int xEnd, int yEnd, Node onnode) {
        super(x, y, xEnd, yEnd,onnode, new Color());
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
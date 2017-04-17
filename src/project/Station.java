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
     * Az állomás színe
     */
    private Color color;
    /**
     * Logikai érték, hogy leszállíthat-e a vonatról utasokat
     */
    private boolean canGetOff;

    /**
     * Az első nem üres kocsi, amiről le kell szállítani az utasokat
     */
    private Car firstEmptyCar;

    /**
     * Az azonos színű üres kocsi, amibe utasok szállnak fel
     */
    private Car getOnCar;


    //******************************//
    //         Konstruktorok        //
    //******************************//

    /**
     * Default constructor
     */
    public Station(){
        super(0, 0, null, null);
        this.color = null;
        this.canGetOff = false;
        this.firstEmptyCar = null;
    }

    /**
     * @param x Az állomás x koordinátája
     * @param y Az állomás y koordinátája
     * @param n A következő csomópont
     * @param p Az előző csomópont
     * @param c Az állomás színe
     */
    public Station(int x, int y, Node n, Node p, Color c) {
        super(x, y, n, p);
        this.color = c;
        this.canGetOff = false;
        this.firstEmptyCar = null;
    }


    //******************************//
    //          Metodusok           //
    //******************************//
    /**
     * Hozzáadja a paraméterül kapott változót a vonatrészeket tároló tömbhöz.
     * Az első azonos színű nem üres kocsiról leszállítja az utasokat.
     * Véletlenszerűen felszállít utasokat egy azonos színű üres kocsiba.
     * @param t A listához adandó vonatrész.
     */
    @Override
    public void addTrain(Train t) {
        trainsOn.add(t);

        if(t.getColor() == Color.ENGINE) {
            canGetOff = true;

            int numGetOn = 0;
            Train tmp = t.getNextCar();
            while (tmp.getNextCar() != null) {
                // Első nem üres, azonos színű kocsi megkeresése
                if (firstEmptyCar == null)
                    if (tmp.getColor().equals(color))
                        firstEmptyCar = (Car) tmp;

                // Azonos színű üres kocsik megszámolása
                if (tmp.getColor().equals(color.opposit())) numGetOn++;

                tmp = tmp.getNextCar();
            }


            if (numGetOn > 0) {
                Random r = new Random();
                int rand = r.nextInt(numGetOn);

                int i = 0;
                tmp = t.getNextCar();
                while (tmp.getNextCar() != null) {
                    // Ha azonos színű üres kocsi
                    if (tmp.getColor().equals(color.opposit())) {
                        if (i == rand) // Ha annyiadik azonos színű üres kocsi, mint a random szám
                            getOnCar = (Car) tmp;
                        else
                            i++;

                        tmp = tmp.getNextCar();
                    }
                }

            }

            // Leszállás
            if (canGetOff && t.equals(firstEmptyCar)) {
                ((Car) t).getOffPassengers();
                firstEmptyCar = null;
            }


            // Felszállás
            Random r = new Random();
            if (r.nextInt(10) < 2 && t.equals(getOnCar)) {
                ((Car) t).getOnPassengers();
                getOnCar = null;
            }

        }
    }


    //******************************//
    //       Getterek/Setterek      //
    //******************************//
    /**
     * Visszaadja az állomás színét
     * @return Az állomás színével
     */
    public Color getColor() {
        return color;
    }

    /**
     * Beállítja az állomás színét a paraméterül kapott értékkel
     * @param c A beállítandó szín
     */
    public void setColor(Color c){
        this.color = c;
    }

}
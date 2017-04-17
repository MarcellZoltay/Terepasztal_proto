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
    /**
     *
     */
    private boolean canGetOff;
    private Car firstEmptyCar;
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
     * @param x 
     * @param y 
     * @param n 
     * @param p 
     * @param c
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
     * @param t Traint kap és hozzaadja a listahoz
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
            if (canGetOff && t.equals(firstEmptyCar))
                ((Car) t).getOffPassengers();


            // Felszállás
            Random r = new Random();
            if (r.nextInt(10) < 2 && t.equals(getOnCar))
                ((Car) t).getOnPassengers();

        }
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
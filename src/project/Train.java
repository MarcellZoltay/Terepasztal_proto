package project;
import java.util.*;

//Zahorán László 2017.04.06
/**
 * Train Absztrakt osztály, egy vonat szerelvény elemeit fogja össze,
 * Mozdony, Szenesvagon, Személyi-vagon alapjául szolgál.
 */
public abstract class Train extends MapItem {
    //******************************//
    //         Tagvaltozok          //
    //******************************//
    /**
     * A Train vége, x koordináta.
     */
    protected int xEnd;
    /**
     * A Train vége y koordináta
     */
    protected int yEnd;
    /**
     * Az a csomópont amin, a Train jelenleg tartozkodik
     */
    protected Node onNode;
    /**
     *Az elöző csomópont, amit a Train elhagyott
     */
    protected Node prevNode;
    /**
     * A Train elemet követő Train elem, ha a szerelvény vége null.
     */
    protected Train nextCar;
    /**
     * A Train elem színe, Mozdony-Gray, CoalCar-
     */
    protected Color color;


    //******************************//
    //         Konstruktorok        //
    //******************************//
    /**
     * Train Absztract osztály konstruktor.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     */
    public Train(int x,int y,int xEnd, int yEnd, Node onnode, Color color){
        this.x=x;
        this.y=y;
        this.xEnd=xEnd;
        this.yEnd=yEnd;
        onNode=onnode;
        this.color=color;
    }
    /**
     * Train Absztract osztály konstruktor.
     *@param x Train x koordináta.
     *@param y Train y koordináta.
     *@param xEnd  A Train vége, x koordináta.
     *@param yEnd A Train vége, y koordináta.
     *@param onnode Az aktuális csomópont amin tartózkodik a Train.
     *@param color A Train elem színe, Mozdony/ures -Gray, Szenes vagon -###
     *@param nextCar A Train elemet követő Train elem a szerelvényben, utolsó elem esetén null.
     */
    public Train(int x,int y,int xEnd, int yEnd, Node onnode, Color color, Train nextCar){
        this(x,y,xEnd,yEnd,onnode,color);
        this.nextCar=nextCar;
    }


    //******************************//
    //          Metodusok           //
    //******************************//
    /**
     * A Train elem mozgatása.
     * @return Status, A mozgatás során játék kimenetére ható események visszajelzése.
     */
    public Status move() {
        // TODO implement here
        return null;
    }


    //******************************//
    //       Getterek/Setterek      //
    //******************************//
    /**
     * Getter metódus.
     * @return int A Train vége, x koordináta.
     */
    public int getEndX() {
        return xEnd;
    }
    /**
     * Getter metódus.
     * @return int A Train vége, y koordináta.
     */
    public int getEndY() {
        // TODO implement here
        return yEnd;
    }
    /**
     * Getter metódus.
     * @return Az aktuális Node lekérdezése amin , akihez tartozkodik/tartozik a Train.
     */
    public Node getOnNode() {
        // TODO implement here
        return onNode;
    }
    /**
     * Setter metódus.
     * @param n Az aktuális Node beállítása amin , akihez tartozkodik/tartozik a Train.
     */
    public void setOneNode(Node n) {
        prevNode=onNode;
        onNode=n;
    }
    /**
     * Getter metódus.
     * @return Node Az elöző Node lekérdezése amin , akihez tartozkodott/tartozott a Train.
     */
    public Node getPrevNode() {
        // TODO implement here
        return prevNode;
    }
    /**
     * Setter metódus.
     * @param p Az elöző Node beállítása amin , akihez tartozkodott/tartozott a Train.
     */
    public void setPrevNode(Node p) {
        prevNode=p;
        // TODO implement here
    }
    /**
     * Getter metódus.
     * @return A Train elemet követő Train elem lekérdezése a szerelvényben, utolsó elem esetén null.
     */
    public Train getNextCar() {
        return nextCar;
    }
    /**
     * Setter metódus.
     * @param train A Train elemet követő Train elem beállítása a szerelvényben, utolsó elem esetén null.
     */
    public void setNextCar(Train train) {
        nextCar=train;
    }
    /**
     * Getter metódus.
     * @return Color A Train elem színének lekérdezése
     */
    public Color getColor() {
        return color;
    }
}
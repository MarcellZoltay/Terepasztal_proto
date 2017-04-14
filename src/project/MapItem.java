package project;

/**
 * absztrakt osztaly a palyaelemekre
 */
public abstract class MapItem {

    /**
     * Default constructor
     */
    public MapItem() {
        this.x = 0;
        this.y=0;
    }

    /**
     * x koordinata
     */
    protected int x;

    /**
     * y koordinata
     */
    protected int y;

    /**
     * @return visszater az x koordinataval
     */
    public int getX() {
        // TODO implement here
        return x;
    }

    /**
     * @return isszater az y koordinataval
     */
    public int getY() {
        // TODO implement here
        return y;
    }

    /**
     * beallitja az x koordinatat arra a parameterre amit a fuggveny kap
     * @param x a beallitando x koordinata
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * beallitja az y koordinatat arra a parameterre amit a fuggveny kap
     * @param y a beallitando y koordinata
     */
    public void setY(int y){
        this.y = y;
    }

}
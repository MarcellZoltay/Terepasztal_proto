package project;

import java.util.*;

/**
 * osztaly ami megvalositja az alagutbejaratot,
 */
public class TunnelEntrance extends Switch {

    /**
     * Default constructor
     */
    public TunnelEntrance(){
        super(0,0,null,null,null);
    }

    /**
     * @param x koordinata
     * @param y koordinata
     * @param n egyik kovetkezo csomopont
     * @param n2 masik kovetkezo csomopont
     * @param p elozo csomopont
     */
    public TunnelEntrance(int x, int y, Node n, Node n2, Node p) {
        // TODO implement here
        super(x, y, n, n2, p);
    }

    /*@Override // ez nem feltétlen kell mert a két output állítás ugyanúgy működik
    public void changeOutput(){

    }*/

}
package project;

/**
 * 
 */
public class Model {

    /**
     * Default constructor
     */
    public Model() {
    }

    /**
     * 
     */
    private View view;

    /**
     * 
     */
    private Engine[] engines;

    /**
     * 
     */
    private Car[] cars;

    /**
     * 
     */
    private CoalCar[] coalCars;

    /**
     * 
     */
    private Station[] stations;

    /**
     * 
     */
    private Rail[] rails;

    /**
     * 
     */
    private Cross[] crosses;

    /**
     * 
     */
    private Switch[] switches;

    /**
     * 
     */
    private TunnelEntrance[] tunnelEntrances;










    /**
     * 
     */
    public void Model() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Status moveEngines() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void addTrainToMap() {
        // TODO implement here
    }

    /**
     * @param x1 
     * @param y1 
     * @param x2 
     * @param y2
     */
    public void decideActions(int x1, int y1, int x2, int y2) {
        // TODO implement here
    }

    /**
     * @param x1 
     * @param y1 
     * @param x2 
     * @param y2
     */
    private void addTunnelEntrance(int x1, int y1, int x2, int y2) {
        // TODO implement here
    }

    /**
     * @param tE
     */
    private void removeTunnelEntrance(TunnelEntrance tE) {
        // TODO implement here
    }

    /**
     * @param s
     */
    private void changeSwitch(Switch s) {
        // TODO implement here
    }

    /**
     * @param trainPart
     */
    private void removeTrain(Train trainPart) {
        // TODO implement here
    }

    /**
     * @return
     */
    private boolean isMapEmpty() {
        // TODO implement here
        return false;
    }

}
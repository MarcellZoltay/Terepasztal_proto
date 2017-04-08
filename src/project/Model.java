package project;

import java.util.Map;

/** Attributes are stored as a map hash, in order to be able to reference them by the user
 *  The final product wont have it like that, its just the purpose of the prototype
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
    private Map<String, Engine> engines;

    /**
     * 
     */
    private Map<String, Car> cars;

    /**
     * 
     */
    private Map<String, CoalCar> coalCars;

    /**
     * 
     */
    private Map<String, Station> stations;

    /**
     * 
     */
    private Map<String, Rail> rails;

    /**
     * 
     */
    private Map<String, Cross> crosses;

    /**
     * 
     */
    private Map<String, Switch> switches;

    /**
     * 
     */
    private Map<String, TunnelEntrance> tunnelEntrances;

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

    private String checkParam(String params[], String keyShort, String keyLong) {
        for (String param : params) {
            if (param.length() == keyShort.length() && param.contains(keyShort)) return null;
            if (param.length() == keyLong.length() && param.contains(keyLong))  return null;
            if (param.contains(keyShort + " "))
                return param.substring(keyShort.length() + 2);
            if (param.contains(keyLong + " "))
                return param.substring(keyLong.length() + 2);
        }
        return "";
    }
    
    private Node getNode(String name) {
        Node toReturn;
        toReturn = rails.get(name);
        if (toReturn != null) return toReturn;
        toReturn = stations.get(name);
        if (toReturn != null) return toReturn;
        toReturn = switches.get(name);
        if (toReturn != null) return toReturn;
        toReturn = crosses.get(name);
        if (toReturn != null) return toReturn;
        toReturn = tunnelEntrances.get(name);
        if (toReturn != null) return toReturn;
        return null;
    }
    
    private boolean setNext(String name, Node toSet) {
        Node n = getNode(name);
        if (crosses.get(name) != null) {
            if (n.getNext() == null) n.setNext(toSet);
            else if (((Cross)n).getNext2() == null) ((Cross)n).setNext2(toSet);
            else if (n.getNext() != toSet && ((Cross)n).getNext2() != toSet) return false;
        }
        else {
            if (n.getNext() == null) n.setNext(toSet);
            else if (n.getNext() != toSet) return false;
        }
        return true;
    }
   
    private boolean setPrev(String name, Node toSet) {
        Node n = getNode(name);
        if (crosses.get(name) != null) {
            if (n.getPrev() == null) n.setPrev(toSet);
            else if (((Cross)n).getPrev2() == null) ((Cross)n).setPrev2(toSet);
            else if (n.getPrev() != toSet && ((Cross)n).getPrev2() != toSet) return false;
        }
        else {
            if (n.getPrev() == null) n.setPrev(toSet);
            else if (n.getPrev() != toSet) return false;
        }
        return true;
    }
    
    private Train getTrain(String name) {
        Train toReturn;
        toReturn = engines.get(name);
        if (toReturn != null) return toReturn;
        toReturn = coalCars.get(name);
        if (toReturn != null) return toReturn;
        toReturn = cars.get(name);
        if (toReturn != null) return toReturn;
        return null;
    }
        
    private boolean setNextTrain(String name, Train toSet) {
        Train t = getTrain(name);
            if (t.getNextCar() == null) t.setNextCar(toSet);
            else if (t.getNextCar() != toSet) return false;
        return true;
    }
   
    private boolean setPrevTrain(String name, Train toSet) {
        Train t = getTrain(name);
            if (((Car)t).getPrevTrain() == null) ((Car)t).setPrevTrain(toSet);
            else if (((Car)t).getPrevTrain() != toSet) return false;
        return true;
    }
    public String decideActions(String code) {
        String parameters[] = code.split(" -");
        String type = "", name = "", remove = "", coords = "", setnext = "", setprev = "", seton = "", setcolor = "", change = "", all = "", steps = "";
        if (parameters.length > 1 ) {
            type = checkParam(parameters, "t", "-type");
            name = checkParam(parameters, "c", "-create");
            remove = checkParam(parameters, "r", "-remove");
            coords = checkParam(parameters, "C", "-coords");
            setnext = checkParam(parameters, "sN", "-setnext");
            setprev = checkParam(parameters, "sP", "-setprev");
            seton = checkParam(parameters, "sO", "-seton");
            setcolor = checkParam(parameters, "sC", "-setcolor");
            change = checkParam(parameters, "o", "-change");
            all = checkParam(parameters, "a", "-all");
            steps = checkParam(parameters, "s", "-steps");
        }
        
        switch(parameters[0]) {
            case "node":
                if (name.isEmpty() || name == null) return "> missing node name";
                if (type.isEmpty() || type == null) return "> missing node type";
                if (!name.isEmpty() && !remove.isEmpty()) return "> can't create and remove an object at the same time";
                if (!name.isEmpty()) {
                    Node node = getNode(name);
                    if (node == null) {
                        switch(type) {
                            case "Rail": 
                                node = new Rail();
                                rails.put(name, (Rail)node);
                                break;
                            case "Station": 
                                node = new Station();
                                if (!setcolor.isEmpty()) ((Station)node).setColor(setcolor);
                                else return "> stations must have color";
                                stations.put(name, (Station)node);
                                break;
                            case "Switch": 
                                node = new Switch();
                                if (change == null) ((Switch)node).changeOutput();
                                switches.put(name, (Switch)node);
                                break;
                            case "Cross": 
                                node = new Cross();
                                crosses.put(name, (Cross)node);
                                break;
                            case "TunnelEntrance": 
                                node = new TunnelEntrance();
                                tunnelEntrances.put(name, (TunnelEntrance)node);
                                break;
                            default: return "> not valid node type";
                        }
                    }
                    if (!coords.isEmpty()) {
                        String coord[] = coords.split(" ");
                        if (coord.length != 2) return "> a node has two coordinates";
                        node.setX(Integer.parseInt(coord[0]));
                        node.setY(Integer.parseInt(coord[1]));
                    }
                    else return "> nodes must have two coordinates";
                    if (!setnext.isEmpty()) {
                        Node next = getNode(setnext);
                        if (next == null) return "> there is no node with the name " + setnext + " to set next";
                        if (!setNext(setnext, node)) return "> next node cannot be set";
                        node.setNext(next);
                    }
                    if (!setprev.isEmpty()) {
                        Node prev = getNode(setprev);
                        if (prev == null) return "> there is no node with the name " + setprev + " to set previous";
                        if (!setPrev(setprev, node)) return "> previous node cannot be set";
                        node.setPrev(prev);
                    }
                }
                if (!remove.isEmpty()) {
                    if (tunnelEntrances.get(remove) == null) return "> there is no tunnel entrance with the name " + remove + " to remove";
                    tunnelEntrances.remove(remove);
                }
                break;
            case "train":
                if (name.isEmpty() || name == null) return "> missing train name";
                if (type.isEmpty() || type == null) return "> missing train type";
                Train train = getTrain(name);
                if (train == null) {
                    switch(type) {
                        case "Engine":
                            train = new Engine();
                            engines.put(name, (Engine)train);
                            break;
                        case "Car":
                            train = new Car();
                            cars.put(name, (Car)train);
                            break;
                        case "CoalCar":
                            train = new CoalCar();
                            coalCars.put(name, (CoalCar)train);
                            break;
                        default: return "> not valid train type";
                    }
                }
                if (!coords.isEmpty()) {
                    String coord[] = coords.split(" ");
                    if (coord.length != 4) return "> a train has four coordinates";
                    train.setX(Integer.parseInt(coord[0]));
                    train.setY(Integer.parseInt(coord[1]));
                    train.setEndX(Integer.parseInt(coord[2]));
                    train.setEndY(Integer.parseInt(coord[3]));
                }
                else return "> trains must have four coordinates";
                if (!setnext.isEmpty()) {
                    Train next = getTrain(setnext);
                    if (next == null) return "> there is no train with the name " + setnext + " to set next";
                    if (!setNextTrain(setnext, train)) return "> next train cannot be set";
                    train.setNextCar(next);
                }
                if (!setprev.isEmpty()) {
                    Train prev = getTrain(setprev);
                    if (prev == null) return "> there is no train with the name " + setprev + " to set previous";
                    if (!setPrevTrain(setprev, train)) return "> previous train cannot be set";
                    ((Car)train).setPrevTrain(prev);
                }
                if (!seton.isEmpty()) {
                    Node on = getNode(seton);
                    if (on == null) return "> there is no node with the name " + seton + " to set as train's on node";
                    train.setOneNode(on);
                }
                break;
            case "move":
                break;
            case "ls":
                break;
            default: return "> no command like that";
        }
        return null;
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
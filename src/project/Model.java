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

    /**
     * Finds a specific option and its parameter in the command 
     * @param params the command seperated by '-'
     * @param keyShort the option's short name
     * @param keyLong the option's long name
     * @return returns the parameter(s)
     */
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
    
    /**
     * Checks if there exists a node with a specific name
     * @param name the node's name to find
     * @return if found returns the node, else returns null
     */
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
    
    /**
     * Called when a node was referred by another one, to set up the connection between them
     * To link them together from both sides
     * @param name the node's name to find
     * @param toSet the node to set up the connection with
     * @return returns true if it could set up the connection, false otherwise
     */
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
   
    /**
     * Basically the same as the setNext one, except its from the other way around
     */
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
    
    /**
     * The same as the getNode one, except its for Trains
     */
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
      
    /**
     * The same as the setNext one, except its for Trains
     */
    private boolean setNextTrain(String name, Train toSet) {
        Train t = getTrain(name);
            if (t.getNextCar() == null) t.setNextCar(toSet);
            else if (t.getNextCar() != toSet) return false;
        return true;
    }
   
    /**
     * The same as the setPrev one, except its for Trains
     */
    private boolean setPrevTrain(String name, Train toSet) {
        Train t = getTrain(name);
            if (((Car)t).getPrevTrain() == null) ((Car)t).setPrevTrain(toSet);
            else if (((Car)t).getPrevTrain() != toSet) return false;
        return true;
    }
    
    /**
     * Gets one command at a time, acts accordingly
     * @param code the command itself
     * @return returns the outcome it caused. 
     * If the command was to move the trains, and the trains crashed, then it returns that the game should be over.
     */
    public Status decideActions(String code) {
        String parameters[] = code.split(" -");
        String type = "", name = "", remove = "", coords = "", setnext = "", setprev = "", seton = "", setcolor = "", change = "", all = "", steps = "";
        if (parameters.length > 1 ) {                               // Checks for all the parameters every command could have, if it has any
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
        
        switch(parameters[0]) {                                     // Decides which command was called
            case "node":
                if (name.isEmpty() || name == null) { System.out.println("> missing node name"); return null; }     // Command cannot function without a node name
                if (type.isEmpty() || type == null) { System.out.println("> missing node type"); return null; }     // Command cannot function without a node type
                if (!name.isEmpty() && !remove.isEmpty()) { System.out.println("> can't create and remove an object at the same time"); return null; } // Cannot create and remove objects at the same time
                if (!name.isEmpty()) {                  // If the command sais to create or modify
                    Node node = getNode(name);          // Checks if the node was created earlier
                    if (node == null) {                 // If not creates it accordingly, and puts it an appropriate map
                        switch(type) {
                            case "Rail": 
                                node = new Rail();
                                rails.put(name, (Rail)node);
                                break;
                            case "Station": 
                                node = new Station();
                                if (!setcolor.isEmpty()) ((Station)node).setColor(setcolor);            // Stations must have colors
                                else { System.out.println("> stations must have color"); return null; }
                                stations.put(name, (Station)node);
                                break;
                            case "Switch": 
                                node = new Switch();
                                if (change == null) ((Switch)node).changeOutput();          // Only Switches' and TunnelEntrances' output can be changed
                                switches.put(name, (Switch)node);
                                break;
                            case "Cross": 
                                node = new Cross();
                                crosses.put(name, (Cross)node);
                                break;
                            case "TunnelEntrance": 
                                node = new TunnelEntrance();
                                if (change == null) ((TunnelEntrance)node).changeOutput();  // Only Switches' and TunnelEntrances' output can be changed
                                tunnelEntrances.put(name, (TunnelEntrance)node);
                                break;
                            default: System.out.println("> not valid node type"); return null; // Command must have a valid type
                        }
                    }
                    if (!coords.isEmpty()) {                    // Checks if user wants to change node's coordinates
                        String coord[] = coords.split(" ");
                        if (coord.length != 2) { System.out.println("> a node has two coordinates"); return null; }
                        node.setX(Integer.parseInt(coord[0]));
                        node.setY(Integer.parseInt(coord[1]));
                    }
                    else { System.out.println("> nodes must have two coordinates"); return null; }
                    if (!setnext.isEmpty()) {                   // Checks if user wants to change node's nextNode. If yes, sets up the connection from the other way too
                        Node next = getNode(setnext);
                        if (next == null) { System.out.println("> there is no node with the name " + setnext + " to set next"); return null; }
                        if (!setPrev(setnext, node)) { System.out.println("> next node cannot be set"); return null; }
                        node.setNext(next);
                    }
                    if (!setprev.isEmpty()) {                   // Checks if user wants to change node's prevNode. If yes, sets up the connection from the other way too
                        Node prev = getNode(setprev);
                        if (prev == null) { System.out.println("> there is no node with the name " + setprev + " to set previous"); return null; }
                        if (!setNext(setprev, node)) { System.out.println("> previous node cannot be set"); return null; }
                        node.setPrev(prev);
                    }
                }
                if (!remove.isEmpty()) {                        //Checks if user wants to remove a TunnelEntrance
                    if (tunnelEntrances.get(remove) == null) { System.out.println("> there is no tunnel entrance with the name " + remove + " to remove"); return null; }
                    tunnelEntrances.remove(remove);
                }
                break;
            case "train":
                if (name.isEmpty() || name == null) { System.out.println("> missing train name"); return null; }    // Command cannot function without a train name
                if (type.isEmpty() || type == null) { System.out.println("> missing train type"); return null; }    // Command cannot function without a train type
                Train train = getTrain(name);           // Cheks if the train was created earlier
                if (train == null) {                    // If not creates it accordingly, and puts it an appropriate map
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
                        default: System.out.println("> not valid train type"); return null;     // Command must have a valid type
                    }
                }
                if (!coords.isEmpty()) {                    // Checks if user wants to change train's coordinates
                    String coord[] = coords.split(" ");
                    if (coord.length != 4) { System.out.println("> a train has four coordinates"); return null; }
                    train.setX(Integer.parseInt(coord[0]));
                    train.setY(Integer.parseInt(coord[1]));
                    train.setEndX(Integer.parseInt(coord[2]));
                    train.setEndY(Integer.parseInt(coord[3]));
                }
                else { System.out.println("> trains must have four coordinates"); return null; }
                if (!setnext.isEmpty()) {                   // Checks if user wants to change train's next Train. If yes then sets up the connection from the other way too
                    Train next = getTrain(setnext);
                    if (next == null) { System.out.println("> there is no train with the name " + setnext + " to set next"); return null; }
                    if (!setNextTrain(setnext, train)) { System.out.println("> next train cannot be set"); return null; }
                    train.setNextCar(next);
                }
                if (!setprev.isEmpty()) {                   // Checks if user wants to change thain's prev Train. If yes then sets up the connection from the other way too
                    Train prev = getTrain(setprev);
                    if (prev == null) { System.out.println("> there is no train with the name " + setprev + " to set previous"); return null; }
                    if (!setPrevTrain(setprev, train)) { System.out.println("> previous train cannot be set"); return null; }
                    ((Car)train).setPrevTrain(prev);
                }
                if (!seton.isEmpty()) {                     // Checks if user wants to change the Node the Train is on
                    Node on = getNode(seton);
                    if (on == null) { System.out.println("> there is no node with the name " + seton + " to set as train's on node"); return null; }
                    train.setOneNode(on);
                }
                break;
            case "move":
                if (steps.isEmpty()) { System.out.println("> missing steps parameter"); return null; }      // Checks if command has steps option, but without parameter
                if (steps == null) moveEngines();                                                           // If there are no options, then it calls the train mover function once
                else                                                                                        // Calls it the number of times the parameter had
                    for (int i = 0; i < Integer.parseInt(steps); i++) {
                        Status s = moveEngines();
                        if (s == Status.CRASHED) return s;                                                  // Checks if the trains had crashed on the map
                    }
                        
                break;
            case "ls":
                break;
            default: System.out.println("> no command like that"); return null;
        }
        return Status.CONTINUE;
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
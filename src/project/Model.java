package project;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/** Attributes are stored as a map hash, in order to be able to reference them by the user
 *  The final product wont have it like that, its just the purpose of the prototype
 */
public class Model {

    //******************************//
    //         Tagvaltozok          //
    //******************************//
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


    //******************************//
    //         Konstruktorok        //
    //******************************//
    /**
     * Konstruktor
     * Inicializálja a tagváltozókat
     */
    public Model() {
        view = new View();
        engines = new TreeMap<>();
        cars = new TreeMap<>();
        coalCars = new TreeMap<>();
        stations = new TreeMap<>();
        rails = new TreeMap<>();
        crosses = new TreeMap<>();
        switches = new TreeMap<>();
        tunnelEntrances = new TreeMap<>();
    }


    //******************************//
    //          Metodusok           //
    //******************************//
    /**
     * Meghívja a mozdonyok move() metódusát.
     * Visszatér az aktuális mozdony állapotával.
     * @return ret Az aktuális mozdony állapota.
     */
    public Status moveEngines() {

        if(isMapEmpty())
            return Status.GAME_WON;

        for (Map.Entry<String, Engine> engine : engines.entrySet()) {
            if(engine.getValue().move()==Status.CRASHED)
                return Status.CRASHED;
        }

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
     * Finds the key, the Train was set to
     * @param train the value which leads to a unique key
     * @return returns the key, if there is one, else returns null
     */
    public String getName(Train train) {
        Set<String> set;
        set = engines.keySet();
        for (String s : set)
            if (engines.get(s) == (Engine)train) return s;
        set = coalCars.keySet();
        for (String s : set)
            if (coalCars.get(s) == (CoalCar)train) return s;
        set = cars.keySet();
        for (String s : set)
            if (cars.get(s) == (Car)train) return s;        
        return null;
    }
    
    /**
     * Finds the key, the Node was set to
     * @param node the value which leads to a unique key
     * @return returns the key, if there is one, else returns null
     */
    public String getNodeName(Node node) {
        Set<String> set;
        set = rails.keySet();
        for (String s : set)
            if (rails.get(s) == (Rail)node) return s;
        set = stations.keySet();
        for (String s : set)
            if (stations.get(s) == (Station)node) return s;
        set = rails.keySet();
        for (String s : set)
            if (switches.get(s) == (Switch)node) return s;
        set = switches.keySet();
        for (String s : set)
            if (rails.get(s) == (Cross)node) return s;
        set = tunnelEntrances.keySet();
        for (String s : set)
            if (tunnelEntrances.get(s) == (TunnelEntrance)node) return s;
        return null;
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
                if (name == null || name.isEmpty()) { System.out.println("> missing node name"); return null; }     // Command cannot function without a node name
                if (type == null || type.isEmpty()) { System.out.println("> missing node type"); return null; }     // Command cannot function without a node type
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
                                if (change == null) changeSwitch((Switch)node);          // Only Switches' output can be changed
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
                        String nexts[] = setnext.split(" ");
                        Node next[] = null;
                        if (nexts.length < 1 || nexts.length > 2){ System.out.println("> not the correct number of parameters"); return null; }
                        for (int i = 0; i < nexts.length; i++) {
                            next[i] = getNode(nexts[i]);
                            if (next[i] == null) { System.out.println("> there is no node with the name " + nexts[i] + " to set previous"); return null; }
                            if (!setNext(nexts[i], node)) { System.out.println("> next node cannot be set for " + nexts[i]); return null; }
                            if (!setPrev(name, next[i])) { System.out.println("> previous node cannot be set for " + name); return null; }
                        }
                    }
                    if (!setprev.isEmpty()) {                   // Checks if user wants to change node's prevNode. If yes, sets up the connection from the other way too
                        String prevs[] = setprev.split(" ");
                        Node prev[] = null;
                        if (prevs.length < 1 || prevs.length > 2){ System.out.println("> not the correct number of parameters"); return null; }
                        for (int i = 0; i < prevs.length; i++) {
                            prev[i] = getNode(prevs[i]);
                            if (prev[i] == null) { System.out.println("> there is no train with the name " + prevs[i] + " to set previous"); return null; }
                            if (!setPrev(prevs[i], node)) { System.out.println("> previous node cannot be set for " + prevs[i]); return null; }
                            if (!setNext(name, prev[i])) { System.out.println("> next node cannot be set for " + name); return null; }
                        }
                    }
                }
                if (!remove.isEmpty()) {                        //Checks if user wants to remove a TunnelEntrance
                    if (tunnelEntrances.get(remove) == null) { System.out.println("> there is no tunnel entrance with the name " + remove + " to remove"); return null; }
                    tunnelEntrances.remove(remove);
                }
                break;
            case "train":
                if (name == null || name.isEmpty()) { System.out.println("> missing train name"); return null; }    // Command cannot function without a train name
                if (type == null || type.isEmpty()) { System.out.println("> missing train type"); return null; }    // Command cannot function without a train type
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
                    String nexts[] = setnext.split(" ");
                    Train next[] = null;
                    if (nexts.length < 1 || nexts.length > 2){ System.out.println("> not the correct number of parameters"); return null; }
                    for (int i = 0; i < nexts.length; i++) {
                        next[i] = getTrain(nexts[i]);
                        if (next[i] == null) { System.out.println("> there is no train with the name " + nexts[i] + " to set previous"); return null; }
                        if (!setNextTrain(nexts[i], train)) { System.out.println("> next train cannot be set for " + nexts[i]); return null; }
                        if (!setPrevTrain(name, next[i])) { System.out.println("> previous train cannot be set for " + name); return null; }
                    }
                }
                if (!setprev.isEmpty()) {                   // Checks if user wants to change thain's prev Train. If yes then sets up the connection from the other way too
                    String prevs[] = setprev.split(" ");
                    Train prev[] = null;
                    if (prevs.length < 1 || prevs.length > 2){ System.out.println("> not the correct number of parameters"); return null; }
                    for (int i = 0; i < prevs.length; i++) {
                        prev[i] = getTrain(prevs[i]);
                        if (prev[i] == null) { System.out.println("> there is no train with the name " + prevs[i] + " to set previous"); return null; }
                        if (!setPrevTrain(prevs[i], train)) { System.out.println("> previous train cannot be set for " + prevs[i]); return null; }
                        if (!setNextTrain(name, prev[i])) { System.out.println("> next train cannot be set for " + name); return null; }
                    }
                }
                if (!seton.isEmpty()) {                     // Checks if user wants to change the Node the Train is on
                    Node on = getNode(seton);
                    if (on == null) { System.out.println("> there is no node with the name " + seton + " to set as train's on node"); return null; }
                    train.setOneNode(on);
                }
                break;
            case "move":
                if (steps == null) { System.out.println("> missing steps parameter"); return null; }      // Checks if command has steps option, but without parameter
                if (steps.isEmpty()) moveEngines();                                                           // If there are no options, then it calls the train mover function once
                else                                                                                        // Calls it the number of times the parameter had
                    for (int i = 0; i < Integer.parseInt(steps); i++) {
                        Status s = moveEngines();
                        if (s == Status.CRASHED) return s;                                                  // Checks if the trains had crashed on the map
                    }      
                break;
            case "ls":
                if (type == null) { System.out.println("> missing type parameter"); return null; }
                if (all == null || type.contains("Rail")) {
                    rails.forEach((nodeName, node) -> {
                    System.out.println(nodeName);
                    System.out.println("nextNode: " + getNodeName(node.getNext()));
                    System.out.println("prevNode: " + getNodeName(node.getPrev()));
                    System.out.print("trains:");
                    for (Train t : node.getTrains()) {
                        System.out.print(" " + getName(t));
                    }
                    });
                }
                if (all == null || type.contains("Switch")) {
                    switches.forEach((nodeName, node) -> {
                    System.out.println(nodeName);
                    System.out.println("nextNode: " + getNodeName(node.getNext()));
                    System.out.println("next2Node: " + getNodeName(node.getSecond()));
                    System.out.println("prevNode: " + getNodeName(node.getPrev()));
                    System.out.print("trains:");
                    for (Train t : node.getTrains()) {
                        System.out.print(" " + getName(t));
                    }
                    });
                }
                if (all == null || type.contains("Station")) {
                    stations.forEach((nodeName, node) -> {
                    System.out.println(nodeName);
                    System.out.println("nextNode: " + getNodeName(node.getNext()));
                    System.out.println("prevNode: " + getNodeName(node.getPrev()));
                    System.out.println("color: " + node.getColor().toString());
                    System.out.print("trains:");
                    for (Train t : node.getTrains()) {
                        System.out.print(" " + getName(t));
                    }
                    });
                }
                if (all == null || type.contains("Cross")) {
                    crosses.forEach((nodeName, node) -> {
                    System.out.println(nodeName);
                    System.out.println("nextNode: " + getNodeName(node.getNext()));
                    System.out.println("next2Node: " + getNodeName(node.getNext2()));
                    System.out.println("prevNode: " + getNodeName(node.getPrev()));
                    System.out.println("prev2Node: " + getNodeName(node.getPrev2()));
                    System.out.print("trains:");
                    for (Train t : node.getTrains()) {
                        System.out.print(" " + getName(t));
                    }
                    });
                }
                if (all == null || type.contains("TunnelEntrance")) {
                    tunnelEntrances.forEach((nodeName, node) -> {
                    System.out.println(nodeName);
                    System.out.println("nextNode: " + getNodeName(node.getNext()));
                    System.out.println("prevNode: " + getNodeName(node.getPrev()));
                    System.out.print("trains:");
                    for (Train t : node.getTrains()) {
                        System.out.print(" " + getName(t));
                    }
                    });
                }
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
        //TunnelEntrance tE = new TunnelEntrance();
    }

    /**
     * @param tE
     */
    private void removeTunnelEntrance(TunnelEntrance tE) {
        // TODO implement here
        //tunnelEntrances.remove(tE);
    }

    /**
     * Átállítja a paraméterül kapott váltó kimenetét.
     * @param s Az átállítandó váltó.
     */
    private void changeSwitch(Switch s) {
        s.changeOutput();
    }

    /**
     * @param trainPart
     */
    private void removeTrain(Train trainPart) {
        // TODO implement here
    }

    /**
     * Eldönti, hogy van-e még vonat a pályán.
     * Visszatér a megfelelő logikai értékkel.
     * @return true - Ha üres a pálya.
     * @return false - Ha nem üres a pálya.
     */
    private boolean isMapEmpty() {
        if(engines.size()==0)
            return true;
        return false;
    }

}
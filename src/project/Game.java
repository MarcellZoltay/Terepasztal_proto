package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 */
public class Game implements State {

    public Game() {
        map = new Model();
        numberOfTrains = 0;
        waitingTime = 1;
    }
    
    private Model map;
    private int numberOfTrains;
    private double waitingTime;

    private Status read() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.nextLine();
            if (command.contentEquals("pause")) return Status.PAUSE;
            if (command.contains("load ")) {
                if (!command.contains(" -l ")) System.out.println("> load command does not contain parameters");
                else {
                    String load[];
                    load = command.split(" ", 2);
                    load = load[1].split("-l ");
                    try { 
                        File f = new File("maps\\" + load[1]);
                        Scanner loadFile = new Scanner(f);
                        while (loadFile.hasNextLine()) {
                            System.out.println(map.decideActions(loadFile.nextLine()));
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("> file does not exist");
                    }
                }
            }
            else {
                System.out.println(map.decideActions(command));
            }
        } 
    }

    /* Azért van itt külön függvény, mert a végleges programban, a start fog új vonatokat hozzáadni a Modellhez
     * Itt ez is parancssorból történik
     */
    @Override
    public Status start() {
        return read();
    }

}
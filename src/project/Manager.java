package project;

import java.util.*;

public class Manager {

    private Stack<State> states;
    
    public Manager() {
        states = new Stack<>();
        Menu menu = new Menu();
        states.add(menu);
    }

    public void run() {
        switch(states.peek().start()) {
            case START_GAME: 
                states.push(new Game());
                break;
            case EXIT_GAME:
            case CRASHED:
                states.push(new End());
                break;
            case CONTINUE:
                states.pop();
                break;
            case PAUSE:
                states.push(new Pause());
                break;         
        }
    }
    
    private void addState(State s) {
        
    }

    private void removeState(State s) {
        
    }

}
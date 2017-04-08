package project;

import java.util.*;

public class End implements State {

    private Status output;

    public End(Status e) {
        this.output = e;
    }

    @Override
    public Status start() {
        if (output == Status.GAME_WON) System.out.println("> Congrats! You won");
        if (output == Status.CRASHED) System.out.println("> Trains crashed! You lost");
        return Status.EXIT_GAME;
    }

}
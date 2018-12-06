package com.example.desuev.sberlesson4_2;

public class StateManager {

    private static StateManager instance;
    private int state;

    static {
        instance = new StateManager();
    }

    private StateManager () {
        state = 0;
    }

    public static StateManager getInstance() {
        return instance;
    }

    public void changeState(){
        state = (state + 1) % 5;
    }

    public int getState(){
        return state;
    }
    
}

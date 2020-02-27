package fr.rphstudio.chess.game;


import java.util.Timer;
import java.util.TimerTask;

public class TimerSet {
    Timer timer = new Timer();
    long test = 0;
    public long setTimer(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                test = test+16;
            }
        }, 0);
        return test;
    }
}

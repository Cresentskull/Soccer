package com.example.rustie.futbol;

/**
 * Created by Shubham on 3/30/2016.
 */
public class setHighScore {
    private String player;
    private String score;

    public String getPlayer() {
        return player;
    }

    public String getScore() {
        return score;
    }

    public setHighScore(){

    }

    public setHighScore(String player, String score){
        this.player = player;
        this.score = score;
    }
}

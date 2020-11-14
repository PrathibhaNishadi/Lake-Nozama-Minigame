/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import inhabitant.*;


public class MountDoom extends Thread {

    private static boolean isWon = false;           // To identify any warrior is won
    ArrayList<InhabitantChracter> warriors;

    public MountDoom(ArrayList<InhabitantChracter> observers) {
        this.warriors = observers;
    }

    public synchronized void notifyWarriors() {
        for (int i = 0; i < mygame.MyGame.warriorsInTheGame; i++) {
            Warrior w = (Warrior) warriors.get(i);
            w.update();
        }
    }

    /**
     * @return the isWon
     */
    public static synchronized boolean isIsWon() {
        return isWon;

    }

    /**
     * @param aIsWon the isWon to set
     */
    public static synchronized void setIsWon(boolean aIsWon) {
        isWon = aIsWon;
    }

}

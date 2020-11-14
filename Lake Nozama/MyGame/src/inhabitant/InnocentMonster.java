/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inhabitant;

import java.util.ArrayList;
import objects.*;
import tools.Node;
import tools.WalkingStick;


public class InnocentMonster extends InhabitantChracter {

    ArrayList<WalkingStick> walkingSticks;                  // For hold stealed walking sticks
    LandOfMordor land;

    public InnocentMonster(String name, int age, LandOfMordor land) {
        setCharacterName(name);
        setAge(age);
        walkingSticks = new ArrayList<>();
        this.land = land;
    }

    public synchronized void steal(Warrior w) {                      // Steal the waling stick of given warrior                                        
        if (w.node.getX() == this.node.getX() && w.node.getY() == this.node.getY()) {
            walkingSticks.add(w.loseStick());               // Call lose stick method on the warrior
            System.out.println(w.getCharacterName() + "'s walking stick was stolen by " + getCharacterName() + " !");
            mygame.MyGame.warriorsInTheGame--;     // after the steal walking stick number of warriors with mobility decrease by 1
        }
    }

    public void addCoordinates(int x, int y) {
        node = new Node(this, x, y);
    }

    public void walk(LandOfMordor land, int side) {
        // add code for walk
    }

    public void update(Warrior w) {
        if (this.node.getX() == w.node.getX() && this.node.getY() == w.node.getY()) {
            steal(w);
        }
    }

}

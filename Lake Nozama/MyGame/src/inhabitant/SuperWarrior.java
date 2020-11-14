
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inhabitant;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.Binocular;
import objects.*;


public class SuperWarrior extends Warrior {

    Binocular binocular;

    public SuperWarrior(String name, int age, LandOfMordor land, ArrayList<InhabitantChracter> monster_observers) {                                 // Construct the super warrior object
        super(name, age, land, monster_observers);
        binocular = new Binocular();

    }

    public void superWalk(LandOfMordor land) {                                  // Super warriors walk method using normal warriors walk method
        int side = 4;
        if(!this.isImmortal()){
            binocular.search(land, node.getX(), node.getY());      // Before walk search nearest line crossing for Trees
        }
        if (side < 4 && side >= 0) {
            walk(land, side);
        } else if (side == 4) {
            walk(land, rand.nextInt(4));
        }

    }

    public void run() {
        while (!MountDoom.isIsWon()) {
           /* try {
               // Thread.sleep(100);
            } catch (InterruptedException ex) {
            }*/
            if (mygame.MyGame.warriorsInTheGame == 0) {
                System.out.println("Game over !");
                System.out.println("==============================================");
                break;
            }
            superWalk(land);
        }
        this.stop();
    }

}

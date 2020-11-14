/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inhabitant;

import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.LandOfMordor;
import objects.Tree;
import tools.WalkingStick;
import objects.*;
import tools.Node;


public class Warrior extends InhabitantChracter implements Iwarrior {

    private static int numberOfWarriors = 0;        // To hold number of warriors added to grid
    private boolean mobility;                       // To check mobility of each warriors
    WalkingStick ws;                                // To hold the walking stick 
    private boolean immortal;                       // To check immortal
    Random rand;
    LandOfMordor land;
    ArrayList<InhabitantChracter> monster_observers;

    public Warrior(String name, int age, LandOfMordor land, ArrayList<InhabitantChracter> monster_observers) {          // Construct the warrior object 
        setCharacterName(name);
        setAge(age);
        mobility = true;
        ws = new WalkingStick();
        rand = new Random();
        immortal = false;
        numberOfWarriors += 1;
        this.land = land;
        this.monster_observers = monster_observers;
    }

    public void addCoordinates(int x, int y) {       // Upadte the coordinates of each warriors
        node = new Node(this, x, y);
    }

    public void walk(LandOfMordor land, int side) {     // walk method & check the final node for Tree, Normal Monster, Innocent monster
        if (isMobility()) {
            if (side == 0 && node.getX() != 10) {
                land.changeNode(this, node.getX(), node.getY(), node.getX() + 1, node.getY(), 1);
                node.setX(node.getX() + 1);
            } else if (side == 1 && node.getY() != 10) {
                land.changeNode(this, node.getX(), node.getY(), node.getX(), node.getY() + 1, 1);
                node.setY(node.getY() + 1);

            } else if (side == 2 && node.getX() != 0) {

                land.changeNode(this, node.getX(), node.getY(), node.getX() - 1, node.getY(), 1);
                node.setX(node.getX() - 1);

            } else if (side == 3 && node.getY() != 0) {
                land.changeNode(this, node.getX(), node.getY(), node.getX(), node.getY() - 1, 1);
                node.setY(node.getY() - 1);

            }
            if (land.grid[node.getX()][node.getY()][0] != null) {
                if (land.grid[node.getX()][node.getY()][0] instanceof Tree && !isImmortal()) {
                    Tree t = (Tree) land.grid[node.getX()][node.getY()][0];
                    eat(t);
                }
            }
            notifyMonsters();
        } else {
            System.out.println(getCharacterName() + " can't walk !");
            this.stop();
        }
    }

    public WalkingStick loseStick() {                               // for lose stick
        setMobility(false);
        WalkingStick temp = ws;
        ws = null;
        return temp;
    }

    public void notifyMonsters() {
        for (int i = 0; i < 5; i++) {
            InhabitantChracter ic = monster_observers.get(i);
            if (ic instanceof NormalMonster) {
                NormalMonster m = (NormalMonster) ic;
                m.update(this);
            } else {
                InnocentMonster m = (InnocentMonster) ic;
                m.update(this);
            }
        }
    }

    public void eat(Tree tree) {                                    // For eat immortal fruit 
        if (tree.getFruit() != null) {
            tree.loseFruit();
            setImmortal(true);
            System.out.println(this.getCharacterName() + " becomes immortal !");
        } else {
            //System.out.println("This tree hasn't a Fruit !");
        }
    }

    public void drink() {

    }

    public void sleep() {

    }

    public static int getNumberOfWarriors() {
        return numberOfWarriors;
    }

    /**
     * @return the mobility
     */
    public boolean isMobility() {
        return mobility;
    }

    /**
     * @param mobility the mobility to set
     */
    public void setMobility(boolean mobility) {
        this.mobility = mobility;
    }

    /**
     * @return the immortal
     */
    public boolean isImmortal() {
        return immortal;
    }

    /**
     * @param immortal the immortal to set
     */
    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
    }

    @Override
    public void run() {
        while (!MountDoom.isIsWon()) {
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                
            }*/
            if (mygame.MyGame.warriorsInTheGame == 0) {
                System.out.println("Game over !");
                System.out.println("==============================================");
                break;
            }
            walk(land, rand.nextInt(4));

        }
        this.stop();
    }

    public void update() {
        this.stop();
    }
}

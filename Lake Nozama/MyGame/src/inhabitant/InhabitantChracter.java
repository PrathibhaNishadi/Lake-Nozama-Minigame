/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inhabitant;

import objects.LandOfMordor;
import tools.Node;


public abstract class InhabitantChracter extends Thread {                      // Abstract class for implemet commom attributes and behaviours

    private String characterName;                               // For hold Inhabitant character name
    private int age;                                            // For hold Inhabitant character age
    public Node node;

    /**
     * @return the characterName
     */
    public abstract void addCoordinates(int x, int y);                       // For update corrdinates of Character

    public abstract void walk(LandOfMordor land, int side);                     // Walk behaviour implement for all inhabitant character

    public String getCharacterName() {
        return characterName;
    }

    /**
     * @param name the characterName to set
     */
    public void setCharacterName(String name) {
        this.characterName = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

}

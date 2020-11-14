/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import tools.ImmortalFruit;
import tools.Node;

public class Tree {

    /**
     * @return the treeCoordinates
     */
    private ImmortalFruit fruit;
    Node node;                                // To hold coordinates of each tree
    boolean hasFruit;
    public Tree() {                                         // Construct Tree object with Immortal fruit object
        fruit = new ImmortalFruit();
        hasFruit=true;
        
    }

    public synchronized void loseFruit() {
        this.setFruit(null);
        hasFruit = false;
    }

    public void addCoordinate(int x, int y) {        // add coordinates of tree to treeCordinates
        node = new Node(this,x,y);
    }

    /**
     * @return the fruit
     */
    public ImmortalFruit getFruit() {
        return fruit;
    }

    /**
     * @param fruit the fruit to set
     */
    public void setFruit(ImmortalFruit fruit) {
        this.fruit = fruit;
    }
    
    public boolean hasFruit(){
        return hasFruit;
    }

}

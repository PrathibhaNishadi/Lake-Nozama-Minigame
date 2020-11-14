/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;


public class Node {

    private int x;
    private int y;
    private Object object;
    private ArrayList<String> fullPath = new ArrayList<String>();

    public Node(Object object, int x, int y) {
        this.x = x;
        this.y = y;
        this.object = object;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
        String temp = "(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")";
        fullPath.add(temp);
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;

    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
        String temp = "(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")";
        fullPath.add(temp);
    }

    public String getFullPath() {
        String path = "";
        for (int i = 0; i < fullPath.size(); i++) {
            path+=(fullPath.get(i) + "  ");
        }
        return path;
    }

}

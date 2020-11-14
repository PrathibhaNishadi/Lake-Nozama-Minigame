/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import inhabitant.NormalMonster;
import inhabitant.Warrior;
import inhabitant.InnocentMonster;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.MIN_PRIORITY;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LandOfMordor {

    public Object[][][] grid;
    Random random;
    public static boolean free;
    MountDoom md;

    public LandOfMordor(MountDoom md, int width, int length) {
        random = new Random();
        grid = new Object[width][length][2];
        free = true;
        this.md = md;

    }

    public synchronized int isEmptyNode(int x, int y, int index) {                           // check the given node of grid is emplty 
        if (grid[x][y][index] == null) {
            return 0;
        } else if (grid[x][y][index].getClass() == Warrior.class) {
            return 1;
        } else if (grid[x][y][index].getClass() == NormalMonster.class) {
            return 2;
        } else if (grid[x][y][index].getClass() == InnocentMonster.class) {
            return 3;
        } else if (grid[x][y][index].getClass() == Tree.class) {
            return 4;
        } else {
            return 5;
        }
    }

    public synchronized void addObject(Object object, int x, int y, int index) {                              // Add objects to grid
        grid[x][y][index] = object;
    }

    public synchronized void remove(int x, int y) {                                          // Remove Objects from the grid
        grid[x][y][0] = null;
    }

    public synchronized void changeNode(Warrior w, int fx, int fy, int sx, int sy, int type) {          // To change characters node to move
        //free = false;
        if (isEmptyNode(sx, sy, 1) == 0 && !MountDoom.isIsWon()) {
            grid[sx][sy][1] = grid[fx][fy][1];
            grid[fx][fy][1] = null;
            System.out.println(w.getCharacterName() + " moved to (" + sx + "," + sy + ")");
        }
        if (checkForWinner(sx, sy)) {
            long endTime = System.currentTimeMillis();
            MountDoom.setIsWon(true);
            try {
                FileWriter fw = new FileWriter("C:\\Users\\Thilina Prasad\\Desktop\\Winner Details.txt");
                PrintWriter pw = new PrintWriter(fw);
                System.out.println(w.getCharacterName() + " Won the Game :) ");
                pw.println("Winner Name : " + w.getCharacterName());
                System.out.println("==============================================");
                System.out.print("Path of the Winner " + w.getCharacterName() + " : ");
                System.out.print(w.node.getFullPath() + "\n");
                pw.append("Path of the Winner : " + w.node.getFullPath()+"\r\n");
                System.out.println("==============================================");
                System.out.println("Time to Win : " + ((endTime - mygame.MyGame.getStartTime()) / 1000.0) + " Secs");
                pw.append("Time to Win : " + ((endTime - mygame.MyGame.getStartTime()) / 1000) + " Secs");
                fw.close();
                md.notifyWarriors();

            } catch (IOException e) {
            }
        }
    }

    public synchronized boolean checkForWinner(int x, int y) {                               // Check warrior's corrdinate is (5,5)
        return (x == 5 & y == 5);

    }

    public synchronized void guarded(Warrior w) {
        while (!free) {
            try {
                w.wait();
            } catch (InterruptedException ex) {
            }
        }
    }
}

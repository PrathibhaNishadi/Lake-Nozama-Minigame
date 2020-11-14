/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import objects.LandOfMordor;
import objects.Tree;

public class Binocular {

    public int search(LandOfMordor land, int x, int y) {                //Search for trees with fruit
        if (x != 10 && land.grid[x + 1][y][0] instanceof Tree && ((Tree)land.grid[x + 1][y][0]).hasFruit()) {
            return 0;
        } else if (y != 10 && land.grid[x][y + 1][0] instanceof Tree && ((Tree)land.grid[x][y+1][0]).hasFruit()) {
            return 1;
        } else if (x != 0 && land.grid[x - 1][y][0] instanceof Tree && ((Tree)land.grid[x - 1][y][0]).hasFruit()) {
            return 2;
        } else if (y != 0 && land.grid[x][y - 1][0] instanceof Tree && ((Tree)land.grid[x][y-1][0]).hasFruit()) {
            return 3;
        } else{
            return 4;
        }
    }
}

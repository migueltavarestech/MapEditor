package org.academiadecodigo.bootcamp55.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player extends CellSquare {

    public Player() {
        super(0,0);
        square.setColor(Color.GREEN);
    }

    @Override
    public void draw(){
        square.fill();
    }

    public void moveRight(){
        col++;
        square.translate(CELL_SIZE,0);
    }

    public void moveLeft(){
        col--;
        square.translate(-CELL_SIZE,0);
    }

    public void moveUp(){
        row--;
        square.translate(0,-CELL_SIZE);
    }

    public void moveDown(){
        row++;
        square.translate(0,CELL_SIZE);
    }

    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}

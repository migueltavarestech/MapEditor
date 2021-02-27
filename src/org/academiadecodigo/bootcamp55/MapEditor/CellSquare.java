package org.academiadecodigo.bootcamp55.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.HashMap;
import java.util.LinkedList;

public class CellSquare {

    protected Rectangle square;
    protected int col;
    protected int row;
    protected static final int CELL_SIZE = 20;
    private boolean filled;

    public CellSquare(int col, int row) {
        this.col = col;
        this.row = row;
        square = new Rectangle(col*CELL_SIZE+Grid.PADDING, row*CELL_SIZE+Grid.PADDING, CELL_SIZE, CELL_SIZE);
    }

    public void draw() {
        square.draw();
    }

    public int getCol(){return col;}

    public int getRow(){return row;}

    public void paint(){
        square.fill();
        filled = true;
    }

    public void erase(){
        square.draw();
        filled = false;
    }

    public boolean isPainted(){
        return filled;
    }

    @Override
    public String toString(){
        return filled ? "1" : "0";
    }
}

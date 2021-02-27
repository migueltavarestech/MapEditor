package org.academiadecodigo.bootcamp55.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.File;

public class Grid {

    private Rectangle canvas;
    public static final int PADDING = 10;
    private int totalCols;
    private int totalRows;
    private static CellSquare[][] cells;

    public Grid(int totalCols, int totalRows) {
        this.totalCols = totalCols;
        this.totalRows = totalRows;
        cells = new CellSquare[totalCols][totalRows];
    }

    public void init() {
        for(int col=0; col<totalCols; col++){
            for(int row=0; row<totalRows; row++){
                cells[col][row] = new CellSquare(col, row);
                cells[col][row].draw();
            }
        }
    }

    public int getTotalCols(){return totalCols;}

    public int getTotalRows(){return totalRows;}

    public CellSquare getCell(int col, int row){
        return cells[col][row];
    }

    @Override
    public String toString() {
        String result = "";
        for(int col=0; col<totalCols; col++){
            for(int row=0; row<totalRows; row++){
                result += cells[col][row].toString();
            }
            result += "\n";
        }
        return result;
    }

    public void clearGrid(){
        for(int col=0; col<totalCols; col++){
            for(int row=0; row<totalRows; row++){
                cells[col][row].erase();
            }
        }
    }

    public void convertFileToGrid(String grid){
        int counter = 0;
        for(int col=0; col<totalCols; col++){
            for(int row=0; row<totalRows; row++){
                CellSquare cell = cells[col][row];
                if(grid.charAt(counter) == '0'){
                    cell.erase();
                } else {
                    cell.paint();
                }
                counter++;
            }
            counter++;
        }
    }
}

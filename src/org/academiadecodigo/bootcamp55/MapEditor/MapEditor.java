package org.academiadecodigo.bootcamp55.MapEditor;

public class MapEditor {

    private Player player;
    private Grid grid;
    private boolean painting;

    public MapEditor(int totalCols, int totalRows){
        grid = new Grid(totalCols,totalRows);
        grid.init();

        player = new Player();
        player.draw();
    }

    public boolean isPlayerOnEdge(Player.Direction direction) {
        return direction == Player.Direction.UP && player.getRow() == 0 ||
                direction == Player.Direction.DOWN && player.getRow() == grid.getTotalRows()-1 ||
                direction == Player.Direction.LEFT && player.getCol() == 0 ||
                direction == Player.Direction.RIGHT && player.getCol() == grid.getTotalCols()-1;
    }

    public void movePlayer(Player.Direction direction) {
        if (isPlayerOnEdge(direction)) {
            return;
        }

        switch (direction) {
            case UP:
                player.moveUp();
                break;
            case DOWN:
                player.moveDown();
                break;
            case LEFT:
                player.moveLeft();
                break;
            case RIGHT:
                player.moveRight();
                break;
        }

        if(painting){
            paintCell();
        }
    }

    public void paintCell(){
        CellSquare cell = grid.getCell(player.getCol(), player.getRow());
        if(!cell.isPainted()){
            cell.paint();
            return;
        }
        cell.erase();
    }

    public void setPainting(boolean value){
        this.painting = value;
    }

    public void clear() { grid.clearGrid(); }

    public void load() { grid.convertFileToGrid(FileManager.readFile()); }

    public void save() { FileManager.writeFile(grid.toString()); }
}

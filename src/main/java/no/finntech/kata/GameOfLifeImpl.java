package no.finntech.kata;

import java.awt.*;
import java.util.List;

import no.finntech.kata.gameoflife.gui.GameOfLife;

public class GameOfLifeImpl implements GameOfLife {

    private final int x, y;

    private boolean[][] universe;

    public GameOfLifeImpl(int x, int y) {
        this.x = x;
        this.y = y;
        universe = new boolean[x][y];
    }

    public int getSize() {
        return x * y;  //To change body of created methods use File | Settings | File Templates.
    }


    @Override
    public void init(boolean[][] booleans) {
        this.universe = booleans;
    }

    @Override
    public boolean[][] nextGeneration() {
       tick();
      return universe;
    }

    public void setUp(List<Point> points) {
        for (Point point : points) {
            universe[point.x][point.y] = true;
        }
        //To change body of created methods use File | Settings | File Templates.
    }

    public boolean getValueAt(int x, int y) {
        return universe[x][y];
    }


    public boolean[][] getUniverse() {
        return universe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] booleans : universe) {
            for (boolean aBoolean : booleans) {
                sb.append(aBoolean ? 1 : 0).append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void tick() {
        boolean[][] oldUniverse = createCopy();
        for (int x1 = 0; x1 < this.x; x1++) {
            for (int y1 = 0; y1 < this.y; y1++) {
                tick(x1, y1, oldUniverse);
            }

        }
    }

    private boolean[][] createCopy() {
        boolean [][] copy = new boolean[x][y];
        for (int x1 = 0; x1 < this.x; x1++) {
            for (int y1 = 0; y1 < this.y; y1++) {
                copy[x1][y1]=universe[x1][y1];
            }
        }
        return copy;
    }

    private void tick(int x1, int y1, boolean [][] oldUniverse) {
        int aliveNeighbours = shouldCellDie(x1, y1, oldUniverse);
        if(universe[x1][y1] && (aliveNeighbours == 2 || aliveNeighbours == 3 )){
            universe[x1][y1] = true;
        } else if(!universe[x1][y1] && aliveNeighbours == 3){
            universe[x1][y1] = true;
        } else {
            universe[x1][y1] = false;
        }
    }

    private int shouldCellDie(int i, int j, boolean[][] oldUniverse) {
        int liveCount = 0;
        if (isNeighbourAlive(i - 1, j - 1,oldUniverse)) {
            liveCount++;
        }
        if (isNeighbourAlive(i - 1, j,oldUniverse)) {
            liveCount++;
        }
        if (isNeighbourAlive(i - 1, j + 1,oldUniverse)) {
            liveCount++;
        }
        if (isNeighbourAlive(i, j - 1,oldUniverse)) {
            liveCount++;
        }
        if (isNeighbourAlive(i, j + 1,oldUniverse)) {
            liveCount++;
        }
        if (isNeighbourAlive(i + 1, j - 1,oldUniverse)) {
            liveCount++;
        }
        if (isNeighbourAlive(i + 1, j,oldUniverse)) {
            liveCount++;
        }
        if (isNeighbourAlive(i + 1, j + 1,oldUniverse)) {
            liveCount++;
        }
        return liveCount;
    }

    private boolean isNeighbourAlive(int x1, int y1,boolean [][] oldUniverse) {
        return x1 >= 0 && x1 < x && y1 >= 0 && y1 < y && oldUniverse[x1][y1];
    }

    public int countAllLife() {
        int count = 0;
        for (boolean[] booleans : universe) {
            for (boolean aLive : booleans) {
                if (aLive) {
                    count++;
                }

            }
        }
        return count;
    }
}
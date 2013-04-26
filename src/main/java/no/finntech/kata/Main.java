package no.finntech.kata;

import java.awt.*;
import java.util.Arrays;

import no.finntech.kata.gameoflife.gui.GameOfLife;
import no.finntech.kata.gameoflife.gui.GameOfLifeRandomImpl;
import no.finntech.kata.gameoflife.gui.Worlds;

public class Main {


    public Main() {

        GameOfLife gameOfLife = new GameOfLifeImpl(48,48);
        GameOfLifeRandomImpl gameOfLife1 = new GameOfLifeRandomImpl();
        gameOfLife.init(gameOfLife1.nextGeneration());
        //createSetup2(gameOfLife);
        System.out.println(gameOfLife);

        try {


            new no.finntech.kata.gameoflife.gui.Gui(gameOfLife, gameOfLife.getUniverse()).display();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createSetup2(GameOfLifeImpl gameOfLife) {
        gameOfLife.setUp(Arrays.asList(
                new Point(12, 12), new Point(12, 13), new Point(12, 14) , new Point(12, 15), new Point(12, 16), new Point(12, 17),
                new Point(12, 18), new Point(12, 19)


        ));
    }

    private void createSetup1(GameOfLifeImpl gameOfLife) {
        gameOfLife.setUp(Arrays.asList(
                new Point(1, 2), new Point(2, 2), new Point(3, 2),
                new Point(5, 6), new Point(6, 6), new Point(7, 6)

        ));
    }

    private void createSetup3(GameOfLifeImpl gameOfLife) {
        gameOfLife.setUp(Arrays.asList(
                new Point(1, 2), new Point(2, 2), new Point(3, 2)


        ));
    }

    public static void main(String[] args) {
        new Main();
    }
}

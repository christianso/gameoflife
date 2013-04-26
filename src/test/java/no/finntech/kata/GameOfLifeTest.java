package no.finntech.kata;

import java.awt.*;
import java.util.Arrays;

import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;

public class GameOfLifeTest {

    @Test
    public void testCreateGame(){
        GameOfLifeImpl gameOfLife = new GameOfLifeImpl(10,10);
        assertThat(gameOfLife.getSize()).isEqualTo(100);


    }

    @Test
    public void testSetupLife(){
        GameOfLifeImpl gameOfLife = new GameOfLifeImpl(10, 10);
        gameOfLife.setUp(Arrays.asList(new Point(2,3),new Point(3,3)));
        assertThat(gameOfLife.getValueAt(2,3)).isTrue();
        System.out.println(gameOfLife);
    }

    @Test
    public void testTick(){
        GameOfLifeImpl gameOfLife = new GameOfLifeImpl(10, 10);
        gameOfLife.setUp(Arrays.asList(new Point(2,3)));
        gameOfLife.tick();
        assertThat(gameOfLife.getValueAt(2,3)).isFalse();
        assertThat(gameOfLife.countAllLife()).isEqualTo(0);

    }

    @Test
    public void testSurvive(){
        GameOfLifeImpl gameOfLife = new GameOfLifeImpl(10, 10);
        gameOfLife.setUp(Arrays.asList(new Point(2,2), new Point(4,4)));
        System.out.println(gameOfLife);
        gameOfLife.tick();
        System.out.println(gameOfLife);
        assertThat(gameOfLife.getValueAt(2,2)).isFalse();
        assertThat(gameOfLife.getValueAt(4,4)).isFalse();
        assertThat(gameOfLife.getValueAt(3,3)).isTrue();
        assertThat(gameOfLife.countAllLife()).isEqualTo(1);

      }


    @Test
    public void testBarLife(){
        GameOfLifeImpl gameOfLife = new GameOfLifeImpl(5, 5);
        gameOfLife.setUp(Arrays.asList(new Point(1,2), new Point(2,2), new Point(3,2)));
        System.out.println(gameOfLife);
        gameOfLife.tick();
        System.out.println(gameOfLife);
        gameOfLife.tick();
        System.out.println(gameOfLife);
        gameOfLife.tick();
        System.out.println(gameOfLife);
        assertThat(gameOfLife.getValueAt(2,1)).isTrue();
        assertThat(gameOfLife.getValueAt(2,2)).isTrue();
        assertThat(gameOfLife.getValueAt(2,3)).isTrue();
    }


}

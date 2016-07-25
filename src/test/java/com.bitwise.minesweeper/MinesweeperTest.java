import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class MinesweeperTest {

    private Minesweeper sweeper;

    @Test
    public void createFileWhichStoresInput() {
        try {
            FileWriter testFile = new FileWriter("input.txt");
            BufferedWriter input = new BufferedWriter(testFile);
            input.write("3 3");
            input.newLine();
            input.write("*..\n" + "..*\n" + ".*.\n");
            readFile();
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void canReadFromInputFile() {
        readFile();
    }

    private void readFile() {
        sweeper = new Minesweeper();
        sweeper.readInput("input.txt");
    }

    @Test
    public void canGetCellLocation() {
        sweeper = new Minesweeper();
        sweeper.getCell(1, 1);
    }

    @Test
    public void getCellAtSpecifiedCoordinate() {
        readFile();
        assertEquals('.', sweeper.getCell(1, 1));
    }

    @Test
    public void getNorthWestCellFromGrid() {
        sweeper = new Minesweeper();
        sweeper.getNorthWestCell(1, 1);
    }

    @Test
    public void returnCharacterAtNorthWestCell() {
        readFile();
        assertEquals('.', sweeper.getNorthWestCell(2, 2));
        assertEquals('x', sweeper.getNorthWestCell(0, 0));
        assertEquals('x', sweeper.getNorthWestCell(2, 0));
        assertEquals('x', sweeper.getNorthWestCell(1, 0));
    }

    @Test
    public void getNorthCellFromGrid() {
        sweeper = new Minesweeper();
        sweeper.getNorthCell(1, 1);
    }

    @Test
    public void returnCharacterAtNorthCell() {
        readFile();
        assertEquals('*', sweeper.getNorthCell(2, 2));
        assertEquals('x', sweeper.getNorthCell(0, 0));
        assertEquals('x', sweeper.getNorthCell(0, 2));
        assertEquals('x', sweeper.getNorthCell(0, 1));

    }

    @Test
    public void getNorthEastCellFromGrid() {
        sweeper = new Minesweeper();
        sweeper.getNorthEastCell(1, 1);
    }

    @Test
    public void returnCharacterAtNorthEastCell() {
        readFile();
        assertEquals('.', sweeper.getNorthEastCell(1, 1));
        assertEquals('x', sweeper.getNorthEastCell(2, 2));
        assertEquals('x', sweeper.getNorthEastCell(1, 2));
        assertEquals('x', sweeper.getNorthEastCell(0, 2));

    }

    @Test
    public void getEastCellFromGrid() {
        sweeper = new Minesweeper();
        sweeper.getEastCell(1, 1);
    }

    @Test
    public void returnCharacterAtEastCell() {
        readFile();
        assertEquals('*', sweeper.getEastCell(1, 1));
        assertEquals('x', sweeper.getEastCell(2, 2));
        assertEquals('x', sweeper.getEastCell(1, 2));
        assertEquals('x', sweeper.getEastCell(0, 2));

    }

    @Test
    public void getSouthEastCellFromGrid() {
        sweeper = new Minesweeper();
        sweeper.getSouthEastCell(1, 1);
    }

    @Test
    public void returnCharacterAtSouthEastCell() {
        readFile();
        assertEquals('.', sweeper.getSouthEastCell(1, 1));
        assertEquals('x', sweeper.getSouthEastCell(2, 2));
        assertEquals('x', sweeper.getSouthEastCell(2, 0));
        assertEquals('x', sweeper.getSouthEastCell(2, 1));

    }

    @Test
    public void getSouthCellFromGrid() {
        sweeper = new Minesweeper();
        sweeper.getSouthCell(1, 1);
    }

    @Test
    public void returnCharacterAtSouthCell() {
        readFile();
        assertEquals('*', sweeper.getSouthCell(1, 1));
        assertEquals('x', sweeper.getSouthCell(2, 2));
        assertEquals('x', sweeper.getSouthCell(2, 0));
        assertEquals('x', sweeper.getSouthCell(2, 1));

    }

    @Test
    public void getSouthWestCellFromGrid() {
        sweeper = new Minesweeper();
        sweeper.getSouthWestCell(1, 1);
    }

    @Test
    public void returnCharacterAtSouthWestCell() {
        readFile();
        assertEquals('.', sweeper.getSouthWestCell(1, 1));
        assertEquals('x', sweeper.getSouthWestCell(2, 2));
        assertEquals('x', sweeper.getSouthWestCell(2, 0));
        assertEquals('x', sweeper.getSouthWestCell(2, 1));
        assertEquals('x', sweeper.getSouthWestCell(0, 0));
        assertEquals('x', sweeper.getSouthWestCell(1, 0));
    }

    @Test
    public void getWestCellFromGrid() {
        sweeper = new Minesweeper();
        sweeper.getWestCell(1, 1);
    }

    @Test
    public void returnCharacterAtWestCell() {
        readFile();
        assertEquals('.', sweeper.getWestCell(1, 1));
        assertEquals('x', sweeper.getWestCell(0, 0));
        assertEquals('x', sweeper.getWestCell(1, 0));
        assertEquals('x', sweeper.getWestCell(2, 0));

    }

    @Test
    public void EvaluateNeighborsOfEveryCellPosition() {
        sweeper = new Minesweeper();
        sweeper.CalculateNeighborCellMines(1, 1);
    }

    @Test
    public void returnMineCountOfGrid() {
        sweeper = new Minesweeper();
        readFile();
        int count = 0;
        count = getCount(count);

        assertEquals(count, sweeper.CalculateNeighborCellMines(1, 1));
    }

    private int getCount(int count) {
        if (sweeper.getNorthWestCell(1, 1) == '*') {
            count++;
        }
        if (sweeper.getNorthCell(1, 1) == '*') {
            count++;
        }
        if (sweeper.getNorthEastCell(1, 1) == '*') {
            count++;
        }
        if (sweeper.getEastCell(1, 1) == '*') {
            count++;
        }
        if (sweeper.getSouthEastCell(1, 1) == '*') {
            count++;
        }
        if (sweeper.getSouthCell(1, 1) == '*') {
            count++;
        }
        if (sweeper.getSouthWestCell(1, 1) == '*') {
            count++;
        }
        if (sweeper.getWestCell(1, 1) == '*') {
            count++;
        }
        return count;
    }

    @Test
    public void canPlotFinalGrid() {
        sweeper = new Minesweeper();
        sweeper.plot();
    }

    @Test
    public void returnOutputArrayContainingMinesAndNeighborValues() {
        readFile();
        char[][] expected = {{'*', '2', '1'}, {'2', '3', '*'}, {'1', '*', '2'}};
        char[][] actual = sweeper.plot();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void createOutputTextFileContainingMines() {
        try {
            FileWriter testFile = new FileWriter("output.txt");
            BufferedWriter out = new BufferedWriter(testFile);
            readFile();
            char[][] MineGrid = sweeper.plot();
            for (char[] aMineGrid : MineGrid) {
                for (int j = 0; j < MineGrid.length; j++) {
                    out.write(aMineGrid[j]);
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}

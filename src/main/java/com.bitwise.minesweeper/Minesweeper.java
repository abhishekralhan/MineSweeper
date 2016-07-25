import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Minesweeper {
    private int row;
    private int column;
    private char[][] grid;

    void readInput(String fileName) {
        try {
            Scanner scan = getScanner(fileName);

            scan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @NotNull
    private Scanner getScanner(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(fileName));
        row = scan.nextInt();
        column = scan.nextInt();
        grid = new char[row][column];
        scan.nextLine();
        String line = "";
        while (scan.hasNext()) {
            line += scan.next();
        }
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++, index++) {
                grid[i][j] = line.charAt(index);
            }
        }
        return scan;
    }

    char getCell(int aRow, int aCol) {
        char extra = 'x';
        if (aRow < 0 || aCol < 0 || aRow > row - 1 || aCol > column - 1) {
            return extra;
        } else {
            return grid[aRow][aCol];
        }

    }

    char getNorthWestCell(int aRow, int aCol) {
        return getCell(aRow - 1, aCol - 1);
    }

    char getNorthCell(int aRow, int aCol) {
        return getCell(aRow - 1, aCol);
    }


    char getNorthEastCell(int aRow, int aCol) {
        return getCell(aRow - 1, aCol + 1);
    }

    char getEastCell(int aRow, int aCol) {
        return getCell(aRow, aCol + 1);
    }

    char getSouthEastCell(int aRow, int aCol) {
        return getCell(aRow + 1, aCol + 1);
    }

    char getSouthCell(int aRow, int aCol) {
        return getCell(aRow + 1, aCol);
    }

    char getSouthWestCell(int aRow, int aCol) {
        return getCell(aRow + 1, aCol - 1);
    }

    char getWestCell(int aRow, int aCol) {
        return getCell(aRow, aCol - 1);
    }

    int CalculateNeighborCellMines(int aRow, int aCol) {
        int count = 0;
        count = getCount(aRow, aCol, count);
        return count;
    }

    private int getCount(int aRow, int aCol, int count) {
        if (getNorthWestCell(aRow, aCol) == '*') {
            count++;
        }
        if (getNorthCell(aRow, aCol) == '*') {
            count++;
        }
        if (getNorthEastCell(aRow, aCol) == '*') {
            count++;
        }
        if (getEastCell(aRow, aCol) == '*') {
            count++;
        }
        if (getSouthEastCell(aRow, aCol) == '*') {
            count++;
        }
        if (getSouthCell(aRow, aCol) == '*') {
            count++;
        }
        if (getSouthWestCell(aRow, aCol) == '*') {
            count++;
        }
        if (getWestCell(aRow, aCol) == '*') {
            count++;
        }
        return count;
    }

    char[][] plot() {
        char[][] final_grid = new char[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '*') {
                    final_grid[i][j] = '*';
                } else {
                    final_grid[i][j] = (char) (CalculateNeighborCellMines(i, j) + '0');
                }
            }
        }
        return final_grid;
    }

}

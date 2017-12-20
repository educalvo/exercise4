package sudokusolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class sudokuSolver {

	static final int DIM = 9;

	public static void main(String[] args) {
		try {
			solveSudoku("sudoku.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception occured");
			e.printStackTrace();
		}
	}

	private static void solveSudoku(String string) throws IOException {
		InputStreamReader reader = new InputStreamReader(new FileInputStream(string));
		int[] puzzle = new int[DIM * DIM];
		int line;
		for (int row = 0; row < DIM; row++) {
			for (int col = 0; col < DIM; col++) {
				line = reader.read();
				if (line == (int)' ')
					puzzle[col] = 0;
				else
					puzzle[col] = line;
			}
		}
		System.out.println(puzzle);
		int row = 0, col = 0;
		int position = row * DIM + col;
		row = position / DIM;
		col = position % DIM;
		solve(puzzle);

	}

	private static void solve(int[] puzzle) {
		int free = findFirstFreePosition(puzzle);
		if (free == puzzle.length)
			dump(puzzle);
		else
			for (int digit = 1; digit <= 9; digit++) {
				puzzle[free] = digit; // prepare
				if (isValid(puzzle))
					solve(puzzle); // recurse
				puzzle[free] = 0; // repair
			}
	}

	private static boolean isValid(int[] puzzle) {
		// TODO Auto-generated method stub
		return false;
	}

	private static void dump(int[] puzzle) {
		for (int j = 0; j < DIM; j++) {
			for (int i = 9*j; i < DIM + DIM*j; i++)
				System.out.print(puzzle[i]);
			System.out.println("");
		}
	}

	private static int findFirstFreePosition(int[] puzzle) {
		// TODO Auto-generated method stub
		return 0;
	}

}

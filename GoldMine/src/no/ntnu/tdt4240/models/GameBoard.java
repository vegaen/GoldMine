package no.ntnu.tdt4240.models;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GameBoard {

	private static final int CELL_SIZE = 50;
	//FIX: private
	public Cell[][] gameBoard;
	public int height = 15;
	public int width = 21;

	public GameBoard() {

		this.gameBoard = new Cell[height][width];
	}

	public void addGold(int gold) {
		while (gold > 0) {
			int xValue = (int) (Math.random() * height);
			int yValue = (int) (Math.random() * width);

			if (gameBoard[xValue][yValue] == null) {
				gameBoard[xValue][yValue] = new Gold(null);
				gold--;
			}
		}
	}

	public void addMines(int mines) {
		while (mines > 0) {

			int xValue = (int) (Math.random() * height);
			int yValue = (int) (Math.random() * width);

			if (gameBoard[xValue][yValue] == null) {
				gameBoard[xValue][yValue] = new Mine(null);
				mines--;
			}
		}
	}

	public void addBlanks() {

		for (int a = 1; a < height; a++) {
			for (int b = 1; b < width; b++) {

				if (gameBoard[a][b] == null) {
					int numberOfAdjacentGold = 0;
					int numberOfAdjacentMines = 0;

					for (int c = a - 1; c < a + 1; c++) {
						for (int d = b - 1; d < b + 1; d++) {
							if (c > 0 && d > 0 && c < height && d < width) {

								if (gameBoard[c][d] instanceof Gold) {
									numberOfAdjacentGold++;
								}
								if (gameBoard[c][d] instanceof Mine) {
									numberOfAdjacentMines++;
								}
								gameBoard[a][b] = new Blank(null,
										numberOfAdjacentGold,
										numberOfAdjacentMines);
							}
						}
					}
				}
			}
		}
	}

	public void createBoard(int gold, int mines) {
		addGold(gold);
		addMines(mines);
		addBlanks();
	}

	public Cell[][] getGameBoard() {
		return gameBoard;
	}


}

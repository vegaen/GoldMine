package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;
import no.ntnu.tdt4240.activities.SettingsActivity;
import no.ntnu.tdt4240.views.Blank;
import no.ntnu.tdt4240.views.Cell;
import no.ntnu.tdt4240.views.Gold;
import no.ntnu.tdt4240.views.Mine;

public class GoldMineMode extends GameMode {

	private int numberOfGoldLeft;
	
	public GoldMineMode(GameActivity ga) {
		super(ga);
		numberOfGoldLeft = SettingsActivity.getAmountOfGold(ga);
	}

	@Override
	public void onClickedCell(Cell cell) {
		if (cell != null) {
			gameActivity.addToScore(calculateScore(cell));
			if (cell instanceof Mine) {
				gameActivity.switchPlayer();
			} else if (cell instanceof Blank) {
				gameActivity.switchPlayer();
			}
			else if (cell instanceof Gold){
				numberOfGoldLeft--;
			}
			else gameActivity.switchPlayer();
			if (isGameOver()) gameActivity.announceWinner();
		}
	}

	@Override
	public boolean hasGold() {
		return true;
	}

	@Override
	public boolean hasMines() {
		return true;
	}

	@Override
	public int calculateScore(Cell cell) {

		if (cell instanceof Gold)
			return 751;
		else if (cell instanceof Mine)
			return -1344;
		return 0;
	}

	@Override
	public boolean isGameOver() {
		return numberOfGoldLeft == 0;
	}

	@Override
	public Player desideWinner(Player player1, Player player2) {
		return player1.getScore() > player2.getScore() ? player1 : player2;
	}
}
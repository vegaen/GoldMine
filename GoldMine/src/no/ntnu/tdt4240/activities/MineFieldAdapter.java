package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.models.GameBoard;
import no.ntnu.tdt4240.views.Cell;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class MineFieldAdapter extends BaseAdapter {

	private GameBoard mGameBoard;

	public MineFieldAdapter(Context context, GameBoard gameBoard) {
		mGameBoard = gameBoard;
	}

	public int getCount() {
		return mGameBoard.getNumberOfCols() * mGameBoard.getNumberOfRows();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Cell cell;
		if (convertView == null) { // if it's not recycled, initialize some
			cell = mGameBoard.getCell(position);
			cell.setLayoutParams(new GridView.LayoutParams(40, 40));
			cell.setPadding(0, 0, 0, 0);

		} else {
			cell = (Cell) convertView;
		}

		return cell;
	}

}

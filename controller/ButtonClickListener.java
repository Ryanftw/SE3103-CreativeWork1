package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MemoryGameSimulator;

public class ButtonClickListener implements ActionListener {

	private MemoryGameSimulator panel;

	public ButtonClickListener(MemoryGameSimulator memGameSim) {
		this.panel = memGameSim;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var button = e.getSource();
		int buttons = panel.getRows();
		for (int i = 0; i < buttons; i++) {
			for (int j = 0; j < buttons; j++) {
				if (button == panel.getButton(i, j)) {
					panel.getMemoryGame().selectTile(i, j);

					panel.getButton(panel.getMemoryGame().getLastTile().getX(),
							panel.getMemoryGame().getLastTile().getY()).setEnabled(false);

					int z = panel.getMemoryGame().getTile(i, j).getValue();
					panel.getButton(i, j).setText(Integer.toString(z));
					if (panel.getMemoryGame().getTilesSelected() == 2) {
						if (panel.getMemoryGame().getLastTile().getMatch()
								&& panel.getMemoryGame().getLastTile2().getMatch()) {
							panel.getMemoryGame().setTilesSelected();

							panel.getButton(panel.getMemoryGame().getLastTile().getX(),
									panel.getMemoryGame().getLastTile().getY()).setEnabled(false);

							panel.getButton(panel.getMemoryGame().getLastTile2().getX(),
									panel.getMemoryGame().getLastTile2().getY()).setEnabled(false);
							panel.getDisplay().setText("Pairs found : " + panel.getMemoryGame().getPairsFound());
							if (panel.getMemoryGame().hasWon()) {
								panel.setYouWonDisplay();
							}
							// Update the pairs found/pairs left in the south panel.
						} else {
							panel.getButton(panel.getMemoryGame().getLastTile().getX(),
									panel.getMemoryGame().getLastTile().getY())
									.setText(panel.getMyText(panel.getMemoryGame().getLastTile().getX(),
											panel.getMemoryGame().getLastTile().getY()));
							panel.getMemoryGame().setTilesSelected();

							panel.getButton(panel.getMemoryGame().getLastTile().getX(),
									panel.getMemoryGame().getLastTile().getY()).setEnabled(true);

							panel.getButton(panel.getMemoryGame().getLastTile2().getX(),
									panel.getMemoryGame().getLastTile2().getY())
									.setText(panel.getMyText(panel.getMemoryGame().getLastTile2().getX(),
											panel.getMemoryGame().getLastTile2().getY()));
							panel.getMemoryGame().setTilesSelected();

							panel.getButton(panel.getMemoryGame().getLastTile2().getX(),
									panel.getMemoryGame().getLastTile2().getY()).setEnabled(true);
						}
					}
				}
			}
		}
	}
}
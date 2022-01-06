package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

//You might need to do something to the following line
public class FieldPane extends GridPane {

	private ObservableList<FieldCell> fieldCells = FXCollections.observableArrayList();

	public FieldPane() {
		// TODO complete the FieldPane's constructor
		this.setPrefWidth(500);
		this.setAlignment(Pos.CENTER);
		this.setVgap(8);
		this.setHgap(8);
		this.setPadding(new Insets(8, 8, 8, 8));

		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 6; j++) {
				FieldCell tmp = new FieldCell();
				fieldCells.add(tmp);
				this.add(tmp, i, j);
			}
		}

	}

	public int calculateIncome() {
		int income = 0;
		for (FieldCell c : fieldCells) {
			if (c.getCrop() != null) {
				income += c.getCrop().getIncome();
			}
		}
		return income;
	}

}

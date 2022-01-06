package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

//You might need to do something to the following line
public class ControlPane extends VBox {

	private ItemPane itemPane;
	private Button harvestButton;
	private Label moneyLabel;

	public ControlPane() {
		// TODO complete the ControlPane's constructor

		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(15);
		this.setFillWidth(true);

		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		harvestButton = new Button();
		harvestButton.setFont(new Font(20));

		moneyLabel = new Label();
		setMoneyLabelText();
		moneyLabel.setFont(new Font(20));

		Label text1 = new Label("Please select a seed or removal tool");
		text1.setFont(new Font(14));

		itemPane = new ItemPane();

		harvestButton = new Button("Harvest");
		harvestButton.setPrefWidth(150);

		harvestButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				SimulationManager.harvestHandler();
			}
		});

		this.getChildren().addAll(moneyLabel, text1, itemPane, harvestButton);

	}

	public void setMoneyLabelText() {
		moneyLabel.textProperty().setValue("Money: " + SimulationManager.getMoney());
	}

	public ItemPane getItemPane() {
		return itemPane;
	}

	public Button getHarvestButton() {
		return harvestButton;
	}

	public Label getMoneyLabel() {
		return moneyLabel;
	}

}

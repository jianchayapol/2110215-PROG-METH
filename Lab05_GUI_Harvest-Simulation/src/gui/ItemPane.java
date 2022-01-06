package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//You might need to do something to the following line
public class ItemPane extends GridPane {

	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();

	public ItemPane() {
		// TODO implements the ItemPane's constructor
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);

		ItemButton corn = new ItemButton("Corn");
		corn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (SimulationManager.getMoney() >= corn.getItem().getPrice()) {
					setSelectedButton(corn);
				}
			}
		});
		
		ItemButton coffee = new ItemButton("Coffee");
		coffee.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (SimulationManager.getMoney() >= coffee.getItem().getPrice()) {
					setSelectedButton(coffee);
				}
			}
		});
		
		ItemButton blueberry = new ItemButton("Blueberry");
		blueberry.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (SimulationManager.getMoney() >= blueberry.getItem().getPrice()) {
					setSelectedButton(blueberry);
				}
			}
		});
		
		ItemButton strawberry = new ItemButton("Strawberry");
		strawberry.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (SimulationManager.getMoney() >= strawberry.getItem().getPrice()) {
					setSelectedButton(strawberry);
				}
			}
		});
		
		ItemButton pineapple = new ItemButton("Pineapple");
		pineapple.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (SimulationManager.getMoney() >= pineapple.getItem().getPrice()) {
					setSelectedButton(pineapple);
				}
			}
		});
		
		ItemButton destroyTool = new ItemButton("DestroyTool");
		destroyTool.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (SimulationManager.getMoney() >= destroyTool.getItem().getPrice()) {
					setSelectedButton(destroyTool);
				}
			}
		});
		
		
		this.add(corn, 0, 0, 1, 1);
		this.add(coffee, 1, 0, 1, 1);
		this.add(blueberry, 2, 0, 1, 1);
		this.add(strawberry, 0, 1, 1, 1);
		this.add(pineapple, 1, 1, 1, 1);
		this.add(destroyTool, 2, 1, 1, 1);
		
		this.itemButtonList.addAll(corn,coffee,blueberry,strawberry,pineapple,destroyTool);
		
	}

	public void setSelectedButton(ItemButton selecteditemButton) {
		// TODO set selectedItemButton of SimulationManager to given ItemButton
		// resetButtonsBackgroundColor and the highlight the selecteditemButton
		
		SimulationManager.setSelectedItemButton(selecteditemButton);
		resetButtonsBackGroundColor();
		selecteditemButton.highlight();

	}

	public void resetButtonsBackGroundColor() {
		// TODO unhighlight each button in itemButtonList

		for (ItemButton bt : itemButtonList) {
			bt.unhighlight();
		}

	}

}

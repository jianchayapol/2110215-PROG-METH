package application;

import data.Task;
import data.TaskTable;
import data.TaskUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private static TaskTable taskTable;

	private static int progressingTaskCount;

	private static Button btnLoad;
	private static Button btnClear;

	private static int loadingTaskCount;

	@Override
	public void start(Stage primaryStage) throws Exception {
		taskTable = new TaskTable();

		StackPane root = new StackPane();

		VBox grid = new VBox();
		root.getChildren().add(grid);

		Scene scene = new Scene(root, 512, 480);

		Label header = new Label("Deserted Island Getaway Package Management");
		VBox.setMargin(header, new Insets(8, 8, 8, 8));
		grid.getChildren().add(header);

		TableView<Task> tb = taskTable.getTableView();

		taskTable.setTableProperty();

		VBox.setMargin(tb, new Insets(8, 8, 8, 8));
		grid.getChildren().add(tb);

		GridPane buttonpane = new GridPane();

		btnLoad = new Button("Load More Tasks");
		GridPane.setConstraints(btnLoad, 0, 0);
		GridPane.setMargin(btnLoad, new Insets(8, 8, 8, 8));
		buttonpane.getChildren().add(btnLoad);

		/*
		 * ====================FILL CODE============================ Make Clicking the
		 * "Load More Tasks" Button calling the proper method.
		 */

//		btnLoad.setOnAction(new EventHandler<ActionEvent>() {
//			public void handle(ActionEvent event) {
//				taskTable.populateData();
//			}
//		});

		btnLoad.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Thread thread = new Thread(() -> {
					try {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								Thread thread = new Thread(() -> { taskTable.populateData(); });
								thread.start();
								
							}
						});
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				});
				thread.start();
			}
		});

		/* ======================================================== */

		btnClear = new Button("Clear Finished Task(s)");
		GridPane.setConstraints(btnClear, 1, 0);
		GridPane.setMargin(btnClear, new Insets(8, 8, 8, 8));
		buttonpane.getChildren().add(btnClear);

		/*
		 * ====================FILL CODE============================ Make Clicking the
		 * "Clear Finished Task(s)" Button calling the proper method. Do note that if
		 * there is no Finished Task, then show the error.
		 */

		btnClear.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (taskTable.getFinishedTaskCount() > 0) {
					taskTable.removeAllCompletedTask();
				} else {
					showWarning();
				}
			}
		});

		/* ======================================================== */

		buttonpane.setAlignment(Pos.CENTER);
		VBox.setMargin(buttonpane, new Insets(8, 8, 8, 8));
		grid.getChildren().add(buttonpane);

		setLoadingTaskCount(0);
		setProgressingTaskCount(0);

		primaryStage.setTitle("Resident Service");

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void showWarning() {
		/*
		 * ====================FILL CODE============================ Show the Warning
		 * Dialogue according to the document.
		 */
		Alert a = new Alert(AlertType.NONE);
		if (taskTable.getFinishedTaskCount() == 0) {
			a.setAlertType(AlertType.WARNING);
			a.setContentText("There is no finished task.");
			a.show();
		}
		/* ======================================================== */
	}

	public static void disableButtonPane() {
		btnLoad.setDisable(true);
		btnClear.setDisable(true);
	}

	public static void enableButtonPane() {
		btnLoad.setDisable(false);
		btnClear.setDisable(false);
	}

	public static int getProgressingTaskCount() {
		return progressingTaskCount;
	}

	public static void setProgressingTaskCount(int progressingTaskCount) {
		Main.progressingTaskCount = progressingTaskCount;
	}

	public static void addProgressingTaskCount(int progressingTaskCount) {
		Main.progressingTaskCount += progressingTaskCount;
	}

	public static int getLoadingTaskCount() {
		return loadingTaskCount;
	}

	public static void setLoadingTaskCount(int loadingTaskCount) {
		Main.loadingTaskCount = loadingTaskCount;
	}

	public static void addLoadingTaskCount(int loadingTaskCount) {
		Main.loadingTaskCount += loadingTaskCount;
	}

}

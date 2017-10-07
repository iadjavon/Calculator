package CalcGUI;

//Various import fron javaFx
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * This class build the user interface for the calculator.
 * This calculator has two states.
 * At launch time it will always be in listening state and 
 * will transition to the compute state
 * according to the operation selected.
 * Anonymous class are used for the number buttons.
 * @author Itsido Adjavon
 */
public class CalculatorGui extends Application {

	TextField input;
	GridPane numberPane;
	GridPane operationPane;
	int numberPaneRows = 3;
	int numberPaneColumns = 4;
	Button[][] buttons;
	Button[][] op;
	HBox paneManager;
	VBox windowLayout;
	Scene frameScene;
	
	//the following object are used to set the listener
	String action = "";
	String temporary;
	//Button button;
	



	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage = new Stage();
		primaryStage.setTitle("Calculator");
		primaryStage.setResizable(true);
		primaryStage.setMaxHeight(1000);
		primaryStage.setMaxWidth(1000);

		numberBuilder();
		operationBuilder();
		inputdBuilder();
		managerLayout();
		windowManager();

		primaryStage.setScene(frameScene);
		primaryStage.show();

	}

	/*this method settup the button the 
	 * grid pane and also attach listener to 
	 * each object
	 */
	public void numberBuilder() {

		buttons = new Button[numberPaneRows][numberPaneColumns];
		int count = 0;
		for (int i = 0 ; i < numberPaneRows; i++) {


			for (int j  = 0 ; j < numberPaneColumns; j++) {

				//instantiating the button object
				buttons[i][j] = new Button();
			   Button button  = buttons[i][j];

				//number from 0 to 9 are set here
				buttons[i][j].setText("" + count++);
				//adding a listener to each button on the nuber pane
				buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						String text = null;
						temporary = null;
						//getting the content from the text editor
						action = input.getText();
						//getting the value of the button
						text  = button.getText();
						//building the string to be display on the text editor
						temporary = text;
						//display the new string in the text editor
						input.setText(action + temporary);

					}

				});

			}
		}


		buttons[2][2].setText("C");
		//adding the listener to the c button
		buttons[2][2].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				input.setText("");	
			}

		});

		buttons[2][3].setText("CE");
		//setting up the listener for CE button
		buttons[2][3].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				input.setText("");	
			}

		});

		//instantiating the number pane
		numberPane = new GridPane();
		//maximum size for the pane is set here
		numberPane.setMaxSize(700, 700);
		numberPane.setHgap(10);
		numberPane.setVgap(10);
		//adding the number button to the pane
		for(int i = 0 ; i < numberPaneRows; i ++)
			for(int j = 0 ; j <  numberPaneColumns; j++ ) {

				numberPane.add(buttons[i][j], j, i);

			}
	}

	/*
	 * This method build the operation pane and 
	 * attache listener to appropriate button
	 */
	public void operationBuilder() {
		//instantiating the operation pane
		op = new Button[3][];
		//instantiate the grid
		operationPane = new GridPane();
		//maximum size is set for the grid here
		operationPane.setMaxSize(700, 700);

		//instantiating the operation button
		op[0] = new Button[] {new Button("+"),new Button("-")};
		op[1] = new Button[] {new Button("/"),new Button("*"),new Button(".")};
		op[2] =  new Button[] {new Button("1/x"),new Button("sqrt"),new Button("=")};

		//adding the operation button to the pane and attaching the listener
		for(int i = 0 ; i < op.length; i ++) {
			
			for(int j = 0 ; j < op[i].length;j++) {
				operationPane.add(op[i][j], j, i);
				Button chars = op[i][j];
				op[i][j].setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						
						String texts = null;
						temporary = null;
						 
						//getting the content from the text editor
						action = input.getText();
						//getting the value of the button
						
						texts  = chars.getText();
						if(!texts.equals("=")) {
						//building the string to be display on the text editor
						temporary = texts;
						//display the new string in the text editor
						input.setText(action + temporary);
					}

				}});
				
				operationPane.setHgap(10);
				operationPane.setVgap(10);

			}
		}

	}
	
	

	/*
	 * this method instantiate the text field
	 * this text fiels display the number and 
	 * operation symbol
	 */
	public void inputdBuilder() {

		input = new TextField();

	}

	/*here we layout the number pane and operation pane
	 * 
	 */
	public void managerLayout() {

		paneManager = new HBox();
		paneManager.getChildren().addAll(numberPane, operationPane);
		paneManager.setSpacing(10);

	}

	/*
	 * This method set up the scene for the primary stage
	 */
	public void  windowManager() {


		windowLayout = new VBox();
		windowLayout.getChildren().addAll(input, paneManager);
		windowLayout.setSpacing(10);
		frameScene = new Scene(windowLayout);
	}

	/*
	 * Main to launch the application
	 */
	public static void main(String[] arg) {

		launch(arg);
	}





}

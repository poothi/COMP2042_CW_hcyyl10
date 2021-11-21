package view;

import java.awt.EventQueue;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuView {
		
	private Scene mainScene;
	
	private Button startButton;
	private Button infoButton;
	private Button exitButton;
	
	public static Image image;
	public static ImageView mv;
	
	GridPane gridpane;
	
	public MenuView (Stage mainStage){
		
		StackPane stack = new StackPane();

		VBox bgLayer = new VBox();
		
		createBackground(bgLayer);
		
		
		mainScene = new Scene(bgLayer,550,400);
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
		mainStage.setTitle("BrickBreaker by Emily");
		
		
		GridPane buttonLayer = new GridPane();
		
		initialize(buttonLayer);
		
		Text space0 = new Text("   ");
		Text space1 = new Text("   ");
		Text space2 = new Text("   ");

		
		createButtons();	
		buttonLayer.add(space0, 0, 0);
		buttonLayer.add(space1, 0, 1);
		buttonLayer.add(space2, 0, 2);
	    buttonLayer.add(startButton, 0, 5);
	    buttonLayer.add(infoButton, 0, 6);
	    buttonLayer.add(exitButton, 0, 7);
	    
	    stack.getChildren().addAll(bgLayer, buttonLayer);
	    stack.setAlignment(Pos.CENTER);
	    
	    Scene stackScene = new Scene(stack);
	    mainStage.setScene(stackScene);

	}
	
	private void createBackground(VBox bgLayer) {
		bgLayer.setBackground(new Background(
                new BackgroundImage(
                        new Image("file:src/resources/bg_new.png"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
                ))
			);
		
		
	}

	private void initialize(GridPane gp) {
		
	    gp.setMinSize(400, 200); 
	       
	    gp.setPadding(new Insets(10, 10, 10, 10)); 
	      
	    gp.setVgap(5); 
	    gp.setHgap(5);       
	      
	    gp.setAlignment(Pos.CENTER); 
	}

	private void createButtons() {
		
		startButton = new Button("Start");
		infoButton = new Button("Info");
		exitButton = new Button ("Exit");	
		
		startButton.setPrefWidth(70);
		infoButton.setPrefWidth(70);
		exitButton.setPrefWidth(70);
		
		startButton.setOnAction(e ->  EventQueue.invokeLater(() -> new GameFrame().enableGameBoard()));
		infoButton.setOnAction(e ->  EventQueue.invokeLater(() -> new GameFrame().enableInfoPage()));
		exitButton.setOnAction(e ->  System.exit(0));

	}

}
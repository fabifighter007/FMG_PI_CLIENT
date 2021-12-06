package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI {
	public GUI(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		HBox audiocontainer = addHBox();
		audiocontainer.getChildren().add(addAudioControllElement("Mikrofon"));
		audiocontainer.getChildren().add(addAudioControllElement("Lautsprecher"));
		audiocontainer.setAlignment(Pos.CENTER);
	    root.setBottom(audiocontainer);
	    
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private VBox addAudioControllElement(String name) {
		String cssLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-background-color: #c4dbff;\n";
		
	    VBox hbox = new VBox();
	    hbox.setAlignment(Pos.CENTER);
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle(cssLayout);

	    //A toggle button with a text caption
	    ToggleButton tb2 = new ToggleButton("Press me");


	    Text t = new Text (10, 20, name);
	    
	    Button buttonCurrent = new Button("Mute");
	    buttonCurrent.setPrefSize(100, 20);
	    
	    Slider slider = new Slider(0, 100, 1);
	    slider.setShowTickMarks(true);
	    slider.setShowTickLabels(true);
	    
	    hbox.getChildren().addAll(t, slider, tb2);
	    hbox.setMinWidth(150);
	    hbox.setMaxWidth(150);
	    hbox.setPrefWidth(150);
	    return hbox;
	}
	
	private VBox addInfoContainer( ) {
		VBox vbox = new VBox();
		
		return vbox;
		
	}
	
	private VBox addVBox() {
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
	    return vbox;
	}
	
	private HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(10));
	    hbox.setSpacing(8);
	    return hbox;
	}
	
	private FlowPane addFlowPane() {
	    FlowPane flow = new FlowPane();
	    flow.setPadding(new Insets(5, 0, 5, 0));
	    flow.setVgap(4);
	    flow.setHgap(4);
	    flow.setPrefWrapLength(170); // preferred width allows for two columns
	    flow.setStyle("-fx-background-color: DAE6F3;");

	    ImageView pages[] = new ImageView[8];
	    

	    return flow;
	}
	
	private void addStackPane(VBox vBox) {
	    StackPane stack = new StackPane();
	    Rectangle helpIcon = new Rectangle(30.0, 25.0);
	    helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
	        new Stop[]{
	        new Stop(0,Color.web("#4977A3")),
	        new Stop(0.5, Color.web("#B0C6DA")),
	        new Stop(1,Color.web("#9CB6CF")),}));
	    helpIcon.setStroke(Color.web("#D0E6FA"));
	    helpIcon.setArcHeight(3.5);
	    helpIcon.setArcWidth(3.5);

	    Text helpText = new Text("?");
	    helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
	    helpText.setFill(Color.WHITE);
	    helpText.setStroke(Color.web("#7080A0")); 

	    stack.getChildren().addAll(helpIcon, helpText);
	    stack.setAlignment(Pos.CENTER_RIGHT);     // Right-justify nodes in stack
	    StackPane.setMargin(helpText, new Insets(0, 10, 0, 0)); // Center "?"

	    vBox.getChildren().add(stack);            // Add to HBox from Example 1-2
	    HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
	}
	
	private GridPane addGridPane() {
	    GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 10, 0, 10));

	    // Category in column 2, row 1
	    Text category = new Text("Sales:");
	    category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(category, 1, 0); 

	    // Title in column 3, row 1
	    Text chartTitle = new Text("Current Year");
	    chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(chartTitle, 2, 0);

	    // Subtitle in columns 2-3, row 2
	    Text chartSubtitle = new Text("Goods and Services");
	    grid.add(chartSubtitle, 1, 1, 2, 1);


	    // Left label in column 1 (bottom), row 3
	    Text goodsPercent = new Text("Goods\n80%");
	    GridPane.setValignment(goodsPercent, VPos.BOTTOM);
	    grid.add(goodsPercent, 0, 2); 


	    // Right label in column 4 (top), row 3
	    Text servicesPercent = new Text("Services\n20%");
	    GridPane.setValignment(servicesPercent, VPos.TOP);
	    grid.add(servicesPercent, 3, 2);

	    return grid;
	}
}

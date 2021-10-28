import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HowdyFX extends Application {
    public void start(Stage primaryStage) {

        //Using a GridPane since that's how my brain works best
        GridPane introPane = new GridPane();
        VBox outputPane = new VBox();

        //Scene setup and execution
        Scene introScene = new Scene(introPane,500, 600);
        Scene outputScene = new Scene(outputPane, 500, 600);

        //*********************introPane*******************************
        //Non-setup nodes
        Label lbl = new Label("Enter Ingredient List");

        //Making the 'Process' Button take you to outputScene
        Button btProcess = new Button("Process");
        btProcess.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(outputScene);
        });

        //Making the 'Quit' Button exit the application
        Button btQuit = new Button("Quit");
        btQuit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        //TextArea node that's a pain in the ass to set up
        TextArea getText = new TextArea();
        getText.setPromptText("Ingredients go here..."); //prompt text for flavor
        getText.setMinSize(250,300);
        getText.setWrapText(true);

        //Adding nodes to the introPane
        introPane.add(lbl, 1, 0);
        introPane.add(getText, 0, 1, 3, 2);
        introPane.add(btProcess, 0, 3);
        introPane.add(btQuit, 2, 3);

        //introPane constraints
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setHgrow(Priority.NEVER);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        col1.setHalignment(HPos.CENTER);
        introPane.getColumnConstraints().addAll(col0, col1);
        //*********************outroPane*******************************
        //Non-setup nodes
        Label outLbl = new Label("Ingredients:");

        //Setting up a TableView for the output
        //Table background info
        TableView table = new TableView();
        table.setEditable(true);
        table.setPlaceholder(new Label("Nothing to display"));

        //Table col info
        TableColumn nameCol = new TableColumn("Ingredient");
        nameCol.setResizable(false);
        nameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        TableColumn descCol = new TableColumn("Description");
        descCol.setResizable(false);
        descCol.prefWidthProperty().bind(table.widthProperty().multiply(0.7));
        table.getColumns().addAll(nameCol, descCol);

        //Making the 'Return' Button take you back to introScene
        Button btReturn = new Button("Return");
        btReturn.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(introScene);
        });

        //Adding nodes to the outputPane
        outputPane.getChildren().addAll(outLbl, table, btReturn);

        //outputPane constraints
        outputPane.setAlignment(Pos.TOP_CENTER);

        //Stage setup and the usual
        primaryStage.setTitle("carioge Capstone");
        primaryStage.setScene(introScene);
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }
}

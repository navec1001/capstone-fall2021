import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HowdyFX extends Application {

    //Creating a Product object to get information from the Database
    static Product rootData = new Product();
    //Importing the class so I can use the one function it has
    static JavaSQL sqlStuff = new JavaSQL();

    //Creating a Product object for user use
    Product userProduct = new Product();

    //Prototyping Observable list so it can be dynamically changed with button press
    final ObservableList<Ingredient> data = FXCollections.observableArrayList();

    public void start(Stage primaryStage) {

        //Using a GridPane since that's how my brain works best
        GridPane introPane = new GridPane();
        VBox outputPane = new VBox();

        //Creating a Table so I can use it in Proceed Button
        TableView<Ingredient> table = new TableView<>();

        //Prototyping the button, will be dynamically updated with button presses
        Label outLbl = new Label("");

        //Scene setup and execution
        Scene introScene = new Scene(introPane,500, 600);
        Scene outputScene = new Scene(outputPane, 500, 600);

        //*********************introPane*******************************
        //Non-setup nodes
        Label nameLbl = new Label("Enter Product Name: ");
        Label lbl = new Label("Enter Ingredient List");

        //Making the 'Quit' Button exit the application
        Button btQuit = new Button("Quit");
        btQuit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        //TextField
        TextField getName = new TextField();
        getName.setPromptText("Product name goes here...");

        //TextArea node that's a pain in the ass to set up
        TextArea getText = new TextArea();
        getText.setPromptText("Ingredients go here..."); //prompt text for flavor
        getText.setMinSize(250,300);
        getText.setWrapText(true);

        //Making the 'Process' Button take you to outputScene
        Button btProcess = new Button("Process");
        btProcess.setOnAction((ActionEvent event) -> {
            /*button click:
            puts user entered data into a Product obj
            checks and prints in console,
            changes the Stage to the outputStage
            puts userProduct ingList data into the ObservableList and then into the TableView
            changes the outLbl on the stage to include the userProduct name
             */
            processBtnClick(userProduct, getName.getText(), getText.getText());
            //checkBtnClick(userProduct);
            compareLists(userProduct, rootData);
            primaryStage.setScene(outputScene);
            addTableData(userProduct, data, table);
            outLbl.setText("Ingredients for " + userProduct.getName() + ":");
        });

        //Adding nodes to the introPane
        introPane.add(nameLbl, 1,0);
        introPane.add(getName,0,1, 3, 1);
        introPane.add(lbl, 1, 2);
        introPane.add(getText, 0, 3, 3, 2);
        introPane.add(btProcess, 0, 5);
        introPane.add(btQuit, 2, 5);

        //introPane constraints
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setHgrow(Priority.NEVER);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        col1.setHalignment(HPos.CENTER);
        introPane.getColumnConstraints().addAll(col0, col1);
        //*********************outroPane*******************************
        //Setting up a TableView for the output
        //Table background info
        table.setEditable(true);
        table.setPlaceholder(new Label("Nothing to display"));

        //Table col info
        TableColumn nameCol = new TableColumn("Ingredient");
        nameCol.setResizable(false);
        nameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Ingredient, String>("name"));
        TableColumn descCol = new TableColumn("Description");
        descCol.setResizable(false);
        descCol.prefWidthProperty().bind(table.widthProperty().multiply(0.7));
        descCol.setCellValueFactory(
                new PropertyValueFactory<Ingredient, String>("desc"));
        table.getColumns().addAll(nameCol, descCol);

        //Making the 'Return' Button take you back to introScene
        Button btReturn = new Button("Return");
        btReturn.setOnAction((ActionEvent event) -> {
            /* button click:
            sets Stage back to the introScene
            clears the TableView data
            clears the userProduct name
            deletes userProduct ingList via making a whole new blank ArrayList
             */
            primaryStage.setScene(introScene);
            for (int i=0; i<table.getItems().size(); i++) {
                table.getItems().clear();
            }
            userProduct.setName("");
            userProduct.deleteIngList();
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

    //main function just launches JavaFX
    public static void main(String [] args) {
        sqlStuff.preLoadDatabase(rootData);
        launch(args);
    }

    //copies user information from the two Strings into the Product variable slots
    public void processBtnClick(Product inProd, String prodName, String prodIng) {
        inProd.setName(prodName);
        inProd.importIngList(prodIng);
    }

    //checks the above function for debugging purposes
    public void checkBtnClick(Product inProd) {
        System.out.println(inProd.getName());
        System.out.println();
        for (Ingredient ing : inProd.getIngList()) {
            System.out.println(ing);
        }
    }

    //adds all of the information from inProd to the ObservableList data, then plugs in data to the TableView table
    public void addTableData(Product inProd, ObservableList<Ingredient> data, TableView<Ingredient> table) {
        inProd.makeDescQuestion();
        data.addAll(inProd.getIngList());
        table.setItems(data);
    }

    public void compareLists(Product user, Product master) {
        for(int i=0; i < user.getIngList().size(); i++) {
            for (int j=0; j < master.getIngList().size(); j++) {
                //when a match is found, copy the desc from the ingDict Ingredient to the userList Ingredient desc
                if (user.getIngList().get(i).getName().equals(master.getIngList().get(j).getName())) {
                    user.getIngList().get(i).setDesc(master.getIngList().get(j).getDesc());
                }
            }
        }
    }
}

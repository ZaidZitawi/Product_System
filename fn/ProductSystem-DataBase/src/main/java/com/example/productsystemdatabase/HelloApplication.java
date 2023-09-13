package com.example.productsystemdatabase;

import java.sql.*;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.scene.layout.BorderPane;


public class HelloApplication extends Application {

    Image Update = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\update.png");
    Image AddStu = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\add-user.png");
    Image DeleteStu = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\delete-friend.png");
    Image DeleteStu1 = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\delete-friend.png");
    Image Winner = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\winner.png");
    Image Exit = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\return.png");
    Image Back = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\return.png");
    Image zaidScene = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\DS-P3.jpg");
    Image Users = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\users.png");
    Image Pine = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\Piine.png");
    Image userh = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\user.png");
    Image key = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\key.png");
    Image AccountPanel = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\user.png");
    Image price = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\prize.png");


    static Connection c;
    static String url = "jdbc:mysql://localhost/dbpine";
    static String user = "root";
    static String password = "1203101";


    String LabelStyle = "-fx-font-size: 18; -fx-font-weight: bold;";
    String LabelStyle1 = "-fx-font-size: 13; -fx-font-weight: bold;";
    String TextFieldStyle = "-fx-background-color:transparent ; -fx-border-color: #0598ff; -fx-border-width: 0px 0px 2px 0px";
    String ButtonStyle = "-fx-background-color:#0598ff";
    String ButtonStyle2 = "-fx-background-color:#0598ff; -fx-background-color:transparent; -fx-font-size: 13; -fx-font-weight: bold;";
    Label errorLabel = new Label();
    String currentid = "";
    int Gi=0;


    @Override
    public void start(Stage stage) {

//        ===========Start Login===============
        errorLabel.setTextFill(Color.RED);
        errorLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold;");
        ImageView UsersImage = new ImageView(Users);
        ImageView PineImage = new ImageView(Pine);
        ImageView userImage = new ImageView(userh);
        ImageView keyImage = new ImageView(key);
        //ImageView prizeImage = new ImageView(price);
        userImage.setFitHeight(20);
        userImage.setFitWidth(20);
        keyImage.setFitHeight(20);
        keyImage.setFitWidth(20);


        PineImage.setFitWidth(80);
        PineImage.setFitHeight(80);
        Label PineSystem = new Label("Pine Operation");
        PineSystem.setStyle(LabelStyle);
        UsersImage.setFitHeight(80);
        UsersImage.setFitWidth(80);
        Label l = new Label("Users Login");
        l.setStyle(LabelStyle);

        // Left AnchorPane
        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.setStyle("-fx-background-color:#0598ff");


        BorderPane border = new BorderPane();
        border.setLeft(leftAnchorPane);
        border.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));


        // username and password TextFields and Label
        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold");
        TextField usernameTextField = new TextField();
        usernameTextField.setStyle(TextFieldStyle);
        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold");
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle(TextFieldStyle);


        // Right AnchorPane
        AnchorPane rightAnchorPane = new AnchorPane();
        rightAnchorPane.setStyle("-fx-background-color:#ffffff");
        border.setRight(rightAnchorPane);
        // login button
        Button loginButton = new Button("Login");
        loginButton.setPrefSize(100, 20);
        loginButton.setStyle(ButtonStyle);

        // HBox for username and password TextFields and Label
        Label forgetPasswordLabel = new Label("Forget Password");
        VBox usernamePasswordHBox = new VBox();
        usernamePasswordHBox.setSpacing(10);
        usernamePasswordHBox.setPadding(new Insets(10));
        AnchorPane.setLeftAnchor(usernamePasswordHBox, 10.0);
        AnchorPane.setTopAnchor(usernamePasswordHBox, 10.0);
        rightAnchorPane.getChildren().addAll(usernamePasswordHBox);

        VBox leftAnchorVbox = new VBox(PineImage, PineSystem);
        leftAnchorVbox.setAlignment(Pos.CENTER);
        leftAnchorPane.getChildren().addAll(leftAnchorVbox);
        leftAnchorVbox.setSpacing(10);
        leftAnchorVbox.setPadding(new Insets(10));
        AnchorPane.setLeftAnchor(leftAnchorVbox, 50.0);
        AnchorPane.setTopAnchor(leftAnchorVbox, 120.0);
        HBox hBox = new HBox(userImage, usernameTextField);
        HBox hBox1 = new HBox(keyImage, passwordField);
        usernamePasswordHBox.getChildren().addAll(UsersImage, l, usernameLabel, hBox, passwordLabel, hBox1, loginButton, errorLabel, forgetPasswordLabel);


        border.widthProperty().addListener((obs, oldVal, newVal) -> {
            leftAnchorPane.setPrefWidth(newVal.doubleValue() / 2);
            rightAnchorPane.setPrefWidth(newVal.doubleValue() / 2);
        });
        leftAnchorVbox.setAlignment(Pos.CENTER);
        usernamePasswordHBox.setAlignment(Pos.CENTER);

        border.widthProperty().addListener((obs, oldVal, newVal) -> {
            PineImage.setFitWidth(newVal.doubleValue() * 0.2);
            PineImage.setFitHeight(newVal.doubleValue() * 0.2);
            UsersImage.setFitWidth(newVal.doubleValue() * 0.2);
            UsersImage.setFitHeight(newVal.doubleValue() * 0.2);
        });


        Scene scene = new Scene(border, 600, 500, Color.SKYBLUE);
        stage.setScene(scene);


        //00000000000000000000000000000000000Images
        ImageView UpdateView = new ImageView(Update);
        ImageView AddStuImage = new ImageView(AddStu);
        ImageView AddStuImage1 = new ImageView(AddStu);
        ImageView DeleteStuImage = new ImageView(DeleteStu);
        ImageView DeleteStuImage1 = new ImageView(DeleteStu1);
        ImageView WinnerImage = new ImageView(Winner);
        ImageView ExitImage = new ImageView(Exit);
        ImageView zaidScenImage = new ImageView(zaidScene);
//00000000000000000000000000000000000000000Images


//======================================================================================//
        //Admin Scene//
        // It will Contain the Customer Operations and Promoters Operations//
//=====================================================================================//

        //main Anchor
        AnchorPane mainAnchorPane = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane lap = new AnchorPane();
        lap.setPrefWidth(200);
        lap.setPrefHeight(500);
        lap.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(lap, 0.0);
        AnchorPane.setTopAnchor(lap, 0.0);
        AnchorPane.setBottomAnchor(lap, 0.0);

        //Inner Anchor Put the inner anchor in the top left
        AnchorPane innerPane = new AnchorPane();
        innerPane.setPrefWidth(200);
        innerPane.setPrefHeight(100);
        innerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(innerPane, 0.0);
        AnchorPane.setTopAnchor(innerPane, 0.0);
        Label pineAdministration = new Label("Pine Administration");
        pineAdministration.setStyle(LabelStyle);
        AnchorPane.setTopAnchor(pineAdministration, 0.0);
        AnchorPane.setBottomAnchor(pineAdministration, 0.0);
        AnchorPane.setLeftAnchor(pineAdministration, 25.0);
        AnchorPane.setRightAnchor(pineAdministration, 0.0);

        innerPane.getChildren().add(pineAdministration);
        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane lap1 = new AnchorPane(zaidScenImage);
        lap1.setPrefWidth(600);
        lap1.setPrefHeight(500);
        zaidScenImage.setFitWidth(900);
        zaidScenImage.setFitHeight(650);
        AnchorPane.setLeftAnchor(lap1, 200.0);
        AnchorPane.setTopAnchor(lap1, 100.0);
        AnchorPane.setRightAnchor(lap1, 0.0);
        AnchorPane.setBottomAnchor(lap1, 0.0);
        AnchorPane.setLeftAnchor(zaidScenImage, 25.0);
        AnchorPane.setTopAnchor(zaidScenImage, 0.0);
        AnchorPane.setRightAnchor(zaidScenImage, 0.0);
        AnchorPane.setBottomAnchor(zaidScenImage, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane lap2 = new AnchorPane();
        lap2.setPrefWidth(600);
        lap2.setPrefHeight(100);
        lap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(lap2, 200.0);
        AnchorPane.setTopAnchor(lap2, 0.0);
        AnchorPane.setRightAnchor(lap2, 0.0);


        Separator separator1 = new Separator();
        separator1.setStyle("-fx-background-color: black");
        separator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(separator1, 0.0);
        AnchorPane.setTopAnchor(separator1, 100.0);
        AnchorPane.setRightAnchor(separator1, 0.0);
        lap.getChildren().add(separator1);

        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);
        separator2.setPrefHeight(100);
        separator2.setStyle("-fx-background-color: black");
        AnchorPane.setLeftAnchor(separator2, 200.0);
        AnchorPane.setTopAnchor(separator2, 0.0);
        AnchorPane.setBottomAnchor(separator2, 0.0);
        mainAnchorPane.getChildren().add(separator2);

        VBox v = new VBox();
        v.setAlignment(Pos.CENTER_LEFT);
        v.setSpacing(20);


        Button addCustomerButton = new Button("  Add Customer", AddStuImage);
        addCustomerButton.setPrefSize(200, 30);
        addCustomerButton.setStyle(ButtonStyle2);
        AddStuImage.setFitWidth(50);
        AddStuImage.setFitHeight(50);
        // Add an effect to the button
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setRadius(10);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        addCustomerButton.setEffect(dropShadow);
        // Increase the opacity of the shadow when the mouse is over the button
        addCustomerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        addCustomerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow.setColor(Color.rgb(0, 0, 0, 0.5)));

        Button UpdateCustomerButton = new Button("Update Customer ", UpdateView);
        UpdateCustomerButton.setPrefSize(200, 30);
        UpdateCustomerButton.setStyle(ButtonStyle2);
        UpdateView.setFitHeight(50);
        UpdateView.setFitWidth(50);
        // Add an effect to the button
        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setBlurType(BlurType.GAUSSIAN);
        dropShadow1.setRadius(10);
        dropShadow1.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        UpdateCustomerButton.setEffect(dropShadow1);
        // Increase the opacity of the shadow when the mouse is over the button
        UpdateCustomerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow1.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        UpdateCustomerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow1.setColor(Color.rgb(0, 0, 0, 0.5)));


        Button deleteCustomerButton = new Button("Delete Customer", DeleteStuImage);
        deleteCustomerButton.setPrefSize(200, 30);
        deleteCustomerButton.setStyle(ButtonStyle2);
        DeleteStuImage.setFitWidth(50);
        DeleteStuImage.setFitHeight(50);
        // Add an effect to the button
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setBlurType(BlurType.GAUSSIAN);
        dropShadow2.setRadius(10);
        dropShadow2.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        deleteCustomerButton.setEffect(dropShadow2);
        // Increase the opacity of the shadow when the mouse is over the button
        deleteCustomerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow2.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        deleteCustomerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow2.setColor(Color.rgb(0, 0, 0, 0.5)));


        Button prizeGeneratorButton = new Button(" Prize Generator ", WinnerImage);
        prizeGeneratorButton.setPrefSize(200, 30);
        prizeGeneratorButton.setStyle(ButtonStyle2);
        WinnerImage.setFitWidth(50);
        WinnerImage.setFitHeight(50);
        // Add an effect to the button
        DropShadow dropShadow4 = new DropShadow();
        dropShadow4.setBlurType(BlurType.GAUSSIAN);
        dropShadow4.setRadius(10);
        dropShadow4.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        prizeGeneratorButton.setEffect(dropShadow4);
        // Increase the opacity of the shadow when the mouse is over the button
        prizeGeneratorButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow4.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        prizeGeneratorButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow4.setColor(Color.rgb(0, 0, 0, 0.5)));


        Button ExitButton = new Button("    Log Out          ", ExitImage);
        ExitButton.setPrefSize(200, 30);
        ExitButton.setStyle(ButtonStyle2);
        ExitImage.setFitHeight(50);
        ExitImage.setFitWidth(50);
        // Add an effect to the button
        DropShadow dropShadow5 = new DropShadow();
        dropShadow5.setBlurType(BlurType.GAUSSIAN);
        dropShadow5.setRadius(10);
        dropShadow5.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        ExitButton.setEffect(dropShadow5);
        // Increase the opacity of the shadow when the mouse is over the button
        ExitButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow5.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        ExitButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow5.setColor(Color.rgb(0, 0, 0, 0.5)));


        //Welcome, Image Of The Program

        AnchorPane.setLeftAnchor(v, 20.0);
        AnchorPane.setTopAnchor(v, 110.0);
        ImageView imageView = new ImageView(Pine);
        imageView.setFitWidth(250);
        imageView.setFitHeight(250);
        Label label = new Label("Welcome To Pine Operation System");
        label.setStyle(LabelStyle);
        VBox pineandlbel = new VBox(imageView, label);
        pineandlbel.setAlignment(Pos.CENTER);
        AnchorPane.setLeftAnchor(pineandlbel, 300.0);
        AnchorPane.setBottomAnchor(pineandlbel, 120.0);
        lap1.getChildren().addAll(pineandlbel);


        //Account Panel
        HBox Account = new HBox();
        ImageView AccountPanelImage = new ImageView(AccountPanel);
        AccountPanelImage.setFitHeight(30);
        AccountPanelImage.setFitWidth(30);
        Button userBtn = new Button("User Name", AccountPanelImage);
        userBtn.setStyle(ButtonStyle2);
        Account.getChildren().addAll(userBtn);
        Account.setStyle("-fx-padding: 10px;-fx-alignment: center-right");
        AnchorPane.setTopAnchor(Account, 10.0);
        AnchorPane.setRightAnchor(Account, 20.0);
        userBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        userBtn.setOnMouseEntered(event -> userBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(255,255,0,0.8), 10, 0, 0, 0);"));
        userBtn.setOnMouseExited(event -> userBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"));


        ToggleButton toggleButton1 = new ToggleButton("Customer Info");
        ToggleButton toggleButton2 = new ToggleButton("Promoter Info");

        // add buttons to toggle group
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton1.setStyle("-fx-background-radius: 50; -fx-text-fill: black;");
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton2.setStyle("-fx-background-radius: 50; -fx-text-fill: black;");
        // set first button as selected
        toggleButton1.setSelected(true);
        // add buttons to HBox
        HBox hbox = new HBox(toggleButton1, toggleButton2);
        hbox.setSpacing(10);
        AnchorPane.setTopAnchor(hbox, 30.0);
        AnchorPane.setRightAnchor(hbox, 150.0);


        v.getChildren().addAll(addCustomerButton, UpdateCustomerButton, deleteCustomerButton, prizeGeneratorButton, ExitButton);
        lap.getChildren().add(v);
        lap.getChildren().add(innerPane);
        mainAnchorPane.getChildren().addAll(lap, lap1, lap2);
        lap2.getChildren().addAll(Account, hbox);
        Scene zaid = new Scene(mainAnchorPane, 1100, 650);//Primary Scene

//==============================================================================================================

        //////Add gift From Admin Scene//////

//================================================================================================================
        ImageView PineImage8 = new ImageView(Pine);
        ImageView BackImage8 = new ImageView(Back);
        ImageView PrizeImage1 = new ImageView(price);

        //main Anchor
        AnchorPane mainAnchorPane4 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane Glap = new AnchorPane();
        Glap.setPrefWidth(350);
        Glap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(Glap, 0.0);
        AnchorPane.setTopAnchor(Glap, 0.0);
        AnchorPane.setBottomAnchor(Glap, 0.0);
        Button GSearchBtn = new Button("Search");
        GSearchBtn.setStyle(ButtonStyle);
        TextField GSearchTxt = new TextField();
        GSearchTxt.setPromptText("Enter Customer Id To Search For");
        HBox SearchHBox5 = new HBox(GSearchTxt, GSearchBtn);
        AnchorPane.setLeftAnchor(SearchHBox5, 0.0);
        AnchorPane.setTopAnchor(SearchHBox5, 110.0);
        AnchorPane.setBottomAnchor(SearchHBox5, 0.0);
        GSearchTxt.setPrefSize(230, 20);
        GSearchTxt.setStyle(TextFieldStyle);

        Button GBack = new Button("Back", BackImage8);
        GBack.setPrefSize(180, 30);
        GBack.setStyle(ButtonStyle);
        BackImage8.setFitWidth(60);
        BackImage8.setFitHeight(60);
        GBack.setOnAction(e -> stage.setScene(zaid));


        //Inner Anchor Put the inner anchor in the top left
        AnchorPane GInnerPane = new AnchorPane();
        GInnerPane.setPrefWidth(200);
        GInnerPane.setPrefHeight(100);
        GInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(GInnerPane, 0.0);
        AnchorPane.setTopAnchor(GInnerPane, 0.0);
        AnchorPane.setTopAnchor(GBack, 0.0);
        AnchorPane.setBottomAnchor(GBack, 0.0);
        AnchorPane.setLeftAnchor(GBack, 10.0);
        AnchorPane.setRightAnchor(GBack, 0.0);
        GInnerPane.getChildren().add(GBack);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane Glap1 = new AnchorPane();
        Glap1.setPrefWidth(450);
        Glap1.setPrefHeight(500);
        Glap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(Glap1, 300.0);
        AnchorPane.setTopAnchor(Glap1, 100.0);
        AnchorPane.setRightAnchor(Glap1, 0.0);
        AnchorPane.setBottomAnchor(Glap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane Glap2 = new AnchorPane();
        Glap2.setPrefWidth(600);
        Glap2.setPrefHeight(100);
        Glap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(Glap2, 200.0);
        AnchorPane.setTopAnchor(Glap2, 0.0);
        AnchorPane.setRightAnchor(Glap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage8, 400.0);
        AnchorPane.setTopAnchor(PineImage8, 10.0);
        AnchorPane.setRightAnchor(PineImage8, 0.0);
        Glap2.getChildren().add(PineImage8);
        PineImage8.setFitHeight(80);
        PineImage8.setFitWidth(80);


        //===========Table View===============

        TableView<Gift> Gtable = new TableView<>();
        AnchorPane.setLeftAnchor(Gtable, 0.0);
        AnchorPane.setTopAnchor(Gtable, 143.0);
        AnchorPane.setBottomAnchor(Gtable, 0.0);


        TableColumn<Gift, Integer> GidColumn = new TableColumn<>("GID");
        GidColumn.setCellValueFactory(new PropertyValueFactory<>("Gift id"));

        TableColumn<Gift, String> GnameColumn = new TableColumn<>("GName");
        GnameColumn.setCellValueFactory(new PropertyValueFactory<>("gift name"));


//        // Add columns to the table
//        Gtable.getColumns().addAll(GidColumn, GnameColumn);

        // Create a button with an image
        Button prizeButton1 = new Button();
        Image prizeImage1 = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\ProductSystem-DataBase\\src\\main\\java\\Photos\\winner.png");
        ImageView prizeImageView1 = new ImageView(prizeImage1);
        prizeImageView1.setFitHeight(80);
        prizeImageView1.setFitWidth(80);

        prizeButton1.setGraphic(prizeImageView1);
        prizeButton1.setStyle("-fx-min-width: 100; -fx-border-color: red; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        Label prizeLabel1 = new Label("Press to Win");
        prizeLabel1.setStyle(LabelStyle);
        String[] prizes1 = {"Extra Product", "Charger", "50Nis Coupon", "Mobile Stand", "Thermal Cup", "Car Label"};
        Label chosenPrize1 = new Label();
        chosenPrize1.setStyle(LabelStyle);

        VBox layout1 = new VBox(prizeLabel1, prizeButton1, chosenPrize1);
        layout1.setAlignment(Pos.CENTER);






        VBox Gv3 = new VBox(PrizeImage1, layout1);
        Gv3.setAlignment(Pos.CENTER);
        Gv3.setSpacing(40);
        AnchorPane.setLeftAnchor(Gv3, 180.0);
        AnchorPane.setTopAnchor(Gv3, 80.0);
        PrizeImage1.setFitWidth(80);
        PrizeImage1.setFitHeight(80);


        TableView<ObservableList<String>> GtableView = new TableView<>();
        AnchorPane.setLeftAnchor(GtableView, 0.0);
        AnchorPane.setTopAnchor(GtableView, 143.0);
        AnchorPane.setBottomAnchor(GtableView, 0.0);
        GtableView.setPrefWidth(250);
        Glap1.getChildren().add(Gv3);
        Glap.getChildren().addAll(GtableView, SearchHBox5);
        Glap.getChildren().add(GInnerPane);
        mainAnchorPane4.getChildren().addAll(Glap, Glap1, Glap2);
        Scene GScene = new Scene(mainAnchorPane4, 1100, 750);
        prizeGeneratorButton.setOnAction(e -> {
            stage.setScene(GScene);
            tableCreategift(GtableView);
        });//Add Gift Scene

        prizeButton1.setOnAction(e -> {
            // Choose a random prize
            int randomIndex1 = (int) (Math.random() * prizes1.length);
            String randomPrize1 = prizes1[randomIndex1];

            // Update the chosen prize label
            chosenPrize1.setText(randomPrize1 + " Gift ID:"+ ++Gi);

            addGift( Gi, randomPrize1);
            tableCreategift(GtableView);
        });
//============================================================================================================

        //Add Customer From Admin Scene//

//============================================================================================================
        ImageView PineImage1 = new ImageView(Pine);
        ImageView BackImage1 = new ImageView(Back);

        //main Anchor
        AnchorPane mainAnchorPane1 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane Addlap = new AnchorPane();
        Addlap.setPrefWidth(350);
        Addlap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(Addlap, 0.0);
        AnchorPane.setTopAnchor(Addlap, 0.0);
        AnchorPane.setBottomAnchor(Addlap, 0.0);
        Button SearchBtn = new Button("Search");
        SearchBtn.setStyle(ButtonStyle);
        TextField SearchTxt = new TextField();
        SearchTxt.setPromptText("Enter Customer Id To Search For");
        HBox SearchHBox = new HBox(SearchTxt, SearchBtn);
        AnchorPane.setLeftAnchor(SearchHBox, 0.0);
        AnchorPane.setTopAnchor(SearchHBox, 110.0);
        AnchorPane.setBottomAnchor(SearchHBox, 0.0);
        SearchTxt.setPrefSize(650, 20);
        SearchTxt.setStyle(TextFieldStyle);

        //Buttons ====================
        Button addCustomerButton1 = new Button("Add Customer");
        addCustomerButton1.setPrefSize(180, 30);
        addCustomerButton1.setStyle(ButtonStyle);

        Button AddBack = new Button("Back", BackImage1);
        AddBack.setPrefSize(180, 30);
        AddBack.setStyle(ButtonStyle);
        BackImage1.setFitWidth(60);
        BackImage1.setFitHeight(60);


        //Inner Anchor Put the inner anchor in the top left
        AnchorPane AddInnerPane = new AnchorPane();
        AddInnerPane.setPrefWidth(200);
        AddInnerPane.setPrefHeight(100);
        AddInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(AddInnerPane, 0.0);
        AnchorPane.setTopAnchor(AddInnerPane, 0.0);
        AnchorPane.setTopAnchor(AddBack, 0.0);
        AnchorPane.setBottomAnchor(AddBack, 0.0);
        AnchorPane.setLeftAnchor(AddBack, 10.0);
        AnchorPane.setRightAnchor(AddBack, 0.0);
        AddInnerPane.getChildren().add(AddBack);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane Addlap1 = new AnchorPane();
        Addlap1.setPrefWidth(450);
        Addlap1.setPrefHeight(500);
        Addlap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(Addlap1, 730.0);
        AnchorPane.setTopAnchor(Addlap1, 100.0);
        AnchorPane.setRightAnchor(Addlap1, 0.0);
        AnchorPane.setBottomAnchor(Addlap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane Addlap2 = new AnchorPane();
        Addlap2.setPrefWidth(600);
        Addlap2.setPrefHeight(100);
        Addlap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(Addlap2, 200.0);
        AnchorPane.setTopAnchor(Addlap2, 0.0);
        AnchorPane.setRightAnchor(Addlap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage1, 250.0);
        AnchorPane.setTopAnchor(PineImage1, 10.0);
        AnchorPane.setRightAnchor(PineImage1, 0.0);
        Addlap2.getChildren().add(PineImage1);
        PineImage1.setFitHeight(80);
        PineImage1.setFitWidth(80);

        Separator Addseparator1 = new Separator();
        Addseparator1.setStyle("-fx-background-color: black");
        Addseparator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(Addseparator1, 0.0);
        AnchorPane.setTopAnchor(Addseparator1, 100.0);
        AnchorPane.setRightAnchor(Addseparator1, 0.0);
        Addlap.getChildren().add(Addseparator1);



        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label AddLabel = new Label("Customer ID");
        Label AddLabel1 = new Label("Customer Name");
        Label AddLabel3 = new Label("Phone Number");
        Label AddLabel4 = new Label("Age");
        Label AddLabel5 = new Label("Gender");
        Label AddLabel7 = new Label("Promoter ID");
        Label AddLabel8 = new Label("Gift ID");
        AddLabel.setStyle(LabelStyle1);
        AddLabel1.setStyle(LabelStyle1);
        AddLabel3.setStyle(LabelStyle1);
        AddLabel4.setStyle(LabelStyle1);
        AddLabel5.setStyle(LabelStyle1);
        AddLabel7.setStyle(LabelStyle1);
        AddLabel8.setStyle(LabelStyle1);
        TextField AddTextField = new TextField();
        TextField AddTextField1 = new TextField();
        TextField AddTextField3 = new TextField();
        TextField AddTextField4 = new TextField();
        TextField AddTextField5 = new TextField();
        TextField AddTextField7 = new TextField();
        TextField AddTextField8 = new TextField();
        AddTextField.setStyle(TextFieldStyle);
        AddTextField1.setStyle(TextFieldStyle);
        AddTextField3.setStyle(TextFieldStyle);
        AddTextField4.setStyle(TextFieldStyle);
        AddTextField5.setStyle(TextFieldStyle);
        AddTextField7.setStyle(TextFieldStyle);
        AddTextField8.setStyle(TextFieldStyle);


        AddBack.setOnAction(e -> stage.setScene(zaid));
        gridPane.add(AddLabel, 0, 0);
        gridPane.add(AddLabel1, 0, 1);
        gridPane.add(AddLabel3, 0, 2);
        gridPane.add(AddLabel4, 0, 3);
        gridPane.add(AddLabel5, 0, 4);
        gridPane.add(AddLabel7, 0, 5);
        gridPane.add(AddLabel8, 0, 6);
        gridPane.add(AddTextField, 1, 0);
        gridPane.add(AddTextField1, 1, 1);
        gridPane.add(AddTextField3, 1, 2);
        gridPane.add(AddTextField4, 1, 3);
        gridPane.add(AddTextField5, 1, 4);
        gridPane.add(AddTextField7, 1, 5);
        gridPane.add(AddTextField8, 1, 6);


        VBox v1 = new VBox(AddStuImage1, gridPane, addCustomerButton1);
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(20);
        AnchorPane.setLeftAnchor(v1, 20.0);
        AnchorPane.setTopAnchor(v1, 20.0);
        AddStuImage1.setFitWidth(80);
        AddStuImage1.setFitHeight(80);


        TableView<ObservableList<String>> tableView = new TableView<>();
        AnchorPane.setLeftAnchor(tableView, 0.0);
        AnchorPane.setTopAnchor(tableView, 143.0);
        AnchorPane.setBottomAnchor(tableView, 0.0);
        tableView.setPrefWidth(700);

        Addlap1.getChildren().add(v1);

        Addlap.getChildren().addAll(tableView, SearchHBox);

        Addlap.getChildren().add(AddInnerPane);
        mainAnchorPane1.getChildren().addAll(Addlap, Addlap1, Addlap2);
        Scene AddScene = new Scene(mainAnchorPane1, 1100, 750);

        SearchBtn.setOnAction(e->{
            Customer c = searchCustomer(Integer.parseInt(SearchTxt.getText()));
            SearchTxt.setText(c.toString());
        });

        addCustomerButton.setOnAction(e -> {
            stage.setScene(AddScene);
            tableCreate(tableView);
        });//Add Customer Scene

        addCustomerButton1.setOnAction(e -> {
            // Insert the new customer into the database
            System.out.println(AddTextField.getText());
            insertCustomer(Integer.parseInt(AddTextField.getText()), AddTextField1.getText(), AddTextField3.getText(),
                    Integer.parseInt(AddTextField4.getText()), AddTextField5.getText(), Integer.parseInt(AddTextField8.getText()),
                    Integer.parseInt(AddTextField7.getText()));

            tableCreate(tableView);

            AddTextField.setText("");
            AddTextField3.setText("");
            AddTextField4.setText("");
            AddTextField5.setText("");
            AddTextField7.setText("");
            AddTextField8.setText("");
        });

//============================================================================================================//

                                  //Delete Customer //

//============================================================================================================//
        ImageView PineImage2 = new ImageView(Pine);
        ImageView BackImage2 = new ImageView(Back);

        //main Anchor
        AnchorPane mainAnchorPane2 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane Dlap = new AnchorPane();
        Dlap.setPrefWidth(350);
        Dlap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(Dlap, 0.0);
        AnchorPane.setTopAnchor(Dlap, 0.0);
        AnchorPane.setBottomAnchor(Dlap, 0.0);
        Button SearchBtn1 = new Button("Search");
        SearchBtn1.setStyle(ButtonStyle);
        TextField SearchTxt1 = new TextField();
        SearchTxt1.setPromptText("Enter Customer Id To Search For");
        HBox SearchHBox1 = new HBox(SearchTxt1, SearchBtn1);
        AnchorPane.setLeftAnchor(SearchHBox1, 0.0);
        AnchorPane.setTopAnchor(SearchHBox1, 110.0);
        AnchorPane.setBottomAnchor(SearchHBox1, 0.0);
        SearchTxt1.setPrefSize(650, 20);
        SearchTxt1.setStyle(TextFieldStyle);


        //Buttons ====================
        Button DeleteCustomerButton1 = new Button("Delete Customer");
        DeleteCustomerButton1.setPrefSize(180, 30);
        DeleteCustomerButton1.setStyle(ButtonStyle);

        Button DBack = new Button("Back", BackImage2);
        DBack.setPrefSize(180, 30);
        DBack.setStyle(ButtonStyle);
        BackImage2.setFitWidth(60);
        BackImage2.setFitHeight(60);

        //Inner Anchor Put the inner anchor in the top left
        AnchorPane DInnerPane = new AnchorPane();
        DInnerPane.setPrefWidth(200);
        DInnerPane.setPrefHeight(100);
        DInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(DInnerPane, 0.0);
        AnchorPane.setTopAnchor(DInnerPane, 0.0);
        AnchorPane.setTopAnchor(DBack, 0.0);
        AnchorPane.setBottomAnchor(DBack, 0.0);
        AnchorPane.setLeftAnchor(DBack, 10.0);
        AnchorPane.setRightAnchor(DBack, 0.0);
        DInnerPane.getChildren().add(DBack);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane Dlap1 = new AnchorPane();
        Dlap1.setPrefWidth(200);
        Dlap1.setPrefHeight(500);
        Dlap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(Dlap1, 730.0);
        AnchorPane.setTopAnchor(Dlap1, 100.0);
        AnchorPane.setRightAnchor(Dlap1, 0.0);
        AnchorPane.setBottomAnchor(Dlap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane Dlap2 = new AnchorPane();
        Dlap2.setPrefWidth(600);
        Dlap2.setPrefHeight(100);
        Dlap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(Dlap2, 200.0);
        AnchorPane.setTopAnchor(Dlap2, 0.0);
        AnchorPane.setRightAnchor(Dlap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage2, 250.0);
        AnchorPane.setTopAnchor(PineImage2, 10.0);
        AnchorPane.setRightAnchor(PineImage2, 0.0);
        Dlap2.getChildren().add(PineImage2);
        PineImage2.setFitHeight(80);
        PineImage2.setFitWidth(80);

        Separator Dseparator1 = new Separator();
        Dseparator1.setStyle("-fx-background-color: black");
        Dseparator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(Dseparator1, 0.0);
        AnchorPane.setTopAnchor(Dseparator1, 100.0);
        AnchorPane.setRightAnchor(Dseparator1, 0.0);
        Dlap.getChildren().add(Dseparator1);

        GridPane gridPane1 = new GridPane();
        gridPane1.setHgap(10);
        gridPane1.setVgap(10);
        Label DLabel = new Label("Customer ID");
        Label DLabel1 = new Label("Enter Customer ID, And See The   MAGIC");
        DLabel.setStyle(LabelStyle1);
        DLabel1.setStyle(LabelStyle1);
        TextField DTextField = new TextField();
        DTextField.setStyle(TextFieldStyle);


        DBack.setOnAction(e -> stage.setScene(zaid));
        gridPane1.add(DLabel, 0, 0);
        gridPane1.add(DTextField, 1, 0);

        VBox v2 = new VBox(DeleteStuImage1, DLabel1, gridPane1, DeleteCustomerButton1);
        v2.setAlignment(Pos.CENTER);
        v2.setSpacing(20);
        AnchorPane.setLeftAnchor(v2, 20.0);
        AnchorPane.setTopAnchor(v2, 40.0);
        DeleteStuImage1.setFitWidth(80);
        DeleteStuImage1.setFitHeight(80);

        TableView<ObservableList<String>> dtableView = new TableView<>();
        AnchorPane.setLeftAnchor(dtableView, 0.0);
        AnchorPane.setTopAnchor(dtableView, 143.0);
        AnchorPane.setBottomAnchor(dtableView, 0.0);


        Dlap1.getChildren().add(v2);
        Dlap.getChildren().addAll(dtableView, SearchHBox1);
        Dlap.getChildren().add(DInnerPane);
        mainAnchorPane2.getChildren().addAll(Dlap, Dlap1, Dlap2);
        Scene DScene = new Scene(mainAnchorPane2, 1100, 750);
        deleteCustomerButton.setOnAction(e ->
                {
                    stage.setScene(DScene);
                    tableCreate(dtableView);
                }

        );//Delete Customer Scene

        DeleteCustomerButton1.setOnAction(e -> {
            // Insert the new customer into the database
            System.out.println(DTextField.getText().toString());
            deleteCustomer(Integer.parseInt(DTextField.getText().toString()));
            tableCreate(dtableView);
            DTextField.setText("");

            /*Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/final", "chinthi", "1234");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM costumer");

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
                    int columnIndex = i - 1;
                    column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(columnIndex)));
                    dtableView.getColumns().add(column);                }

                ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(resultSet.getString(i));
                    }
                    data.add(row);
                }
                dtableView.setItems(data);


            } catch (SQLException ex) {
                ex.printStackTrace();
            }

             */


        });

//============================================================================================================//

        //Update Customer //

//============================================================================================================//
        ImageView PineImage3 = new ImageView(Pine);
        ImageView BackImage3 = new ImageView(Back);
        ImageView UpdateView1 = new ImageView(Update);

        //main Anchor
        AnchorPane mainAnchorPane3 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane Ulap = new AnchorPane();
        Ulap.setPrefWidth(350);
        Ulap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(Ulap, 0.0);
        AnchorPane.setTopAnchor(Ulap, 0.0);
        AnchorPane.setBottomAnchor(Ulap, 0.0);
        Button SearchBtn2 = new Button("Search");
        SearchBtn2.setStyle(ButtonStyle);
        TextField SearchTxt2 = new TextField();
        SearchTxt2.setPromptText("Enter Customer Id To Search For");
        HBox SearchHBox2 = new HBox(SearchTxt2, SearchBtn2);
        AnchorPane.setLeftAnchor(SearchHBox2, 0.0);
        AnchorPane.setTopAnchor(SearchHBox2, 110.0);
        AnchorPane.setBottomAnchor(SearchHBox2, 0.0);
        SearchTxt2.setPrefSize(680, 20);
        SearchTxt2.setStyle(TextFieldStyle);


        //Buttons ====================
        Button UpdateCustomerButton1 = new Button("Update Customer");
        UpdateCustomerButton1.setPrefSize(180, 30);
        UpdateCustomerButton1.setStyle(ButtonStyle);

        Button UBack = new Button("Back", BackImage3);
        UBack.setPrefSize(180, 30);
        UBack.setStyle(ButtonStyle);
        BackImage3.setFitWidth(60);
        BackImage3.setFitHeight(60);

        //Inner Anchor Put the inner anchor in the top left
        AnchorPane UInnerPane = new AnchorPane();
        UInnerPane.setPrefWidth(200);
        UInnerPane.setPrefHeight(100);
        UInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(UInnerPane, 0.0);
        AnchorPane.setTopAnchor(UInnerPane, 0.0);
        AnchorPane.setTopAnchor(UBack, 0.0);
        AnchorPane.setBottomAnchor(UBack, 0.0);
        AnchorPane.setLeftAnchor(UBack, 10.0);
        AnchorPane.setRightAnchor(UBack, 0.0);
        UInnerPane.getChildren().add(UBack);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane Ulap1 = new AnchorPane();
        Ulap1.setPrefWidth(450);
        Ulap1.setPrefHeight(500);
        Ulap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(Ulap1, 730.0);
        AnchorPane.setTopAnchor(Ulap1, 100.0);
        AnchorPane.setRightAnchor(Ulap1, 0.0);
        AnchorPane.setBottomAnchor(Ulap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane Ulap2 = new AnchorPane();
        Ulap2.setPrefWidth(600);
        Ulap2.setPrefHeight(100);
        Ulap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(Ulap2, 200.0);
        AnchorPane.setTopAnchor(Ulap2, 0.0);
        AnchorPane.setRightAnchor(Ulap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage3, 300.0);
        AnchorPane.setTopAnchor(PineImage3, 10.0);
        AnchorPane.setRightAnchor(PineImage3, 0.0);
        Ulap2.getChildren().add(PineImage3);
        PineImage3.setFitHeight(80);
        PineImage3.setFitWidth(80);

        Separator Useparator1 = new Separator();
        Useparator1.setStyle("-fx-background-color: black");
        Useparator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(Useparator1, 0.0);
        AnchorPane.setTopAnchor(Useparator1, 100.0);
        AnchorPane.setRightAnchor(Useparator1, 0.0);
        Ulap.getChildren().add(Useparator1);


        GridPane gridPane2 = new GridPane();
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);
        Label ULabel = new Label("Customer ID");
        Label ULabel1 = new Label("First Name");
        Label ULabel2 = new Label("Last Name");
        Label ULabel3 = new Label("Phone Number");
        Label ULabel4 = new Label("Age");
        Label ULabel5 = new Label("Gender");
        ULabel.setStyle(LabelStyle1);
        ULabel1.setStyle(LabelStyle1);
        ULabel2.setStyle(LabelStyle1);
        ULabel3.setStyle(LabelStyle1);
        ULabel4.setStyle(LabelStyle1);
        ULabel5.setStyle(LabelStyle1);
        TextField UTextField = new TextField();
        TextField UTextField1 = new TextField();
        TextField UTextField2 = new TextField();
        TextField UTextField3 = new TextField();
        TextField UTextField4 = new TextField();
        TextField UTextField5 = new TextField();
        UTextField.setStyle(TextFieldStyle);
        UTextField1.setStyle(TextFieldStyle);
        UTextField2.setStyle(TextFieldStyle);
        UTextField3.setStyle(TextFieldStyle);
        UTextField4.setStyle(TextFieldStyle);
        UTextField5.setStyle(TextFieldStyle);


        UBack.setOnAction(e -> stage.setScene(zaid));
        gridPane2.add(ULabel, 0, 0);
        gridPane2.add(ULabel1, 0, 1);
        gridPane2.add(ULabel2, 0, 2);
        gridPane2.add(ULabel3, 0, 3);
        gridPane2.add(ULabel4, 0, 4);
        gridPane2.add(ULabel5, 0, 5);
        gridPane2.add(UTextField, 1, 0);
        gridPane2.add(UTextField1, 1, 1);
        gridPane2.add(UTextField2, 1, 2);
        gridPane2.add(UTextField3, 1, 3);
        gridPane2.add(UTextField4, 1, 4);
        gridPane2.add(UTextField5, 1, 5);

        VBox v3 = new VBox(UpdateView1, gridPane2, UpdateCustomerButton1);
        v3.setAlignment(Pos.CENTER);
        v3.setSpacing(20);
        AnchorPane.setLeftAnchor(v3, 20.0);
        AnchorPane.setTopAnchor(v3, 40.0);
        UpdateView1.setFitWidth(80);
        UpdateView1.setFitHeight(80);


        TableView<ObservableList<String>> utableView = new TableView<>();
        AnchorPane.setLeftAnchor(utableView, 0.0);
        AnchorPane.setTopAnchor(utableView, 143.0);
        AnchorPane.setBottomAnchor(utableView, 0.0);

        Ulap1.getChildren().add(v3);
        Ulap.getChildren().addAll(utableView, SearchHBox2);
        Ulap.getChildren().add(UInnerPane);
        mainAnchorPane3.getChildren().addAll(Ulap, Ulap1, Ulap2);
        Scene UScene = new Scene(mainAnchorPane3, 1100, 750);
        UpdateCustomerButton.setOnAction(e -> {
            stage.setScene(UScene);
            tableCreate(utableView);
        });//Update Customer Scene

        UpdateCustomerButton1.setOnAction(e -> {
            // Insert the new customer into the database
            System.out.println(UTextField.getText().toString());
            updateCustomer(Integer.parseInt(UTextField.getText().toString()), UTextField1.getText().toString(), UTextField3.getText().toString(),
                    Integer.parseInt(UTextField4.getText().toString()), UTextField5.getText().toString());

            tableCreate(utableView);

            UTextField.setText("");
            UTextField1.setText("");
            UTextField2.setText("");
            UTextField3.setText("");
            UTextField4.setText("");
            UTextField5.setText("");
        });


//==============================================================================================================

        //////Operations on Promoter from Admin Scene//////

//================================================================================================================
        ImageView zaidScenImage2 = new ImageView(zaidScene);
        ImageView AddStuImage2 = new ImageView(AddStu);
        ImageView ExitImage2 = new ImageView(Exit);
        ImageView DeleteStuImage2 = new ImageView(DeleteStu);
        ImageView UpdateView3 = new ImageView(Update);


        //main Anchor
        AnchorPane PromoterAnchorPane = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane Plap = new AnchorPane();
        Plap.setPrefWidth(200);
        Plap.setPrefHeight(500);
        Plap.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(Plap, 0.0);
        AnchorPane.setTopAnchor(Plap, 0.0);
        AnchorPane.setBottomAnchor(Plap, 0.0);

        //Inner Anchor Put the inner anchor in the top left
        AnchorPane PinnerPane = new AnchorPane();
        PinnerPane.setPrefWidth(200);
        PinnerPane.setPrefHeight(100);
        PinnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(PinnerPane, 0.0);
        AnchorPane.setTopAnchor(PinnerPane, 0.0);
        Label pineAdministration4 = new Label("Pine Administration");
        pineAdministration4.setStyle(LabelStyle);
        AnchorPane.setTopAnchor(pineAdministration4, 0.0);
        AnchorPane.setBottomAnchor(pineAdministration4, 0.0);
        AnchorPane.setLeftAnchor(pineAdministration4, 25.0);
        AnchorPane.setRightAnchor(pineAdministration4, 0.0);

        PinnerPane.getChildren().add(pineAdministration4);
        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane Plap1 = new AnchorPane(zaidScenImage2);
        Plap1.setPrefWidth(600);
        Plap1.setPrefHeight(500);
        zaidScenImage2.setFitWidth(600);
        zaidScenImage2.setFitHeight(500);
        AnchorPane.setLeftAnchor(Plap1, 200.0);
        AnchorPane.setTopAnchor(Plap1, 100.0);
        AnchorPane.setRightAnchor(Plap1, 0.0);
        AnchorPane.setBottomAnchor(Plap1, 0.0);
        AnchorPane.setLeftAnchor(zaidScenImage2, 25.0);
        AnchorPane.setTopAnchor(zaidScenImage2, 0.0);
        AnchorPane.setRightAnchor(zaidScenImage2, 0.0);
        AnchorPane.setBottomAnchor(zaidScenImage2, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane Plap2 = new AnchorPane();
        Plap2.setPrefWidth(600);
        Plap2.setPrefHeight(100);
        Plap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(Plap2, 200.0);
        AnchorPane.setTopAnchor(Plap2, 0.0);
        AnchorPane.setRightAnchor(Plap2, 0.0);

        Separator Pseparator1 = new Separator();
        Pseparator1.setStyle("-fx-background-color: black");
        Pseparator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(Pseparator1, 0.0);
        AnchorPane.setTopAnchor(Pseparator1, 100.0);
        AnchorPane.setRightAnchor(Pseparator1, 0.0);
        Plap.getChildren().add(Pseparator1);

        Separator Pseparator2 = new Separator();
        Pseparator2.setOrientation(Orientation.VERTICAL);
        Pseparator2.setPrefHeight(100);
        Pseparator2.setStyle("-fx-background-color: black");
        AnchorPane.setLeftAnchor(Pseparator2, 200.0);
        AnchorPane.setTopAnchor(Pseparator2, 0.0);
        AnchorPane.setBottomAnchor(Pseparator2, 0.0);
        PromoterAnchorPane.getChildren().add(Pseparator2);

        VBox Pv = new VBox();
        Pv.setAlignment(Pos.CENTER_LEFT);
        Pv.setSpacing(20);


        Button PaddCustomerButton = new Button("  Add Promoter", AddStuImage2);
        PaddCustomerButton.setPrefSize(200, 30);
        PaddCustomerButton.setStyle(ButtonStyle2);
        AddStuImage2.setFitWidth(50);
        AddStuImage2.setFitHeight(50);
        // Add an effect to the button
        DropShadow dropShadow6 = new DropShadow();
        dropShadow6.setBlurType(BlurType.GAUSSIAN);
        dropShadow6.setRadius(10);
        dropShadow6.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        PaddCustomerButton.setEffect(dropShadow6);
        // Increase the opacity of the shadow when the mouse is over the button
        PaddCustomerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow6.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        PaddCustomerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow6.setColor(Color.rgb(0, 0, 0, 0.5)));

        Button PUpdateCustomerButton = new Button("Update Promoter ", UpdateView3);
        PUpdateCustomerButton.setPrefSize(200, 30);
        PUpdateCustomerButton.setStyle(ButtonStyle2);
        UpdateView3.setFitHeight(50);
        UpdateView3.setFitWidth(50);
        // Add an effect to the button
        DropShadow dropShadow7 = new DropShadow();
        dropShadow7.setBlurType(BlurType.GAUSSIAN);
        dropShadow7.setRadius(10);
        dropShadow7.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        PUpdateCustomerButton.setEffect(dropShadow7);
        // Increase the opacity of the shadow when the mouse is over the button
        PUpdateCustomerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow7.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        PUpdateCustomerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow7.setColor(Color.rgb(0, 0, 0, 0.5)));


        Button PdeleteCustomerButton = new Button("Delete Promoter", DeleteStuImage2);
        PdeleteCustomerButton.setPrefSize(200, 30);
        PdeleteCustomerButton.setStyle(ButtonStyle2);
        DeleteStuImage2.setFitWidth(50);
        DeleteStuImage2.setFitHeight(50);
        // Add an effect to the button
        DropShadow dropShadow9 = new DropShadow();
        dropShadow9.setBlurType(BlurType.GAUSSIAN);
        dropShadow9.setRadius(10);
        dropShadow9.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        PdeleteCustomerButton.setEffect(dropShadow9);
        // Increase the opacity of the shadow when the mouse is over the button
        PdeleteCustomerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow9.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        PdeleteCustomerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow9.setColor(Color.rgb(0, 0, 0, 0.5)));


        Button PExitButton = new Button("    Log Out          ", ExitImage2);
        PExitButton.setPrefSize(200, 30);
        PExitButton.setStyle(ButtonStyle2);
        ExitImage2.setFitHeight(50);
        ExitImage2.setFitWidth(50);
        // Add an effect to the button
        DropShadow dropShadow8 = new DropShadow();
        dropShadow8.setBlurType(BlurType.GAUSSIAN);
        dropShadow8.setRadius(10);
        dropShadow8.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        PExitButton.setEffect(dropShadow8);
        // Increase the opacity of the shadow when the mouse is over the button
        PExitButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow8.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        PExitButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow8.setColor(Color.rgb(0, 0, 0, 0.5)));


        //Welcome, Image Of The Program
        AnchorPane.setLeftAnchor(Pv, 20.0);
        AnchorPane.setTopAnchor(Pv, 110.0);
        ImageView imageView2 = new ImageView(Pine);
        imageView2.setFitWidth(250);
        imageView2.setFitHeight(250);
        AnchorPane.setRightAnchor(imageView2, 180.0);
        AnchorPane.setTopAnchor(imageView2, 100.0);
        Label Plabel = new Label("Welcome To Pine Operation System");
        Plabel.setStyle(LabelStyle);
        AnchorPane.setLeftAnchor(Plabel, 140.0);
        AnchorPane.setBottomAnchor(Plabel, 120.0);
        GridPane Pgrid = new GridPane();
        Pgrid.setVgap(10);
        Pgrid.setHgap(10);
        Pgrid.add(imageView2, 0, 0);
        Pgrid.add(Plabel, 0, 1);
        AnchorPane.setRightAnchor(Pgrid, 130.0);
        AnchorPane.setTopAnchor(Pgrid, 100.0);
        Plap1.getChildren().addAll(Pgrid);


        //Account Panel
        HBox PAccount = new HBox();
        ImageView AccountPanelImage2 = new ImageView(AccountPanel);
        AccountPanelImage2.setFitHeight(30);
        AccountPanelImage2.setFitWidth(30);
        Button PuserBtn = new Button("User Name", AccountPanelImage2);
        PuserBtn.setStyle(ButtonStyle2);
        PAccount.getChildren().addAll(PuserBtn);
        PAccount.setStyle("-fx-padding: 10px;-fx-alignment: center-right");
        AnchorPane.setTopAnchor(PAccount, 10.0);
        AnchorPane.setRightAnchor(PAccount, 20.0);
        PuserBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        PuserBtn.setOnMouseEntered(event -> PuserBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(255,255,0,0.8), 10, 0, 0, 0);"));
        PuserBtn.setOnMouseExited(event -> PuserBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"));


        ToggleButton PtoggleButton1 = new ToggleButton("Customer Info");
        ToggleButton PtoggleButton2 = new ToggleButton("Promoter Info");

        // add buttons to toggle group
        ToggleGroup PtoggleGroup = new ToggleGroup();
        PtoggleButton1.setToggleGroup(PtoggleGroup);
        PtoggleButton1.setStyle("-fx-background-radius: 50; -fx-text-fill: black;");
        PtoggleButton2.setToggleGroup(PtoggleGroup);
        PtoggleButton2.setStyle("-fx-background-radius: 50; -fx-text-fill: black;");
        // set first button as selected
        PtoggleButton1.setSelected(true);
        // add buttons to HBox
        HBox Phbox = new HBox(PtoggleButton1, PtoggleButton2);
        Phbox.setSpacing(10);
        AnchorPane.setTopAnchor(Phbox, 30.0);
        AnchorPane.setRightAnchor(Phbox, 150.0);
        PExitButton.setOnAction(e -> {
            stage.setScene(scene);
            PtoggleButton1.setSelected(true);
            usernameTextField.setText("");
            passwordField.setText("");
        });


        Pv.getChildren().addAll(PaddCustomerButton, PUpdateCustomerButton, PdeleteCustomerButton, PExitButton);
        Plap.getChildren().add(Pv);
        Plap.getChildren().add(PinnerPane);
        PromoterAnchorPane.getChildren().addAll(Plap, Plap1, Plap2);
        Plap2.getChildren().addAll(PAccount, Phbox);
        Scene Pzaid = new Scene(PromoterAnchorPane, 800, 600);//Primary Scene
        PtoggleButton1.setOnAction(e -> stage.setScene(zaid));
        PtoggleButton2.setOnAction(e -> stage.setScene(Pzaid));
        toggleButton2.setOnAction(e -> {//هاي الكبسة موجودة بالسين تاع الادمن
            stage.setScene(Pzaid);
        });


//============================================================================================================

                       //Add Promoter From Admin Scene//

//============================================================================================================
        ImageView PineImage4 = new ImageView(Pine);
        ImageView BackImage4 = new ImageView(Back);
        ImageView AddP = new ImageView(AddStu);

        //main Anchor
        AnchorPane PromoterAnchorPane1 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane AddPlap = new AnchorPane();
        AddPlap.setPrefWidth(350);
        AddPlap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(AddPlap, 0.0);
        AnchorPane.setTopAnchor(AddPlap, 0.0);
        AnchorPane.setBottomAnchor(AddPlap, 0.0);
        Button SearchBtn5 = new Button("Search");
        SearchBtn5.setStyle(ButtonStyle);
        TextField SearchTxt5 = new TextField();
        SearchTxt5.setPromptText("Enter Customer Id To Search For");
        HBox SearchPHBox1 = new HBox(SearchTxt5, SearchBtn5);
        AnchorPane.setLeftAnchor(SearchPHBox1, 0.0);
        AnchorPane.setTopAnchor(SearchPHBox1, 110.0);
        AnchorPane.setBottomAnchor(SearchPHBox1, 0.0);
        SearchTxt5.setPrefSize(400, 20);
        SearchTxt5.setStyle(TextFieldStyle);

        //Buttons ====================
        Button addPromoterButton1 = new Button("Add Promoter");
        addPromoterButton1.setPrefSize(180, 30);
        addPromoterButton1.setStyle(ButtonStyle);

        Button AddBack2 = new Button("Back", BackImage4);
        AddBack2.setPrefSize(180, 30);
        AddBack2.setStyle(ButtonStyle);
        BackImage4.setFitWidth(60);
        BackImage4.setFitHeight(60);


        //Inner Anchor Put the inner anchor in the top left
        AnchorPane AddPInnerPane = new AnchorPane();
        AddPInnerPane.setPrefWidth(200);
        AddPInnerPane.setPrefHeight(100);
        AddPInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(AddPInnerPane, 0.0);
        AnchorPane.setTopAnchor(AddPInnerPane, 0.0);
        AnchorPane.setTopAnchor(AddBack2, 0.0);
        AnchorPane.setBottomAnchor(AddBack2, 0.0);
        AnchorPane.setLeftAnchor(AddBack2, 10.0);
        AnchorPane.setRightAnchor(AddBack2, 0.0);
        AddPInnerPane.getChildren().add(AddBack2);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane AddPlap1 = new AnchorPane();
        AddPlap1.setPrefWidth(450);
        AddPlap1.setPrefHeight(500);
        AddPlap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(AddPlap1, 480.0);
        AnchorPane.setTopAnchor(AddPlap1, 100.0);
        AnchorPane.setRightAnchor(AddPlap1, 0.0);
        AnchorPane.setBottomAnchor(AddPlap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane AddPlap2 = new AnchorPane();
        AddPlap2.setPrefWidth(600);
        AddPlap2.setPrefHeight(100);
        AddPlap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(AddPlap2, 200.0);
        AnchorPane.setTopAnchor(AddPlap2, 0.0);
        AnchorPane.setRightAnchor(AddPlap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage4, 130.0);
        AnchorPane.setTopAnchor(PineImage4, 10.0);
        AnchorPane.setRightAnchor(PineImage4, 0.0);
        AddPlap2.getChildren().add(PineImage4);
        PineImage4.setFitHeight(80);
        PineImage4.setFitWidth(80);

        Separator AddPseparator1 = new Separator();
        AddPseparator1.setStyle("-fx-background-color: black");
        AddPseparator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(AddPseparator1, 0.0);
        AnchorPane.setTopAnchor(AddPseparator1, 100.0);
        AnchorPane.setRightAnchor(AddPseparator1, 0.0);
        AddPlap.getChildren().add(AddPseparator1);

        GridPane PgridPane = new GridPane();
        PgridPane.setHgap(10);
        PgridPane.setVgap(10);
        Label AddPLabel = new Label("Promoter ID");
        Label AddPLabel1 = new Label("Name");
        Label AddPLabel2 = new Label("Phone");
        Label AddPLabel3 = new Label("Age");
        Label AddPLabel4 = new Label("Gender");
        Label AddPLabel5 = new Label("Username");
        Label AddPLabel6 = new Label("Password");
        AddPLabel.setStyle(LabelStyle1);
        AddPLabel1.setStyle(LabelStyle1);
        AddPLabel2.setStyle(LabelStyle1);
        AddPLabel3.setStyle(LabelStyle1);
        AddPLabel4.setStyle(LabelStyle1);
        AddPLabel5.setStyle(LabelStyle1);
        AddPLabel6.setStyle(LabelStyle1);
        TextField AddPTextField = new TextField();
        TextField AddPTextField1 = new TextField();
        TextField AddPTextField2 = new TextField();
        TextField AddPTextField3 = new TextField();
        TextField AddPTextField4 = new TextField();
        TextField AddPTextField5 = new TextField();
        TextField AddPTextField6 = new TextField();
        AddPTextField.setStyle(TextFieldStyle);
        AddPTextField1.setStyle(TextFieldStyle);
        AddPTextField2.setStyle(TextFieldStyle);
        AddPTextField3.setStyle(TextFieldStyle);
        AddPTextField4.setStyle(TextFieldStyle);
        AddPTextField5.setStyle(TextFieldStyle);
        AddPTextField6.setStyle(TextFieldStyle);

        AddBack2.setOnAction(e -> stage.setScene(Pzaid));
        PgridPane.add(AddPLabel, 0, 0);
        PgridPane.add(AddPLabel1, 0, 1);
        PgridPane.add(AddPLabel2, 0, 2);
        PgridPane.add(AddPLabel3, 0, 3);
        PgridPane.add(AddPLabel4, 0, 4);
        PgridPane.add(AddPLabel5, 0, 5);
        PgridPane.add(AddPLabel6, 0, 6);
        PgridPane.add(AddPTextField, 1, 0);
        PgridPane.add(AddPTextField1, 1, 1);
        PgridPane.add(AddPTextField2, 1, 2);
        PgridPane.add(AddPTextField3, 1, 3);
        PgridPane.add(AddPTextField4, 1, 4);
        PgridPane.add(AddPTextField5, 1, 5);
        PgridPane.add(AddPTextField6, 1, 6);

        VBox Pv1 = new VBox(AddP, PgridPane, addPromoterButton1);
        Pv1.setAlignment(Pos.CENTER);
        Pv1.setSpacing(20);
        AnchorPane.setLeftAnchor(Pv1, 20.0);
        AnchorPane.setTopAnchor(Pv1, 40.0);
        AddP.setFitWidth(80);
        AddP.setFitHeight(80);

        TableView<ObservableList<String>> promoterAtableView = new TableView<>();
        AnchorPane.setLeftAnchor(promoterAtableView, 0.0);
        AnchorPane.setTopAnchor(promoterAtableView, 143.0);
        AnchorPane.setBottomAnchor(promoterAtableView, 0.0);

        SearchBtn5.setOnAction(e->{
            Promoter p = SearchPromoter(Integer.parseInt(SearchTxt5.getText()));
            SearchTxt5.setText(p.toString());
        });

        AddPlap1.getChildren().add(Pv1);
        AddPlap.getChildren().addAll(promoterAtableView, SearchPHBox1);
        AddPlap.getChildren().add(AddPInnerPane);
        PromoterAnchorPane1.getChildren().addAll(AddPlap, AddPlap1, AddPlap2);
        Scene AddPScene = new Scene(PromoterAnchorPane1, 800, 600);
        PaddCustomerButton.setOnAction(e ->
                {
                    stage.setScene(AddPScene);
                    tableCreatePromoter(promoterAtableView);
                }
        );//Add Promoter Scene

        addPromoterButton1.setOnAction(e -> {
            // Insert the new customer into the database
            System.out.println(AddPTextField.getText().toString());
            addPromoter(Integer.parseInt(AddPTextField.getText().toString()), AddPTextField1.getText().toString(), AddPTextField2.getText().toString(),
                    Integer.parseInt(AddPTextField3.getText().toString()), AddPTextField4.getText().toString(),
                    AddPTextField5.getText().toString(), AddPTextField6.getText().toString());

            tableCreatePromoter(promoterAtableView);
            AddPTextField1.setText("");
            AddPTextField2.setText("");
            AddPTextField3.setText("");
            AddPTextField4.setText("");
            AddPTextField5.setText("");
            AddPTextField6.setText("");
            AddPTextField.setText("");
        });

//============================================================================================================//

                          //Delete Promoter From Admin Scene  //

//============================================================================================================//
        ImageView PineImage5 = new ImageView(Pine);
        ImageView BackImage5 = new ImageView(Back);
        ImageView DeleteImage5 = new ImageView(DeleteStu);

        //main Anchor
        AnchorPane PromoterAnchorPane2 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane DPlap = new AnchorPane();
        DPlap.setPrefWidth(350);
        DPlap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(DPlap, 0.0);
        AnchorPane.setTopAnchor(DPlap, 0.0);
        AnchorPane.setBottomAnchor(DPlap, 0.0);
        Button SearchBtn3 = new Button("Search");
        SearchBtn3.setStyle(ButtonStyle);
        TextField SearchTxt3 = new TextField();
        SearchTxt3.setPromptText("Enter Promoter Id To Search For");
        HBox SearchHBox3 = new HBox(SearchTxt3, SearchBtn3);
        AnchorPane.setLeftAnchor(SearchHBox3, 0.0);
        AnchorPane.setTopAnchor(SearchHBox3, 110.0);
        AnchorPane.setBottomAnchor(SearchHBox3, 0.0);
        SearchTxt3.setPrefSize(400, 20);
        SearchTxt3.setStyle(TextFieldStyle);


        //Buttons ====================
        Button DeletePromotersButton1 = new Button("Delete Promoter");
        DeletePromotersButton1.setPrefSize(180, 30);
        DeletePromotersButton1.setStyle(ButtonStyle);

        Button DBack1 = new Button("Back", BackImage5);//Confermation of deletion
        DBack1.setPrefSize(180, 30);
        DBack1.setStyle(ButtonStyle);
        BackImage5.setFitWidth(60);
        BackImage5.setFitHeight(60);

        //Inner Anchor Put the inner anchor in the top left
        AnchorPane DPInnerPane = new AnchorPane();
        DPInnerPane.setPrefWidth(200);
        DPInnerPane.setPrefHeight(100);
        DPInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(DPInnerPane, 0.0);
        AnchorPane.setTopAnchor(DPInnerPane, 0.0);
        AnchorPane.setTopAnchor(DBack1, 0.0);
        AnchorPane.setBottomAnchor(DBack1, 0.0);
        AnchorPane.setLeftAnchor(DBack1, 10.0);
        AnchorPane.setRightAnchor(DBack1, 0.0);
        DPInnerPane.getChildren().add(DBack1);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane DPlap1 = new AnchorPane();
        DPlap1.setPrefWidth(450);
        DPlap1.setPrefHeight(500);
        DPlap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(DPlap1, 480.0);
        AnchorPane.setTopAnchor(DPlap1, 100.0);
        AnchorPane.setRightAnchor(DPlap1, 0.0);
        AnchorPane.setBottomAnchor(DPlap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane DPlap2 = new AnchorPane();
        DPlap2.setPrefWidth(600);
        DPlap2.setPrefHeight(100);
        DPlap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(DPlap2, 200.0);
        AnchorPane.setTopAnchor(DPlap2, 0.0);
        AnchorPane.setRightAnchor(DPlap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage5, 130.0);
        AnchorPane.setTopAnchor(PineImage5, 10.0);
        AnchorPane.setRightAnchor(PineImage5, 0.0);
        DPlap2.getChildren().add(PineImage5);
        PineImage5.setFitHeight(80);
        PineImage5.setFitWidth(80);

        Separator DPseparator1 = new Separator();
        DPseparator1.setStyle("-fx-background-color: black");
        DPseparator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(DPseparator1, 0.0);
        AnchorPane.setTopAnchor(DPseparator1, 100.0);
        AnchorPane.setRightAnchor(DPseparator1, 0.0);
        DPlap.getChildren().add(DPseparator1);


        GridPane DPgridPane = new GridPane();
        DPgridPane.setHgap(10);
        DPgridPane.setVgap(10);
        Label DPLabel = new Label("Promoter ID");
        DPLabel.setStyle(LabelStyle1);
        TextField DPTextField = new TextField();
        DPTextField.setStyle(TextFieldStyle);


        DBack1.setOnAction(e -> stage.setScene(Pzaid));
        DPgridPane.add(DPLabel, 0, 0);
        DPgridPane.add(DPTextField, 1, 0);

        VBox Pv2 = new VBox(DeleteImage5, DPgridPane, DeletePromotersButton1);
        Pv2.setAlignment(Pos.CENTER);
        Pv2.setSpacing(20);
        AnchorPane.setLeftAnchor(Pv2, 20.0);
        AnchorPane.setTopAnchor(Pv2, 40.0);
        DeleteImage5.setFitWidth(80);
        DeleteImage5.setFitHeight(80);

        TableView<ObservableList<String>> promoterDtableView = new TableView<>();
        AnchorPane.setLeftAnchor(promoterDtableView, 0.0);
        AnchorPane.setTopAnchor(promoterDtableView, 143.0);
        AnchorPane.setBottomAnchor(promoterDtableView, 0.0);

        DPlap1.getChildren().add(Pv2);
        DPlap.getChildren().addAll(promoterDtableView, SearchHBox3);
        DPlap.getChildren().add(DPInnerPane);
        PromoterAnchorPane2.getChildren().addAll(DPlap, DPlap1, DPlap2);
        Scene DPScene = new Scene(PromoterAnchorPane2, 800, 600);
        PdeleteCustomerButton.setOnAction(e ->
                {
                    stage.setScene(DPScene);
                    tableCreatePromoter(promoterDtableView);
                }

        );//Delete Promoter Scene

        DeletePromotersButton1.setOnAction(e -> {
            // Insert the new customer into the database
            System.out.println(DPTextField.getText().toString());
            deletePromoter(Integer.parseInt(DPTextField.getText().toString()));
            tableCreatePromoter(promoterDtableView);
            DPTextField.setText("");

        });
//============================================================================================================//

        //Update Promoter From Admin Scene//

//============================================================================================================//
        ImageView PineImage6 = new ImageView(Pine);
        ImageView BackImage6 = new ImageView(Back);
        ImageView UpdateView6 = new ImageView(Update);

        //main Anchor
        AnchorPane PromoterAnchorPane3 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane UPlap = new AnchorPane();
        UPlap.setPrefWidth(350);
        UPlap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(UPlap, 0.0);
        AnchorPane.setTopAnchor(UPlap, 0.0);
        AnchorPane.setBottomAnchor(UPlap, 0.0);
        Button SearchBtn4 = new Button("Search");
        SearchBtn4.setStyle(ButtonStyle);
        TextField SearchTxt4 = new TextField();
        SearchTxt4.setPromptText("Enter Customer Id To Search For");
        HBox SearchHBox4 = new HBox(SearchTxt4, SearchBtn4);
        AnchorPane.setLeftAnchor(SearchHBox4, 0.0);
        AnchorPane.setTopAnchor(SearchHBox4, 110.0);
        AnchorPane.setBottomAnchor(SearchHBox4, 0.0);
        SearchTxt4.setPrefSize(400, 20);
        SearchTxt4.setStyle(TextFieldStyle);


        //Buttons ====================
        Button UpdatePromoterButton = new Button("Update Promoter");
        UpdatePromoterButton.setPrefSize(180, 30);
        UpdatePromoterButton.setStyle(ButtonStyle);

        Button UBack1 = new Button("Back", BackImage6);
        UBack1.setPrefSize(180, 30);
        UBack1.setStyle(ButtonStyle);
        BackImage6.setFitWidth(60);
        BackImage6.setFitHeight(60);

        //Inner Anchor Put the inner anchor in the top left
        AnchorPane UPInnerPane = new AnchorPane();
        UPInnerPane.setPrefWidth(200);
        UPInnerPane.setPrefHeight(100);
        UPInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(UPInnerPane, 0.0);
        AnchorPane.setTopAnchor(UPInnerPane, 0.0);
        AnchorPane.setTopAnchor(UBack1, 0.0);
        AnchorPane.setBottomAnchor(UBack1, 0.0);
        AnchorPane.setLeftAnchor(UBack1, 10.0);
        AnchorPane.setRightAnchor(UBack1, 0.0);
        UPInnerPane.getChildren().add(UBack1);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane UPlap1 = new AnchorPane();
        UPlap1.setPrefWidth(450);
        UPlap1.setPrefHeight(500);
        UPlap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(UPlap1, 480.0);
        AnchorPane.setTopAnchor(UPlap1, 100.0);
        AnchorPane.setRightAnchor(UPlap1, 0.0);
        AnchorPane.setBottomAnchor(UPlap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane UPlap2 = new AnchorPane();
        UPlap2.setPrefWidth(600);
        UPlap2.setPrefHeight(100);
        UPlap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(UPlap2, 200.0);
        AnchorPane.setTopAnchor(UPlap2, 0.0);
        AnchorPane.setRightAnchor(UPlap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage6, 130.0);
        AnchorPane.setTopAnchor(PineImage5, 10.0);
        AnchorPane.setRightAnchor(PineImage6, 0.0);
        UPlap2.getChildren().add(PineImage6);
        PineImage6.setFitHeight(80);
        PineImage6.setFitWidth(80);

        Separator UPseparator1 = new Separator();
        UPseparator1.setStyle("-fx-background-color: black");
        UPseparator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(UPseparator1, 0.0);
        AnchorPane.setTopAnchor(UPseparator1, 100.0);
        AnchorPane.setRightAnchor(UPseparator1, 0.0);
        UPlap.getChildren().add(UPseparator1);

        GridPane UPgridPane = new GridPane();
        UPgridPane.setHgap(10);
        UPgridPane.setVgap(10);
        Label UPLabel = new Label("Promoter ID");
        Label UPLabel1 = new Label("Name");
        Label UPLabel2 = new Label("Phone");
        Label UPLabel3 = new Label("Age");
        Label UPLabel4 = new Label("Gender");
        Label UPLabel5 = new Label("Username");
        Label UPLabel6 = new Label("Password");
        UPLabel.setStyle(LabelStyle1);
        UPLabel1.setStyle(LabelStyle1);
        UPLabel2.setStyle(LabelStyle1);
        UPLabel3.setStyle(LabelStyle1);
        UPLabel4.setStyle(LabelStyle1);
        UPLabel5.setStyle(LabelStyle1);
        UPLabel6.setStyle(LabelStyle1);
        TextField UPTextField = new TextField();
        TextField UPTextField1 = new TextField();
        TextField UPTextField2 = new TextField();
        TextField UPTextField3 = new TextField();
        TextField UPTextField4 = new TextField();
        TextField UPTextField5 = new TextField();
        TextField UPTextField6 = new TextField();
        UPTextField.setStyle(TextFieldStyle);
        UPTextField1.setStyle(TextFieldStyle);
        UPTextField2.setStyle(TextFieldStyle);
        UPTextField3.setStyle(TextFieldStyle);
        UPTextField4.setStyle(TextFieldStyle);
        UPTextField5.setStyle(TextFieldStyle);
        UPTextField6.setStyle(TextFieldStyle);

        UBack1.setOnAction(e -> stage.setScene(Pzaid));
        UPgridPane.add(UPLabel, 0, 0);
        UPgridPane.add(UPLabel1, 0, 1);
        UPgridPane.add(UPLabel2, 0, 2);
        UPgridPane.add(UPLabel3, 0, 3);
        UPgridPane.add(UPLabel4, 0, 4);
        UPgridPane.add(UPLabel5, 0, 5);
        UPgridPane.add(UPLabel6, 0, 6);
        UPgridPane.add(UPTextField, 1, 0);
        UPgridPane.add(UPTextField1, 1, 1);
        UPgridPane.add(UPTextField2, 1, 2);
        UPgridPane.add(UPTextField3, 1, 3);
        UPgridPane.add(UPTextField4, 1, 4);
        UPgridPane.add(UPTextField5, 1, 5);
        UPgridPane.add(UPTextField6, 1, 6);
        VBox Pv3 = new VBox(UpdateView6, UPgridPane, UpdatePromoterButton);
        Pv3.setAlignment(Pos.CENTER);
        Pv3.setSpacing(20);
        AnchorPane.setLeftAnchor(Pv3, 20.0);
        AnchorPane.setTopAnchor(Pv3, 40.0);
        UpdateView6.setFitWidth(80);
        UpdateView6.setFitHeight(80);

        TableView<ObservableList<String>> promoterUtableView = new TableView<>();
        AnchorPane.setLeftAnchor(promoterUtableView, 0.0);
        AnchorPane.setTopAnchor(promoterUtableView, 143.0);
        AnchorPane.setBottomAnchor(promoterUtableView, 0.0);

        UPlap1.getChildren().add(Pv3);
        UPlap.getChildren().addAll(promoterUtableView, SearchHBox4);
        UPlap.getChildren().add(UPInnerPane);
        PromoterAnchorPane3.getChildren().addAll(UPlap, UPlap1, UPlap2);
        Scene UPScene = new Scene(PromoterAnchorPane3, 800, 600);
        PUpdateCustomerButton.setOnAction(e ->
                {
                    stage.setScene(UPScene);
                    tableCreatePromoter(promoterUtableView);
                }

        );//Update Promoter Scene

        UpdatePromoterButton.setOnAction(e -> {
            // Insert the new customer into the database
            System.out.println(UPTextField.getText());
            updatePromoter(Integer.parseInt(UPTextField.getText()), UPTextField1.getText(), UPTextField2.getText(),
                    Integer.parseInt(UPTextField3.getText()), UPTextField4.getText(),
                    UPTextField5.getText(), UPTextField6.getText());

            tableCreatePromoter(promoterUtableView);
            UPTextField.setText("");
            UPTextField1.setText("");
            UPTextField2.setText("");
            UPTextField3.setText("");
            UPTextField4.setText("");
            UPTextField5.setText("");
            UPTextField6.setText("");
        });

//==============================================================================================================

                                  //////Promoter Scene//////

//================================================================================================================
        Image PromoterScene = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\ImageHII.jpg");
        ImageView zaidScenImage3 = new ImageView(PromoterScene);
        ImageView AddStuImage4 = new ImageView(AddStu);
        ImageView ExitImage5 = new ImageView(Exit);


        //main Anchor
        AnchorPane PromoterAnchorPane4 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane PSlap = new AnchorPane();
        PSlap.setPrefWidth(200);
        PSlap.setPrefHeight(500);
        PSlap.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(PSlap, 0.0);
        AnchorPane.setTopAnchor(PSlap, 0.0);
        AnchorPane.setBottomAnchor(PSlap, 0.0);

        //Inner Anchor Put the inner anchor in the top left
        AnchorPane PSinnerPane = new AnchorPane();
        PSinnerPane.setPrefWidth(200);
        PSinnerPane.setPrefHeight(100);
        PSinnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(PSinnerPane, 0.0);
        AnchorPane.setTopAnchor(PSinnerPane, 0.0);
        Label pineAdministration5 = new Label("Pine Administration");
        pineAdministration5.setStyle(LabelStyle);
        AnchorPane.setTopAnchor(pineAdministration5, 0.0);
        AnchorPane.setBottomAnchor(pineAdministration5, 0.0);
        AnchorPane.setLeftAnchor(pineAdministration5, 25.0);
        AnchorPane.setRightAnchor(pineAdministration5, 0.0);
        PSinnerPane.getChildren().add(pineAdministration5);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane PSlap1 = new AnchorPane(zaidScenImage3);
        PSlap1.setPrefWidth(600);
        PSlap1.setPrefHeight(500);
        zaidScenImage3.setFitWidth(900);
        zaidScenImage3.setFitHeight(700);
        AnchorPane.setLeftAnchor(PSlap1, 200.0);
        AnchorPane.setTopAnchor(PSlap1, 100.0);
        AnchorPane.setRightAnchor(PSlap1, 0.0);
        AnchorPane.setBottomAnchor(PSlap1, 0.0);
        AnchorPane.setLeftAnchor(zaidScenImage3, 30.0);
        AnchorPane.setTopAnchor(zaidScenImage3, 0.0);
        AnchorPane.setRightAnchor(zaidScenImage3, 0.0);
        AnchorPane.setBottomAnchor(zaidScenImage3, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane PSlap2 = new AnchorPane();
        PSlap2.setPrefWidth(600);
        PSlap2.setPrefHeight(100);
        PSlap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(PSlap2, 200.0);
        AnchorPane.setTopAnchor(PSlap2, 0.0);
        AnchorPane.setRightAnchor(PSlap2, 0.0);

        Separator PSseparator1 = new Separator();
        PSseparator1.setStyle("-fx-background-color: black");
        PSseparator1.setPrefWidth(200);
        AnchorPane.setLeftAnchor(PSseparator1, 0.0);
        AnchorPane.setTopAnchor(PSseparator1, 100.0);
        AnchorPane.setRightAnchor(PSseparator1, 0.0);
        PSlap.getChildren().add(PSseparator1);

        Separator PSseparator2 = new Separator();
        PSseparator2.setOrientation(Orientation.VERTICAL);
        PSseparator2.setPrefHeight(100);
        PSseparator2.setStyle("-fx-background-color: black");
        AnchorPane.setLeftAnchor(PSseparator2, 200.0);
        AnchorPane.setTopAnchor(PSseparator2, 0.0);
        AnchorPane.setBottomAnchor(PSseparator2, 0.0);
        PromoterAnchorPane4.getChildren().add(PSseparator2);

        VBox PSv = new VBox();
        PSv.setAlignment(Pos.CENTER_LEFT);
        PSv.setSpacing(20);


        Button PSaddCustomerButton = new Button("  Add Customer", AddStuImage4);
        PSaddCustomerButton.setPrefSize(200, 30);
        PSaddCustomerButton.setStyle(ButtonStyle2);
        AddStuImage4.setFitWidth(50);
        AddStuImage4.setFitHeight(50);
        // Add an effect to the button
        DropShadow dropShadow10 = new DropShadow();
        dropShadow10.setBlurType(BlurType.GAUSSIAN);
        dropShadow10.setRadius(10);
        dropShadow10.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        PSaddCustomerButton.setEffect(dropShadow10);
        // Increase the opacity of the shadow when the mouse is over the button
        PSaddCustomerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow10.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        PSaddCustomerButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow10.setColor(Color.rgb(0, 0, 0, 0.5)));


        Button PSExitButton = new Button("    Log Out          ", ExitImage5);
        PSExitButton.setPrefSize(200, 30);
        PSExitButton.setStyle(ButtonStyle2);
        ExitImage5.setFitHeight(50);
        ExitImage5.setFitWidth(50);
        // Add an effect to the button
        DropShadow dropShadow11 = new DropShadow();
        dropShadow11.setBlurType(BlurType.GAUSSIAN);
        dropShadow11.setRadius(10);
        dropShadow11.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        PSExitButton.setEffect(dropShadow11);
        // Increase the opacity of the shadow when the mouse is over the button
        PSExitButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow11.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        PSExitButton.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow11.setColor(Color.rgb(0, 0, 0, 0.5)));

        ImageView WinnerImage1 = new ImageView(Winner);
        Button prizeGeneratorButton2 = new Button(" Prize Generator ", WinnerImage1);
        prizeGeneratorButton2.setPrefSize(200, 30);
        prizeGeneratorButton2.setStyle(ButtonStyle2);
        WinnerImage1.setFitWidth(50);
        WinnerImage1.setFitHeight(50);
        // Add an effect to the button
        DropShadow dropShadow12 = new DropShadow();
        dropShadow12.setBlurType(BlurType.GAUSSIAN);
        dropShadow12.setRadius(10);
        dropShadow12.setColor(Color.rgb(0, 0, 0, 0.5));
        // Set the effect to the button
        prizeGeneratorButton2.setEffect(dropShadow12);
        // Increase the opacity of the shadow when the mouse is over the button
        prizeGeneratorButton2.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> dropShadow12.setColor(Color.rgb(0, 0, 0, 1)));
        // Decrease the opacity of the shadow when the mouse is not over the button
        prizeGeneratorButton2.addEventHandler(MouseEvent.MOUSE_EXITED, event -> dropShadow12.setColor(Color.rgb(0, 0, 0, 0.5)));


        //Welcome, Image Of The Program
        AnchorPane.setLeftAnchor(PSv, 20.0);
        AnchorPane.setTopAnchor(PSv, 110.0);
        ImageView imageView3 = new ImageView(Pine);
        imageView3.setFitWidth(250);
        imageView3.setFitHeight(250);
        Label PSlabel = new Label("Welcome To Pine Operation System, Promoter Scene");
        PSlabel.setStyle(LabelStyle);
        VBox pineandlabel2 = new VBox(imageView3, PSlabel);
        pineandlabel2.setAlignment(Pos.CENTER);
        PSlap1.getChildren().addAll(pineandlabel2);
        AnchorPane.setRightAnchor(pineandlabel2, 200.0);
        AnchorPane.setTopAnchor(pineandlabel2, 130.0);


        //Account Panel
        HBox PSAccount = new HBox();
        ImageView AccountPanelImage3 = new ImageView(AccountPanel);
        AccountPanelImage3.setFitHeight(30);
        AccountPanelImage3.setFitWidth(30);
        Button PSuserBtn = new Button("User Name", AccountPanelImage3);
        PSuserBtn.setStyle(ButtonStyle2);
        PSAccount.getChildren().addAll(PSuserBtn);
        PSAccount.setStyle("-fx-padding: 10px;-fx-alignment: center-right");
        AnchorPane.setTopAnchor(PSAccount, 10.0);
        AnchorPane.setRightAnchor(PSAccount, 20.0);
        PSuserBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        PSuserBtn.setOnMouseEntered(event -> PSuserBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(255,255,0,0.8), 10, 0, 0, 0);"));
        PSuserBtn.setOnMouseExited(event -> PSuserBtn.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"));


        PSv.getChildren().addAll(PSaddCustomerButton, prizeGeneratorButton2, PSExitButton);
        PSlap.getChildren().add(PSv);
        PSlap.getChildren().add(PSinnerPane);
        PromoterAnchorPane4.getChildren().addAll(PSlap, PSlap1, PSlap2);
        PSlap2.getChildren().addAll(PSAccount);
        Scene Pzaid1 = new Scene(PromoterAnchorPane4, 1100, 700);//Primary Scene
        PSExitButton.setOnAction(e -> {
            stage.setScene(scene);
        });

//============================================================================================================

        //Add Customer From Promoter Scene//

//============================================================================================================
        ImageView PineImage7 = new ImageView(Pine);
        ImageView BackImage7 = new ImageView(Back);
        ImageView AddStuImage5 = new ImageView(AddStu);

        //main Anchor
        AnchorPane AddPSmainAnchorPane1 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane AddPSlap = new AnchorPane();
        AddPSlap.setPrefWidth(350);
        AddPSlap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(AddPSlap, 0.0);
        AnchorPane.setTopAnchor(AddPSlap, 0.0);
        AnchorPane.setBottomAnchor(AddPSlap, 0.0);
        Button SearchBtn6 = new Button("Search");
        SearchBtn6.setStyle(ButtonStyle);
        TextField SearchTxt6 = new TextField();
        SearchTxt6.setPromptText("Enter Customer Id To Search For");
        HBox SearchHBox6 = new HBox(SearchTxt6, SearchBtn6);
        AnchorPane.setLeftAnchor(SearchHBox6, 0.0);
        AnchorPane.setTopAnchor(SearchHBox6, 110.0);
        AnchorPane.setBottomAnchor(SearchHBox6, 0.0);
        SearchTxt6.setPrefSize(650, 20);
        SearchTxt6.setStyle(TextFieldStyle);

        //Buttons ====================
        Button addCustomerButton2 = new Button("Add Customer");
        addCustomerButton2.setPrefSize(180, 30);
        addCustomerButton2.setStyle(ButtonStyle);

        Button AddBack3 = new Button("Back", BackImage7);
        AddBack3.setPrefSize(180, 30);
        AddBack3.setStyle(ButtonStyle);
        BackImage7.setFitWidth(60);
        BackImage7.setFitHeight(60);


        //Inner Anchor Put the inner anchor in the top left
        AnchorPane AddPSInnerPane = new AnchorPane();
        AddPSInnerPane.setPrefWidth(200);
        AddPSInnerPane.setPrefHeight(100);
        AddPSInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(AddPSInnerPane, 0.0);
        AnchorPane.setTopAnchor(AddPSInnerPane, 0.0);
        AnchorPane.setTopAnchor(AddBack3, 0.0);
        AnchorPane.setBottomAnchor(AddBack3, 0.0);
        AnchorPane.setLeftAnchor(AddBack3, 10.0);
        AnchorPane.setRightAnchor(AddBack3, 0.0);
        AddPSInnerPane.getChildren().add(AddBack3);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane AddPSlap1 = new AnchorPane();
        AddPSlap1.setPrefWidth(450);
        AddPSlap1.setPrefHeight(500);
        AddPSlap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(AddPSlap1, 730.0);
        AnchorPane.setTopAnchor(AddPSlap1, 100.0);
        AnchorPane.setRightAnchor(AddPSlap1, 0.0);
        AnchorPane.setBottomAnchor(AddPSlap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane AddPSlap2 = new AnchorPane();
        AddPSlap2.setPrefWidth(600);
        AddPSlap2.setPrefHeight(100);
        AddPSlap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(AddPSlap2, 200.0);
        AnchorPane.setTopAnchor(AddPSlap2, 0.0);
        AnchorPane.setRightAnchor(AddPSlap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage7, 130.0);
        AnchorPane.setTopAnchor(PineImage7, 10.0);
        AnchorPane.setRightAnchor(PineImage7, 0.0);
        AddPSlap2.getChildren().add(PineImage7);
        PineImage7.setFitHeight(80);
        PineImage7.setFitWidth(80);

        GridPane PSgridPane = new GridPane();
        PSgridPane.setHgap(10);
        PSgridPane.setVgap(10);
        Label PSAddLabel = new Label("Customer ID");
        Label PSAddLabel1 = new Label("Customer Name");
        Label PSAddLabel3 = new Label("Phone Number");
        Label PSAddLabel4 = new Label("Age");
        Label PSAddLabel5 = new Label("Gender");
        Label PSAddLabel7 = new Label("Promoter ID");
        Label PSAddLabel8 = new Label("Gift ID");
        PSAddLabel.setStyle(LabelStyle1);
        PSAddLabel1.setStyle(LabelStyle1);
        PSAddLabel3.setStyle(LabelStyle1);
        PSAddLabel4.setStyle(LabelStyle1);
        PSAddLabel5.setStyle(LabelStyle1);
        PSAddLabel7.setStyle(LabelStyle1);
        PSAddLabel8.setStyle(LabelStyle1);
        TextField PSAddTextField = new TextField();
        TextField PSAddTextField1 = new TextField();
        TextField PSAddTextField3 = new TextField();
        TextField PSAddTextField4 = new TextField();
        TextField PSAddTextField5 = new TextField();
        TextField PSAddTextField7 = new TextField();
        TextField PSAddTextField8 = new TextField();
        PSAddTextField.setStyle(TextFieldStyle);
        PSAddTextField1.setStyle(TextFieldStyle);
        PSAddTextField3.setStyle(TextFieldStyle);
        PSAddTextField4.setStyle(TextFieldStyle);
        PSAddTextField5.setStyle(TextFieldStyle);
        PSAddTextField7.setStyle(TextFieldStyle);
        PSAddTextField8.setStyle(TextFieldStyle);


        AddBack3.setOnAction(e -> stage.setScene(Pzaid1));
        PSgridPane.add(PSAddLabel, 0, 0);
        PSgridPane.add(PSAddLabel1, 0, 1);
        PSgridPane.add(PSAddLabel3, 0, 2);
        PSgridPane.add(PSAddLabel4, 0, 3);
        PSgridPane.add(PSAddLabel5, 0, 4);
        PSgridPane.add(PSAddLabel7, 0, 5);
        PSgridPane.add(PSAddLabel8, 0, 6);
        PSgridPane.add(PSAddTextField, 1, 0);
        PSgridPane.add(PSAddTextField1, 1, 1);
        PSgridPane.add(PSAddTextField3, 1, 2);
        PSgridPane.add(PSAddTextField4, 1, 3);
        PSgridPane.add(PSAddTextField5, 1, 4);
        PSgridPane.add(PSAddTextField7, 1, 5);
        PSgridPane.add(PSAddTextField8, 1, 6);


        VBox PSv1 = new VBox(AddStuImage5, PSgridPane, addCustomerButton2);
        PSv1.setAlignment(Pos.CENTER);
        PSv1.setSpacing(20);
        AnchorPane.setLeftAnchor(PSv1, 20.0);
        AnchorPane.setTopAnchor(PSv1, 20.0);
        AddStuImage5.setFitWidth(80);
        AddStuImage5.setFitHeight(80);

        TableView<ObservableList<String>> addPstableView = new TableView<>();
        AnchorPane.setLeftAnchor(addPstableView, 0.0);
        AnchorPane.setTopAnchor(addPstableView, 143.0);
        AnchorPane.setBottomAnchor(addPstableView, 0.0);

        AddPSlap1.getChildren().add(PSv1);
        AddPSlap.getChildren().addAll(addPstableView, SearchHBox6);
        AddPSlap.getChildren().add(AddPSInnerPane);
        AddPSmainAnchorPane1.getChildren().addAll(AddPSlap, AddPSlap1, AddPSlap2);
        Scene AddPSScene = new Scene(AddPSmainAnchorPane1, 1100, 700);
        PSaddCustomerButton.setOnAction(e ->
                {
                    stage.setScene(AddPSScene);
                    tableCreate(addPstableView);
                }

        );//Add Customer in Promoter Scene

        addCustomerButton2.setOnAction(e -> {
            // Insert the new customer into the database
            System.out.println(PSAddTextField1.getText());
            insertCustomer(Integer.parseInt(PSAddTextField.getText()), PSAddTextField1.getText(), PSAddTextField3.getText(),
                    Integer.parseInt(PSAddTextField4.getText()), PSAddTextField5.getText(), Integer.parseInt(PSAddTextField8.getText()),
                    Integer.parseInt(PSAddTextField7.getText()));
            tableCreate(addPstableView);


            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM costumer");

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
                    int columnIndex = i - 1;
                    column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(columnIndex)));
                    tableView.getColumns().add(column);
                }

                ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(resultSet.getString(i));
                    }
                    data.add(row);
                }
                tableView.setItems(data);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            PSAddTextField.setText("");
            PSAddTextField1.setText("");
            PSAddTextField3.setText("");
            PSAddTextField4.setText("");
            PSAddTextField5.setText("");
            PSAddTextField7.setText("");
            PSAddTextField8.setText("");

        });

//==============================================================================================================

                         //////Add gift From Promoter Scene//////

//================================================================================================================
        ImageView PineImage9 = new ImageView(Pine);
        ImageView BackImage9 = new ImageView(Back);
        ImageView PrizeImage9 = new ImageView(price);

        //main Anchor
        AnchorPane mainAnchorPane5 = new AnchorPane();
        //Left Anchor put the left Anchor pane on the left side of scene and extends from the bottom to the top of the scene
        AnchorPane PGlap = new AnchorPane();
        PGlap.setPrefWidth(350);
        PGlap.setPrefHeight(500);
        AnchorPane.setLeftAnchor(PGlap, 0.0);
        AnchorPane.setTopAnchor(PGlap, 0.0);
        AnchorPane.setBottomAnchor(PGlap, 0.0);

        Button PGBack = new Button("Back", BackImage9);
        PGBack.setPrefSize(180, 30);
        PGBack.setStyle(ButtonStyle);
        BackImage9.setFitWidth(60);
        BackImage9.setFitHeight(60);
        PGBack.setOnAction(e -> stage.setScene(Pzaid1));


        //Inner Anchor Put the inner anchor in the top left
        AnchorPane PGInnerPane = new AnchorPane();
        PGInnerPane.setPrefWidth(200);
        PGInnerPane.setPrefHeight(100);
        PGInnerPane.setStyle("-fx-background-color:#0598ff");
        AnchorPane.setLeftAnchor(PGInnerPane, 0.0);
        AnchorPane.setTopAnchor(PGInnerPane, 0.0);
        AnchorPane.setTopAnchor(PGBack, 0.0);
        AnchorPane.setBottomAnchor(PGBack, 0.0);
        AnchorPane.setLeftAnchor(PGBack, 10.0);
        AnchorPane.setRightAnchor(PGBack, 0.0);
        PGInnerPane.getChildren().add(PGBack);

        //The Right big anchor pane put it right of lap with the following sizes and layout
        AnchorPane PGlap1 = new AnchorPane();
        PGlap1.setPrefWidth(450);
        PGlap1.setPrefHeight(500);
        PGlap1.setStyle("-fx-background-color: #ADD8E6");
        AnchorPane.setLeftAnchor(PGlap1, 300.0);
        AnchorPane.setTopAnchor(PGlap1, 100.0);
        AnchorPane.setRightAnchor(PGlap1, 0.0);
        AnchorPane.setBottomAnchor(PGlap1, 0.0);

        //put it above lap1 at the top of the scene on the right of inner pane
        AnchorPane PGlap2 = new AnchorPane();
        PGlap2.setPrefWidth(600);
        PGlap2.setPrefHeight(100);
        PGlap2.setStyle("-fx-background-color: #0598ff");
        AnchorPane.setLeftAnchor(PGlap2, 200.0);
        AnchorPane.setTopAnchor(PGlap2, 0.0);
        AnchorPane.setRightAnchor(PGlap2, 0.0);
        AnchorPane.setLeftAnchor(PineImage9, 400.0);
        AnchorPane.setTopAnchor(PineImage9, 10.0);
        AnchorPane.setRightAnchor(PineImage9, 0.0);
        PGlap2.getChildren().add(PineImage9);
        PineImage9.setFitHeight(80);
        PineImage9.setFitWidth(80);


        //===========Table View===============

        TableView<Gift> PGtable = new TableView<>();
        AnchorPane.setLeftAnchor(PGtable, 0.0);
        AnchorPane.setTopAnchor(PGtable, 143.0);
        AnchorPane.setBottomAnchor(PGtable, 0.0);


        TableColumn<Gift, Integer> PGidColumn = new TableColumn<>("GID");
        PGidColumn.setCellValueFactory(new PropertyValueFactory<>("Gift id"));

        TableColumn<Gift, String> PGnameColumn = new TableColumn<>("GName");
        PGnameColumn.setCellValueFactory(new PropertyValueFactory<>("gift name"));


        // Create a button with an image
        Button prizeButton2 = new Button();
        ImageView prizeImageView2 = new ImageView(prizeImage1);
        prizeImageView2.setFitHeight(80);
        prizeImageView2.setFitWidth(80);

        prizeButton2.setGraphic(prizeImageView2);
        prizeButton2.setStyle("-fx-min-width: 100; -fx-border-color: red; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        Label prizeLabel2 = new Label("Press to Win");
        prizeLabel2.setStyle(LabelStyle);
        String[] prizes2 = {"Extra Product", "Charger", "50Nis Coupon", "Mobile Stand", "Thermal Cup", "Car Label"};
        Label chosenPrize2 = new Label();
        chosenPrize2.setStyle(LabelStyle);

        VBox layout2 = new VBox(prizeLabel2, prizeButton2, chosenPrize2);
        layout2.setAlignment(Pos.CENTER);






        VBox PGv3 = new VBox(PrizeImage9, layout2);
        PGv3.setAlignment(Pos.CENTER);
        PGv3.setSpacing(40);
        AnchorPane.setLeftAnchor(PGv3, 180.0);
        AnchorPane.setTopAnchor(PGv3, 80.0);
        PrizeImage9.setFitWidth(80);
        PrizeImage9.setFitHeight(80);


        TableView<ObservableList<String>> PGtableView = new TableView<>();
        AnchorPane.setLeftAnchor(PGtableView, 0.0);
        AnchorPane.setTopAnchor(PGtableView, 143.0);
        AnchorPane.setBottomAnchor(PGtableView, 0.0);
        PGtableView.setPrefWidth(250);
        PGlap1.getChildren().add(PGv3);

        PGlap.getChildren().addAll(PGtableView);

        PGlap.getChildren().add(PGInnerPane);
        mainAnchorPane5.getChildren().addAll(PGlap, PGlap1, PGlap2);
        Scene PGScene = new Scene(mainAnchorPane5, 1100, 750);
        prizeGeneratorButton2.setOnAction(e -> {
            stage.setScene(PGScene);
            tableCreategift(PGtableView);
        });//Add Gift Scene

        prizeButton2.setOnAction(e -> {
            // Choose a random prize
            int randomIndex1 = (int) (Math.random() * prizes1.length);
            String randomPrize1 = prizes1[randomIndex1];

            // Update the chosen prize label
            chosenPrize1.setText(randomPrize1 + " Gift ID:"+ ++Gi);

            addGift( Gi, randomPrize1);
            tableCreategift(GtableView);
        });


        loginButton.setOnAction(e -> {
            try {
                int x = test(usernameTextField.getText(), passwordField.getText());

                if (usernameTextField.getText().equals("zaid") && passwordField.getText().equals("123"))
                    stage.setScene(zaid);
                else if (x == 1){
                currentid = usernameTextField.getText();
                stage.setScene(Pzaid1);
            }
                else
                    errorLabel.setText("Email and password are not valid");

                usernameTextField.setText("");
                passwordField.setText("");
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        ExitButton.setOnAction(e -> {
            stage.setScene(scene);
            toggleButton1.setSelected(true);
        });


        Image icon = new Image("C:\\Users\\DELL\\OneDrive\\Desktop\\DataBase Comp333\\fn\\ProductSystem-DataBase\\src\\main\\java\\Photos\\Piine.png");
        stage.getIcons().add(icon);
        stage.setTitle("Pine Administration");
        stage.setScene(scene);
        stage.show();
        connect();


    }

    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Succeed ....................");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection Failed....................");
        }
    }

    // Insert a new customer into the database
    private void insertCustomer(int Cid, String name, String phone, int age, String gender, int gid, int promoterid) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpine?useSSL=false", "root", "1203101");

            String query = "INSERT INTO costumer (cid, cname, phone, age, gender, gid, promoterid) VALUES (?, ?, ?,?, ?, ?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, Cid);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.setInt(4, age);
            pstmt.setString(5, gender);
            pstmt.setInt(6, gid);
            pstmt.setInt(7, promoterid);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCustomer(int Cid, String name, String phone, int age, String gender) {
        String url = "jdbc:mysql://127.0.0.1:3306/dbpine";
        String username = "root";
        String password = "1203101";

        String updateQuery = "UPDATE costumer SET cname = ?,phone = ?, age = ?, gender = ?  WHERE Cid = ?";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = con.prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setInt(3, age);
            stmt.setString(4, gender);
            stmt.setInt(5, Cid);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updatePromoter(int promoterid, String name, String phone, int age, String gender, String uname, String pwd) {
        String url = "jdbc:mysql://127.0.0.1:3306/dbpine";
        String username = "root";
        String password = "1203101";

        String updateQuery = "UPDATE promoter SET name = ?,phone = ?, age = ?, gender = ?, username = ?, ppassword = ? WHERE promoterid = ?";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = con.prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setInt(3, age);
            stmt.setString(4, gender);
            stmt.setString(5, uname);
            stmt.setString(6, pwd);
            stmt.setInt(7, promoterid);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addPromoter(int promoterId, String name, String phone, int age, String gender, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");

            String query = "INSERT INTO promoter (promoterid, name, phone, age, gender, username, ppassword) VALUES (?, ?, ?,?, ?, ?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, promoterId);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.setInt(4, age);
            pstmt.setString(5, gender);
            pstmt.setString(6, username);
            pstmt.setString(7, password);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tableCreatePromoter(TableView<ObservableList<String>> tblView) {
        tblView.getColumns().clear();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM promoter");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
                int columnIndex = i - 1;
                column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(columnIndex)));
                tblView.getColumns().add(column);
            }

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
            while (resultSet.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            tblView.setItems(data);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteCustomer(int Cid) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("DELETE FROM costumer WHERE cid = ?");
            stmt.setInt(1, Cid);
            stmt.executeUpdate();
            conn.close();
            System.out.println("Deleted Succesfully!!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deletePromoter(int promoterId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("DELETE FROM promoter WHERE promoterid = ?");
            stmt.setInt(1, promoterId);
            stmt.executeUpdate();
            conn.close();
            System.out.println("Deleted Succesfully!!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tableCreate(TableView<ObservableList<String>> tblView) {
        Connection connection = null;
        try {
            tblView.getColumns().clear();
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM costumer");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
                int columnIndex = i - 1;
                column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(columnIndex)));
                column.setPrefWidth(100);
                tblView.getColumns().add(column);
                column.setMaxWidth(Double.MAX_VALUE);

            }

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            tblView.setItems(data);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void addGift(int giftId, String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
            String query = "INSERT INTO gift (gid, gname) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, giftId);
            pstmt.setString(2, name);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void tableCreategift(TableView<ObservableList<String>> tblView) {
        Connection connection = null;
        try {
            tblView.getColumns().clear();
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM gift");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
                int columnIndex = i - 1;
                column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(columnIndex)));
                column.setPrefWidth(150);
                tblView.getColumns().add(column);
                column.setMaxWidth(Double.MAX_VALUE);

            }

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            tblView.setItems(data);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private Customer searchCustomer(int customerId) {
        Customer customer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM costumer WHERE cid = ?");
            stmt.setInt(1, customerId);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                customer = new Customer(result.getInt("cid"), result.getString("cname")
                        , result.getInt("age"),result.getString("phone"),
                        result.getString("gender"), result.getInt("gid"),(result.getInt("promoterid")));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    private Promoter SearchPromoter(int PromoterId) {
        Promoter Promoter= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("SELECT * FROM promoter WHERE promoterid = ?");
            stmt.setInt(1, PromoterId);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                Promoter = new Promoter(result.getInt("promoterid"), result.getString("name")
                        , result.getInt("age"),result.getString("phone"),
                        result.getString("gender"));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Promoter;
    }

    //    public void SearchCustomerTable(TableView<ObservableList<String>> tblView) {
//        Connection connection = null;
//        try {
//            tblView.getColumns().clear();
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbpine", "root", "1203101");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM costumer where cid = ?");
//
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            int columnCount = metaData.getColumnCount();
//            for (int i = 1; i <= columnCount; i++) {
//                TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
//                int columnIndex = i - 1;
//                column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(columnIndex)));
//                column.setPrefWidth(150);
//                tblView.getColumns().add(column);
//                column.setMaxWidth(Double.MAX_VALUE);
//
//            }
//
//            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
//
//            while (resultSet.next()) {
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for (int i = 1; i <= columnCount; i++) {
//                    row.add(resultSet.getString(i));
//                }
//                data.add(row);
//            }
//            tblView.setItems(data);
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    public int test(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpine", "root", "1203101");
        String str="SELECT count(1) FROM promoter where username=  '"+ username +"' AND ppassword= '"+ password+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    return 1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }




    public static void main(String[] args) throws Exception {
        launch();

    }
}
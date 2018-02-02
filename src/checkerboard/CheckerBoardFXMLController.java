/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Brandon
 */
public class CheckerBoardFXMLController implements Initializable, Startable {
       
    private Stage stage;
    
    private int numRows = 8;
    private int numCols = 8;

    CheckerBoard checkerBoard;

    private AnchorPane anchorPane;
    
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    private double stageHeight;
    private double stageWidth;
    
    
    @FXML 
    VBox vBox; 
    
    @FXML
    MenuBar menuBar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        checkerBoard = new CheckerBoard(numRows, numCols, vBox.getWidth(), vBox.getHeight() - menuBar.getHeight());
        
        this.anchorPane = checkerBoard.build();
        vBox.getChildren().add(anchorPane);
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        stageWidth = stage.getWidth();
        stageHeight = stage.getHeight();
    }
    
    private void refresh(){
        checkerBoard = new CheckerBoard(numRows, numCols, vBox.getWidth(), vBox.getHeight() - menuBar.getHeight(), lightColor, darkColor);
        vBox.getChildren().remove(anchorPane);
        this.anchorPane = checkerBoard.build();
        vBox.getChildren().add(anchorPane);
    }
    
    @FXML
    private void handleGrid16x16(ActionEvent event) {
        numRows = 16; 
        numCols = 16;
        refresh();
    }
    
    @FXML
    private void handleGrid10x10(ActionEvent event) {
        numRows = 10;
        numCols = 10;
        refresh();
    }
    
    @FXML
    private void handleGrid8x8(ActionEvent event) {
        numRows = 8;
        numCols = 8;
        refresh();
    }
 
    @FXML
    private void handleGrid3x3(ActionEvent event) {
        numRows = 3;
        numCols = 3;
        refresh();
    }
    
    @FXML
    private void handleDefault(ActionEvent event) {
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        refresh();
    }
    
    @FXML
    private void handleBlue(ActionEvent event) {
        lightColor = Color.SKYBLUE;
        darkColor = Color.DARKBLUE;
        refresh();
    }
}
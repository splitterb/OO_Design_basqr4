/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Brandon
 */
public class CheckerBoard extends Application {
    
    private AnchorPane anchorPane = null;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private double recWidth;
    private double recHeight;
    
    public CheckerBoard(){
        
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this(numRows, numCols, boardWidth, boardHeight);
        
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build(){
        int i,j;
        
        recWidth = (boardWidth/(double)numCols);
        recHeight = (boardHeight/(double)numRows);
        
        System.out.printf("width: %f, height: %f", recWidth, recHeight);
        
        if(anchorPane == null){
            anchorPane = new AnchorPane();
        }
            
        for(i = 0; i<numRows; i++){
            for(j = 0; j<numCols; j++){
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(recWidth);
                rectangle.setHeight(recHeight);
                
                if((i+j)%2 == 0){
                    rectangle.setFill(this.lightColor);
                } else{
                    rectangle.setFill(this.darkColor);
                }
                AnchorPane.setLeftAnchor(rectangle, recWidth*j);
                AnchorPane.setTopAnchor(rectangle, recHeight*i);
                anchorPane.getChildren().add(rectangle);
            }
        }
        
        return anchorPane;
    }
    
    public AnchorPane getBoard(){
        if(anchorPane != null){
            return this.anchorPane;
        } else {
            return null;
        }
    }
    
    public int getNumRows(){
        return this.numRows;
    }
    
    public int getNumCols(){
        return this.numCols;
    } 
    
    public double getWidth(){
        return this.boardWidth;
    }

    public double getHeight(){
        return this.boardHeight;
    } 
    
    public Color getLightColor(){
        return this.lightColor;
    }
    
    public Color getDarkColor(){
        return this.darkColor;
    }
    
    public double getRectangleWidth(){
        return this.recWidth;
    }
    
    public double getRectangleHeight(){
        return this.recHeight;
    }
  
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckerBoardFXML.fxml"));
        Parent root = loader.load();
        Startable controller = loader.getController();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        controller.start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

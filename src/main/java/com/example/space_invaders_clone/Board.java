package com.example.space_invaders_clone;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.io.IOException;
import java.util.EventListener;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Board extends Application implements EventListener {

    Button pause;
    Button quit;
    Scene scene;
    BorderPane border;
    playerShip player;
    int COL = 25;
    int ROW = 15;
    GridEntity[][] board = new GridEntity[COL][ROW];


// Seperated functions.... may bring back
//    public Node top(){
//        HBox topMenu = new HBox();
//        topMenu.setSpacing(10);
//        topMenu.setStyle("-fx-background-color: #000000;");
//
//        pause = new Button("Pause");
//        quit = new Button("Quit");
//        quit.setOnAction((ActionEvent event) -> {
//            Platform.exit();
//        });
//
//        topMenu.getChildren().addAll(pause, quit);
//
//        return topMenu;
//    }

//    public Node bottom(){
//        VBox bottomStats = new VBox();
//        Text score = new Text("Score: ");
//        score.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//        bottomStats.getChildren().add(score);
//
//        return bottomStats;
//    }
//
//    public Node center(){
//        player = new playerShip(1, 1, 5, 0);
//
//        for(int row = 0; row < ROW; row++){
//            for(int col = 0; col < COL; col++){
//                if (row == 7 && col == 22) {
//                    board[col][row] = new playerShip(1, 1, 2, 0);
//                } else if((row >= 3 && row <= 11) && (col >= 9 && col <= 10))
//                {
//                    board[col][row] = new alienShipLvl1(col, row);
//                } else if((row >= 3 && row <= 11) && (col >= 7 && col <= 8)){
//                    board[col][row] = new alienShipLvl2(col, row);
//                }
//                else if((row >= 3 && row <= 11) && (col >= 5 && col <= 6)){
//                    board[col][row] = new alienShipLvl3(col, row);
//                } else {
//                    board[col][row] = new BufferSquares(col, row);
//                }
//            }
//        }
//
//        GridPane grid = new GridPane();
//        for(int row = 0; row < ROW; row++) {
//            for (int col = 0; col < COL; col++) {
//                GridEntity entity = board[col][row];
//                grid.add(entity.getImageView(), row, col);
//            }
//        }
//
//        grid.setGridLinesVisible(FALSE);
//
//
//        return grid;
//    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Clone Invader");
        border = new BorderPane();

        //set top menu
        HBox topMenu = new HBox();
        topMenu.setSpacing(10);
        topMenu.setStyle("-fx-background-color: #000000;");
        pause = new Button("Pause");
        quit = new Button("Quit");
        quit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        topMenu.getChildren().addAll(pause, quit);
        border.setTop(topMenu);
        //

        //set center pane
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (row == 7 && col == 22) {
                    player = new playerShip(col, row, 2, 0);
                    board[col][row] = player;
                } else if ((row >= 3 && row <= 11) && (col >= 9 && col <= 10)) {
                    board[col][row] = new alienShipLvl1(col, row);
                } else if ((row >= 3 && row <= 11) && (col >= 7 && col <= 8)) {
                    board[col][row] = new alienShipLvl2(col, row);
                } else if ((row >= 3 && row <= 11) && (col >= 5 && col <= 6)) {
                    board[col][row] = new alienShipLvl3(col, row);
                } else {
                    board[col][row] = new BufferSquares(col, row);
                }
            }
        }

        GridPane grid = new GridPane();

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                GridEntity entity = board[col][row];
                grid.add(entity.getImageView(), row, col);
            }
        }

        grid.setGridLinesVisible(FALSE);
        border.setCenter(grid);
        scene = new Scene(border);
        stage.setScene(scene);
        //


        //set bottom pane
        Label bottomStats = new Label();
        bottomStats.setFont(new Font(30));
        bottomStats.setText("Score: " + player.getPoints());
        border.setBottom(bottomStats);
        //


        scene.setOnKeyPressed(event ->
        {
            System.out.print(event.getText());
            String pressed = event.getText();

            if (pressed.compareTo("a") == 0) {
                try {
                    GridEntity temp = board[player.getX()][player.getY() - 1];
                    board[player.getX()][player.getY() - 1] = player;
                    board[player.getX()][player.getY()] = temp;
                    temp.setY(player.getY());
                    player.setY(player.getY() - 1);
                    grid.add(temp.getImageView(), temp.getY(), temp.getX());
                    grid.add(player.getImageView(), player.getY(), player.getX());
                } catch (Exception e) {
                    return;
                }
                ;
            } else if (pressed.compareTo("d") == 0) {
                try {
                    GridEntity temp = board[player.getX()][player.getY() + 1];
                    board[player.getX()][player.getY() + 1] = player;
                    board[player.getX()][player.getY()] = temp;
                    temp.setY(player.getY());
                    player.setY(player.getY() + 1);
                    grid.add(temp.getImageView(), temp.getY(), temp.getX());
                    grid.add(player.getImageView(), player.getY(), player.getX());
                } catch (Exception e) {
                    return;
                }
            } else if (pressed.compareTo("s") == 0) {
                Missile missile = new Missile(player.getX() - 1, player.getY());
                board[missile.getX()][missile.getY()] = missile;
                grid.add(missile.getImageView(), missile.getX(), missile.getY());
                do {
                    GridEntity temp = board[missile.getX() - 1][missile.getY()];
                    if (temp instanceof BufferSquares) {
                        board[missile.getX() - 1][missile.getY()] = missile;
                        board[missile.getX()][missile.getY()] = temp;
                        temp.setX(missile.getX());
                        missile.setX(missile.getX() - 1);
                        grid.add(missile.getImageView(), missile.getY(), missile.getX());
                        grid.add(temp.getImageView(), missile.getY(), missile.getX() + 1);
                    } else if (temp instanceof alienShip) {
                        board[missile.getX() - 1][missile.getY()] = new BufferSquares(missile.getX()-1, missile.getY());
                        board[missile.getX()][missile.getY()] = new BufferSquares(missile.getX(), missile.getY());
                        grid.add(board[missile.getX() - 1][missile.getY()].getImageView(), missile.getY(), missile.getX()-1);
                        grid.add(board[missile.getX()][missile.getY()].getImageView(), missile.getY(), missile.getX());
                        player.setPoints(((alienShip) temp).getPointValue());
                        border.setBottom(bottomStats);
                        System.out.println(player.getPoints());
                        missile.isActive = FALSE;
                    }
                } while (missile.isActive == TRUE);
            }
        });


        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }




}
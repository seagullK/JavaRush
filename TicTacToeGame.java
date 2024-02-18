/*
Крестики - нолики
*/

package com.javarush.games.ticktacktoe;
import com.javarush.engine.cell.*;

public class TicTacToeGame extends Game {
    
    private int[][] model = new int[3][3];
    private int currentPlayer;
    private boolean isGameStopped;
    
    public void initialize() {
        setScreenSize(3, 3);
        startGame();
        updateView();
    }
    
    public void startGame() {
        for (int i = 0; i < model.length; i++) {
            for (int j = 0; j < model[i].length; j++) {
                model[i][j] = 0;
            }
        }       
        currentPlayer = 1;
        isGameStopped = false;
        
    }
    
    public boolean checkFutureWin( int x, int y, int n) {
        if (model[x][y] != 0)
            return false;
        model[x][y] = n;
        boolean isFutureWin = checkWin(x, y, n);
        model[x][y] = 0;
        return isFutureWin;
    }
    
    public void computerTurn() {
        if (model[1][1] == 0)
            setSignAndCheck(1, 1);
        else {
            for (int i = 0; i < model.length; i++) {
                for (int j = 0; j < model[i].length; j++) {
                    if (checkFutureWin(i, j, 2)){
                        setSignAndCheck(i, j);
                        return;
                    }
                        
                }
            }
            for (int i = 0; i < model.length; i++) {
                for (int j = 0; j < model[i].length; j++) {
                    if (checkFutureWin(i, j, 1)){
                        setSignAndCheck(i, j);
                        return;
                    }
                        
                }
            }
            for (int i = 0; i < model.length; i++) {
                for (int j = 0; j < model[i].length; j++) {
                    if (model[i][j] == 0){
                        setSignAndCheck(i, j);
                        return;
                    } 
                }
            }
        }  
    }
    
    public void onKeyPress(Key key) { 
        if (key == Key.ESCAPE || (isGameStopped && key == Key.SPACE)) {
            startGame();
            updateView();
        }
    }
    
    public boolean checkWin(int x, int y, int n) {
        if (model[x][y] != n) 
            return false;
        if (model[x][0] == model[x][1] && model[x][0] == model[x][2])
            return true;
        if (model[0][y] == model[1][y] && model[0][y] == model[2][y])
            return true;
        if (model[0][0] == n && model[1][1] == n && model[2][2] == n)
            return true;
        if (model[0][2] == n && model[1][1] == n && model[2][0] == n)
            return true;
        return false;
    }
    
    public boolean hasEmptyCell() {
        for (int i = 0; i < model.length; i++) {
            for (int j = 0; j < model[i].length; j++) {
                if (model[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
    
    public void onMouseLeftClick(int x, int y) {
        
        setSignAndCheck(x, y);
        
        // if (currentPlayer == 1)
        //     currentPlayer = 2;
        // else 
        //     currentPlayer = 1;
        
        currentPlayer = 2;
        computerTurn();
        currentPlayer = 1;
    }
    
    public void setSignAndCheck(int x, int y) {
        
        if (model[x][y] != 0 || isGameStopped) 
            return;
        model[x][y] = currentPlayer;
        updateView();
        if (checkWin(x, y, currentPlayer)) {
            isGameStopped = true;
            if (currentPlayer == 1)
                showMessageDialog(Color.NONE, "You Win!", Color.GREEN, 75);
            else
                showMessageDialog(Color.NONE, "Game Over", Color.RED, 75);
            
            return;
        }
        else if (!hasEmptyCell()) {
            isGameStopped = true;
            showMessageDialog(Color.NONE, " Draw!",  Color.BLUE, 75);
            return;
        }
    }
    
    public void updateView() {
        for (int i = 0; i < model.length; i++) {
            for (int j = 0; j < model[i].length; j++) {
                updateCellView(i, j, model[i][j]);
            }
        }
    }
    
    public void updateCellView(int x, int y, int value) {
        String text = " ";
        Color cellColor = Color.WHITE;
        Color textColor = Color.WHITE;
        if (value == 1) {
            text = "X";
            textColor = Color.RED;
        }
        else if (value == 2) {
            text = "O";
            textColor = Color.BLUE;
        }
        setCellValueEx(x, y, cellColor, text, textColor);
    }

}

/* 
   Coded by Odelola Josh on 12/9/2019
**/

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Game extends JFrame {

    // indicate which player has a turn;
    // default is X player
    private char whoseTurn = 'X';

    // Create and initialize cells
    private Cell[][] cells = new Cell[3][3];

    // Create and initialize a statsu label
    private JLabel jlblStatus = new JLabel("X's turn to play");

    // Initialize UI
    public Game() {
        // panel p to hold cells
        JPanel p = new JPanel(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                p.add(cells[i][j] = new Cell());
            }
        }

        // Set line borders on the cells' panel and the status label
        p.setBorder(new LineBorder(Color.RED, 1));
        jlblStatus.setBorder(new LineBorder(Color.YELLOW, 1));

        // Place the panel and the label for the applet
        add(p, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);


    }

    /**
     * Determine whether the cells are all occupied
     */
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cell[i][j].getToken() == ' ')
                    return false;
            }
        }
        return true;
    }

    /** Determine whwther the player with the specified token wins*/
    public boolean isWon(char token) {
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0].getToken() == token) &&
                    (cells[i][1].getToken() == token) &&
                    (cells[i][2].getToken() == token)) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if ((cells[0][i].getToken() == token) &&
                    (cells[2][i].getToken() == token) &&
                    (cells[3][i].getToken() == token)) {
                return true;
            }
        }

        if ((cells[0][0].getToken() == token)
                && (cells[1][1].getToken() == token)
                && (cells[2][2].getToken() == token)) {
            return true;
        }

        if ((cells[0][2].getToken() == token)
                && (cells[1][1].getToken() == token)
                && (cells[2][0].getToken() == token)) {
            return true;
        }

        return false;
    }

    // An innder class for a cell
    public class Cell extends JPanel {
        // Token used for this Cell
        private char token = ' ';

        public Cell() {a
            setBorder(new LineBorder(Color.BLACK, 1));
            addMouseListener(new MyMouseListener());
        }

        /** Return token */
        public char getToken() {
            return token;
        }

        /** Set token */
        public void setToken(char token) {
            this.token = token;
            repaint();
        }



    }

}

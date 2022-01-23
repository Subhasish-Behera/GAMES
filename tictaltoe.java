//package com.greendoor;
/*
/*String [] myStrings  = {
  "alpha",
  "beta",
  "gamma",
  "delta"
};

for(String currentString : myStrings) {
  System.out.println(currentString);
}
 */
import java.util.*;
import java.util.Scanner;

public class tictaltoe {
    //declaring global stuff for all functions
    static ArrayList<Integer> player1pos = new ArrayList<Integer>();
    static ArrayList<Integer> player2pos = new ArrayList<Integer>();
    //real matrix to be used in algo
    static char[][] m2DArray = new char[3][3];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
      //layout of the board that will be visible
        char Hash[][] = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        //Random rand = new Random();
        //initializing real matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m2DArray[i][j] = ' ';
            }

        }
        //showboard(Hash);
        RULES();
        System.out.println("which mode do you want to play");
        System.out.println("1.YOU VS CPU");
        System.out.println("2.2 PLAYERS");
        System.out.println("select 1 or 2");
        int choice=in.nextInt();
        while (true) {

            System.out.println("PLAYER 1,Enter your placement (1-9):");
            int pos1 = in.nextInt();
            placing(pos1, Hash, 1);
            // setrealmatrix(pos1, 1, m2DArray);
            checkWinner2();
            if (checkWinner2() == true) {
                if ((player1pos.size() + player2pos.size()) != 9) {
                    System.out.println("player 1 won");
                } else {
                    System.out.println("The game is tied ");
                }
                break;
            }

            //int pos2= rand.nextInt(9)+1;
            if(choice ==1)
            {
                int pos2 =bestscore();
                placing(pos2, Hash, 2);
            }else
            {
                System.out.println("PLAYER 2,Enter your placement (1-9):");
                int pos2 = in.nextInt();
                placing(pos2, Hash, 2);
            }
            // System.out.println(pos1);
//    placing(pos1,Hash,1);
//    checkwinner();

            // setrealmatrix(pos2, 2, m2DArray);
            checkWinner2();
            if (checkWinner2() == true) {
                System.out.println("player 2 won");
                break;
            }
        }

    }

    public static void showboard(char[][] Hash) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(Hash[i][j]);
            }
            System.out.println();
        }

    }

    public static void RULES() {
        System.out.println("INTRODUCTION");
        System.out.println("GAME BOARD");
        System.out.println("1|2|3)");
        System.out.println("-+-+-");
        System.out.println("4|5|6");
        System.out.println("-+-+-");
        System.out.println("7|8|9");
        System.out.println("******");
    }

    public static void placing(int pos, char[][] Hash, int player) {
        char symbol;
        if (player == 1) {
            symbol = 'X';
            player1pos.add(pos);
        } else {
            symbol = 'O';
            player2pos.add(pos);
        }
        switch (pos) {
            case 1:
                Hash[0][0] = symbol;
                m2DArray[0][0] = symbol;


                break;
            case 2:
                Hash[0][2] = symbol;
                m2DArray[0][1] = symbol;
                break;
            case 3:
                Hash[0][4] = symbol;
                m2DArray[0][2] = symbol;
                break;
            case 4:
                Hash[2][0] = symbol;
                m2DArray[1][0] = symbol;
                break;
            case 5:
                Hash[2][2] = symbol;
                m2DArray[1][1] = symbol;
                break;
            case 6:
                Hash[2][4] = symbol;
                m2DArray[1][2] = symbol;
                break;
            case 7:
                Hash[4][0] = symbol;
                m2DArray[2][0] = symbol;
                break;
            case 8:
                Hash[4][2] = symbol;
                m2DArray[2][1] = symbol;
                break;
            case 9:
                Hash[4][4] = symbol;
                m2DArray[2][2] = symbol;
                break;
        }
        showboard(Hash);
    }

    public static boolean checkwinner() {
        if ((player1pos.size() + player2pos.size()) == 9) {
            System.out.println("The game is tied ");
            return true;
        }
        List zerorow = Arrays.asList(1, 2, 3);
        List onerow = Arrays.asList(4, 5, 6);
        List tworow = Arrays.asList(7, 8, 9);
        List zerocol = Arrays.asList(1, 4, 7);
        List onecol = Arrays.asList(2, 5, 8);
        List twocol = Arrays.asList(3, 6, 9);
        List dig1 = Arrays.asList(1, 5, 9);
        List dig2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(zerorow);
        winning.add(onerow);
        winning.add(tworow);
        winning.add(zerorow);
        winning.add(onecol);
        winning.add(twocol);
        winning.add(dig1);
        winning.add(dig2);

        for (List l : winning) {
            if (player1pos.containsAll(l)) {
                System.out.println("player 1 won");
                return true;
            } else if (player2pos.containsAll(l)) {
                System.out.println("player 2 won");
                return true;
            }

        }
        return false;
    }

    public static void setrealmatrix(int pos, int player,char[][] matrix ) {
        char symbol;
        if (player == 1) {
            symbol = 'X';
            player1pos.add(pos);
        } else {
            symbol = 'O';
            player2pos.add(pos);
        }
        switch (pos) {
            case 1:
                matrix[0][0] = symbol;
                break;
            case 2:
                matrix[0][1] = symbol;
                break;
            case 3:
                matrix[0][2] = symbol;
                break;
            case 4:
                matrix[1][0] = symbol;
                break;
            case 5:
                matrix[1][2] = symbol;
                break;
            case 6:
                matrix[1][2] = symbol;
                break;
            case 7:
                matrix[2][0] = symbol;
                break;
            case 8:
                matrix[2][1] = symbol;
                break;
            case 9:
                matrix[2][2] = symbol;

        }
    }



    public static int bestscore() {
        // AI to make its turn
        int bestScore = Integer.MIN_VALUE;
        int[] move = {0, 0};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Is the spot available?
                if (m2DArray[i][j] == ' ') {
                    m2DArray[i][j] = 'X';
                    int score = minimax( 0, true);
                    m2DArray[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;

                    }
                }
            }
        }
        m2DArray[move[0]][move[1]] = 'X';
        //currentPlayerIsHuman = true;
        return converm2DArray_to_integerinput(move[0],move[1]);
    }

    public static int minimax(int depth, boolean isMaximizing) {
        int utility;
        if (checkWinner2() == true) {
            if (isMaximizing == true) {
                utility = (1) * (sizeof2Darray() + 1);
            } else {
                utility = (-1) * (sizeof2Darray() +1);
            }
            return utility;
        }
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Is the spot available?
                    if (m2DArray[i][j] == ' ') {
                        m2DArray[i][j] = 'X';
                        int score = minimax( depth + 1, false);
                        m2DArray[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Is the spot available?
                    if (m2DArray[i][j] == ' ') {
                        m2DArray[i][j] = 'O';
                        int score = minimax( depth + 1, true);
                        m2DArray[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }

    }

    public static int sizeof2Darray() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Is the spot available?
                if (m2DArray[i][j] == ' ') {
                    count++;

                }
            }
        }
        return count;
    }

    public static boolean checkWinner2() {
        if ((player1pos.size() + player2pos.size()) == 9) {
            System.out.println("The game is tied ");
            return true;
        }
        char a = m2DArray[0][0];
        char b = m2DArray[1][1];
        char c = m2DArray[2][2];
        char d = m2DArray[0][2];
        char e = m2DArray[2][0];
        for (int i = 0; i < 3; i++) {
            char x = m2DArray[i][0];
            char y = m2DArray[i][1];
            char z = m2DArray[i][2];


            if ((x == y && y == z && z == x) && (x != ' ') && (y != ' ') && (z != ' ')) {
                return true;
            }
        }

        // Vertical
        for (int i = 0; i < 3; i++) {
            char p = m2DArray[0][i];
            char q = m2DArray[1][i];
            char r = m2DArray[2][i];
            if ((p == q && q == r && p == r) && (p != ' ') && (q != ' ') && (r != ' ')) {
                return true;
            }
        }


        // Diagonal
        if (((a == b && b == c) && (a != ' ') && (b != ' ') && (c != ' ')) || ((d == b && b == e) && (d != ' ') && (b != ' ') && (e != ' '))) {
            return true;
        }
        return false;
    }

    public static int converm2DArray_to_integerinput(int i,int j){
        if(i==0&&j==0)
        {
            return 1;
        }
        if(i==0&&j==1)
        {
            return 2;
        }
        if(i==0&&j==2)
        {
            return 3;
        }
        if(i==1&&j==0)
        {
            return 4;
        }
        if(i==1&&j==1)
        {
            return 5;
        }
        if(i==1&&j==2)
        {
            return 6;
        }
        if(i==2&&j==0)
        {
            return 7;
        }
        if(i==2&&j==1)
        {
            return 8;
        }

            return 9;


    }
}

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
    static ArrayList<Integer> player1pos=new ArrayList<Integer>();
    static ArrayList<Integer> player2pos=new ArrayList<Integer>();
    //real matrix to be used in algo
    static char[][] m2DArray = new char[3][3];

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);

        char Hash[][]={{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        //Random rand = new Random();
        //initializing real matrix
        for(int i=0;i<3;i++)
        {for(int j=0;j<3;j++)
        {
            m2DArray[i][j]=' ';
        }

        }
        //showboard(Hash);
        RULES();

        while(true)
        {
            System.out.println("PLAYER 1,Enter your placement (1-9):");
            int  pos1=in.nextInt();
            placing(pos1,Hash,1);
            setrealmatrix( pos1,1, m2DArray);
            checkwinner();
            if(checkwinner()==true)
            {
                break;
            }
            //int pos2= rand.nextInt(9)+1;
            System.out.println("PLAYER 2,Enter your placement (1-9):");
            int pos2=in.nextInt();
            // System.out.println(pos1);
//    placing(pos1,Hash,1);
//    checkwinner();
            placing(pos2,Hash,2);
            setrealmatrix( pos2,2, m2DArray);
            checkwinner();
            if(checkwinner()==true)
            {
                break;
            }
        }

    }
    public static void showboard(char[][] Hash)
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(Hash[i][j]);
            }
            System.out.println();
        }

    }
    public static void RULES()
    { System.out.println("INTRODUCTION");
        System.out.println("GAME BOARD");
        System.out.println("1|2|3)");
        System.out.println("-+-+-");
        System.out.println("4|5|6");
        System.out.println("-+-+-");
        System.out.println("7|8|9");
        System.out.println("******");
    }
    public static void placing(int pos,char[][] Hash,int player)
    {  char symbol;
        if(player==1)
        {
            symbol='X';
            player1pos.add(pos);
        }
        else
        {
            symbol='O';
            player2pos.add(pos);
        }
        switch (pos)
        {
            case 1:
                Hash[0][0]=symbol;
                break;
            case 2:
                Hash[0][2]=symbol;
                break;
            case 3:
                Hash[0][4]=symbol;
                break;
            case 4:
                Hash[2][0]=symbol;
                break;
            case 5:
                Hash[2][2]=symbol;
                break;
            case 6:
                Hash[2][4]=symbol;
                break;
            case 7:
                Hash[4][0]=symbol;
                break;
            case 8:
                Hash[4][2]=symbol;
                break;
            case 9:
                Hash[4][4]=symbol;
                break;
        }
        showboard(Hash);
    }
    public static boolean  checkwinner() {
        List zerorow=Arrays.asList(1,2,3);
        List onerow=Arrays.asList(4,5,6);
        List tworow=Arrays.asList(7,8,9);
        List zerocol=Arrays.asList(1,4,7);
        List onecol=Arrays.asList(2,5,8);
        List twocol=Arrays.asList(3,6,9);
        List dig1=Arrays.asList(1,5,9);
        List dig2=Arrays.asList(7,5,3);

        List<List> winning=new ArrayList<List>();
        winning.add(zerorow);
        winning.add(onerow);
        winning.add(tworow);
        winning.add(zerorow);
        winning.add(onecol);
        winning.add(twocol);
        winning.add(dig1);
        winning.add(dig2);

        for(List l:winning)
        {
            if(player1pos.containsAll(l))
            {
                System.out.println("player 1 won");
                return true;
            }
            else if(player2pos.containsAll(l))
            {
                System.out.println("player 2 won");
                return true;
            }

        }
        return false;
    }
    public static void setrealmatrix(int pos,int player,char[][] matrix) {
        char symbol;
        if(player==1)
        {
            symbol='X';
            player1pos.add(pos);
        }
        else
        {
            symbol='O';
            player2pos.add(pos);
        }
        switch (pos)
        {
            case 1:
                matrix[0][0]=symbol;
                break;
            case 2:
                matrix[0][1]=symbol;
                break;
            case 3:
                matrix[0][2]=symbol;
                break;
            case 4:
                matrix[1][0]=symbol;
                break;
            case 5:
                matrix[1][2]=symbol;
                break;
            case 6:
                matrix[1][2]=symbol;
                break;
            case 7:
                matrix[2][0]=symbol;
                break;
            case 8:
                matrix[2][1]=symbol;
                break;
            case 9:
                matrix[2][2]=symbol;

        }
    }
    public static void bestmove(char[][] m2DArray ) {
        for (int i = 0; i < 3; i++) {
            for (int i = 0; i < 3; i++) {

            }
        }
    }
    public static void MINMAX(char[][] m2DArray ){
        // AI to make its turn
        int bestScore = Integer.MIN_VALUE;
        int[] move = {0, 0};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Is the spot available?
                if (m2DArray[i][j] == ' ') {
                    m2DArray[i][j] = ai;
                    int score = minimax(m2DArray, 0, false);
                    m2DArray[i][j] = (char)0;
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        m2DArray[move[0]][move[1]] = ai;
        currentPlayerIsHuman = true;
    }
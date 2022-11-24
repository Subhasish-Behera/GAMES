//package com.greendoor;
/*
//this is PR1
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

public class tictactoe {
    static ArrayList<Integer> player1pos=new ArrayList<Integer>();
    static ArrayList<Integer> player2pos=new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);

        char Hash[][]={{' ','|',' ','|',' '},
                       {'-','+','-','+','-'},
                       {' ','|',' ','|',' '},
                       {'-','+','-','+','-'},
                       {' ','|',' ','|',' '}};
        //Random rand = new Random();

        //showboard(Hash);
        RULES();

while(true)
{
    System.out.println("PLAYER 1,Enter your placement (1-9):");
    int  pos1=in.nextInt();
    placing(pos1,Hash,1);
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
        if((player1pos.size()+player2pos.size())==9)
        {
            System.out.println("The game is tied ");
            return true;
        }
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
        winning.add(zerocol);
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
             if(player2pos.containsAll(l))
            {
                System.out.println("player 2 won");
                return true;
            }

         }
        return false;
    }
    }

package GamePkg;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ttt {
    String Scores;
    HashMap<String, Integer> ternary_decimal;
    Random rng;
    boolean uTeam; // for user team;
    String uName;
    short uScore;
    boolean[] uMoves;
    boolean wTeam; // for winning team lmaooo if yo ucatch my drift.
    short wScore;
    boolean[] wMoves;

    //rly long line coming up. My editor wraps, and if yours doesn't...
    //that's tough, man (or whatever gender u are--not the point).
    public ttt() {
        this.Scores = "000010020011012 002010022011012 100110120111112 102110122111112 200210220211212 202210222211212 000001002011010 020001022011021 100101102111121 120101122111121 200201202211221 220201222211221 000100200110120 020100220110120 001101201111121 021101221111121 002102202112122 022102222112122 000010020110210 200010220110210 001011021111211 201011221111211 002012022112212 202012222112212 000100200101102 002100202101102 010110210111112 012110212111112 020120220121122 022120222121122 000001002101201 200001202101201 010011012111211 210011212111211 020021022121221 220021222121221 000100200110101 002102202112101 022122222121112 000100200101110 020120220121110 022122222112121 000010020011110 200210220211110 002102022112011 202212222112211";

        this.ternary_decimal = new HashMap<String, Integer>(36);
        this.ternary_decimal.put("000", 0);
        this.ternary_decimal.put("001", 1);
        this.ternary_decimal.put("002", 2);
        this.ternary_decimal.put("010", 3);
        this.ternary_decimal.put("011", 4);
        this.ternary_decimal.put("012", 5);
        this.ternary_decimal.put("020", 6);
        this.ternary_decimal.put("021", 7);
        this.ternary_decimal.put("022", 8);
        this.ternary_decimal.put("100", 9);
        this.ternary_decimal.put("101", 10);
        this.ternary_decimal.put("102", 11);
        this.ternary_decimal.put("110", 12);
        this.ternary_decimal.put("111", 13);
        this.ternary_decimal.put("112", 14);
        this.ternary_decimal.put("120", 15);
        this.ternary_decimal.put("121", 16);
        this.ternary_decimal.put("122", 17);
        this.ternary_decimal.put("200", 18);
        this.ternary_decimal.put("201", 19);
        this.ternary_decimal.put("202", 20);
        this.ternary_decimal.put("210", 21);
        this.ternary_decimal.put("211", 22);
        this.ternary_decimal.put("212", 23);
        this.ternary_decimal.put("220", 24);
        this.ternary_decimal.put("221", 25);
        this.ternary_decimal.put("222", 26);

        this.uTeam = false;
        this.wTeam = true;

        {
            Scanner getUName = new Scanner(System.in);
            System.out.print("Player Name: u<");
            this.uName = "u<" + getUName.nextLine();
            getUName.close();
        }
    }

    public boolean set_uMove(String ter) {
        try {
            if (this.wMoves[ternary_decimal.get(ter)] || this.uMoves[ternary_decimal.get(ter)]) {
                return false;
            }
            this.uMoves[ternary_decimal.get(ter)] = true;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
    
    public boolean set_wMove() {
        //TODO: Implement
        return false;
    }

    public boolean instantiateW_DuplicateCheck(String ter) {
        try {
            if (this.wMoves[ternary_decimal.get(ter)] ||
            this.uMoves[ternary_decimal.get(ter)]) {
                return false;
            }
            this.wMoves[ternary_decimal.get(ter)] = true;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    class Byte2 {
        byte b1;
        byte b2;

        public Byte2(byte b1, byte b2) {
            this.b1 = b1;
            this.b2 = b2;
        }
        
        @Override
        public String toString() {
            return Byte.toString(b1)+" "+Byte.toString(b2);
        }
    }

    public boolean checkForDuplicates(){
        System.out.println("begDup");
        int numChecks = 0;
        Scanner scChk = new Scanner(this.Scores);
        while (scChk.hasNext()) {
            numChecks++;
            scChk.next();
        }
        ArrayList<Byte2> retAL = new ArrayList<Byte2>();
        scChk.close();
        System.out.println(
                "Number of checks required: " + (int) Math.pow((numChecks), 2)
                + ". Press <ENTER> to continue.");
        int check=0;
        for (byte i = 0; i < numChecks; i++) {
            Scanner d1 = new Scanner(this.Scores);
            StringBuilder sbd1 = new StringBuilder();
            Scanner d2 = new Scanner(this.Scores);
            StringBuilder sbd2 = new StringBuilder();
            this.uMoves = new boolean[10];
            this.wMoves = new boolean[10];
            for (int j = 0; j < i; j++) {
                sbd1 = new StringBuilder(d1.next());
            }
            String ter1, ter2;
            for (byte m = 0; m < sbd1.length() % 3; m++) {
                ter1 = sbd1.substring(m * 3, m * 3 + 3);
                set_uMove(ter1);
            }
            for (byte k = 0; k < numChecks; k++) {
                sbd2 = new StringBuilder(d2.next());
                for (int l = 0; l < sbd2.length() % 3; l++) {
                    ter2 = sbd2.substring(l * 3, l * 3 + 3);
                    instantiateW_DuplicateCheck(ter2);
                }
                System.out.println(++check);
                if (this.wMoves.equals(this.uMoves)) {
                    retAL.add(new Byte2(i, k));
                }
            }
        }
        System.out.println("checked "+(int)Math.sqrt(check) + " separate scoring patterns. Overlaps are as follows: ");
        String retString = retAL.toString();
        System.out.println(retString);
        return retAL.size() != 0;
    }

    public static void main(String[] args) {
        new ttt().checkForDuplicates();
    }
}
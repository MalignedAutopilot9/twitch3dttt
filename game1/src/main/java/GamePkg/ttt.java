package GamePkg;

import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.sql.Time;
import java.time.*;

public class ttt {
    String Scores;
    HashMap<String, Integer> ternary_decimal;
    Random rng;
    boolean uTeam; //for user team;
    String uName;
    boolean wTeam; //for winning team lmaooo if yo ucatch my drift.
    private ttt() {
        this.Scores = "000010020011012 002010022011012 100110120111112 102110122111112 200210220211212 202210222211212 000001002011010 020001022011021 100101102111121 120101122111121 200201202211221 220201222211221 000100200110120 020100220110120 001101201111121 021101221111121 002102202112122 022102222112122 000010020110210 200010220110210 001011021111211 201011221111211 002012022112212 202012222112212 000100200101102 002100202101102 010110210111112 012110212111112 020120220121122 022120222121122 000001002101201 200001202101201 010011012111211 210011212111211 020021022121221 220021222121221 000100200110101 002102202112101 022122222121112 000100200101110 020120220121110 022122222112121 000010020011110 200210220211110 002102022112011 202212222112211";

        this.ternary_decimal = new HashMap<String, Integer>(36);

        this.rng = new Random(Time.from(Instant.EPOCH).getTime());
        this.uTeam = rng.nextBoolean();
        this.wTeam = !uTeam;

        {
            Scanner getUName = new Scanner(System.in);
            this.uName = getUName.nextLine();
            getUName.nextLine();
            getUName.close();
        }
        


    }

    

}
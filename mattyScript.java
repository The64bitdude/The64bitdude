package length;

import java.util.*;

public class mattyScript {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 5 ; i++){
        Scanner TS = new Scanner(System.in);
        String ST = TS.next();
        switch(ST.toLowerCase()) {
        case "king" :
            System.out.println("please enter password (Its 1234)");
            String KS = TS.next();
            if(KS.equals("1234")) {
                System.out.println("Welcome Guard Instructor");
            };break;
        case "pham" :
            System.out.println("Please enter password (Its 2134");
            String PS = TS.next();
            if (PS.equals("2134")) {
                System.out.println("Welcome Guard Instructor");
            }
        case "matt" :
            System.out.println("Please enter password");
            String MS = TS.next();
            if(MS.equals("2023")) {
                System.out.println("Welcome Matt");
            }
            }

        }
    }

}
package com.gary.dida;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        TimeMeterDemo timeMeter1 = new TimeMeterDemo("第一个", 1000);
        TimeMeterDemo timeMeter2 = new TimeMeterDemo("第二个", 1500);

        Scanner in = new Scanner(System.in);
        String message = "";
        while (!message.equalsIgnoreCase("x")) {
            message = in.nextLine();
            if (message.equalsIgnoreCase("st")) {
                timeMeter1.startTimeMeter();
                timeMeter2.startTimeMeter();
            } else if (message.equalsIgnoreCase("sp")) {
                timeMeter1.stopTimeMeter();
                timeMeter2.stopTimeMeter();
            }
        }

        in.close();
    }
}

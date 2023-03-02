package OJOJO;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main extends Sygnalling {

    public static void main(String[] args) {
        
        SygnallingNorth north = new SygnallingNorth();
        SygnallingEast east = new SygnallingEast();
        SygnallingSouth south = new SygnallingSouth();
        SygnallingWest west = new SygnallingWest();

        while (true) {
            System.out.println("Kolizyjne północ:" + north.getColorNorth() + "        Przejście dla pieszych " +
                    "północ: " + north.getColorPedestrianNorth());
            System.out.println("Kolizyjne wschód:" + east.getColorEast() + "          Strzałka warunkowa zachód: " + east.getColorConditionalRightArrowEast());
            System.out.println("Bezkolizyjne wschód:" + east.getColorLeftArrowEast());
            System.out.println("Kolizyjne południe:" + south.getColorSouth() + "      Przejście dla pieszych " +
                    "południe : " + south.getColorPedestrianSouth());
            System.out.println("Kolizyjne zachód:" + west.getColorWest() + "          Przejście dla pieszych  zachód:" +
                    " " + west.getColorPedestrianWest());
            System.out.println("Bezkolizyjne zachód:" + west.getColorLeftArrowWest());
            System.out.println("---------------------------------------------------------------------------");
            try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }


            if(east.colorEast.equals(color.RED) && west.colorWest.equals(color.RED) ) {
                north.nextColor();
            }
            if(north.colorNorth.equals(color.RED) && south.colorSouth.equals(color.RED)) {
                east.nextColor();
            }
            if(east.colorEast.equals(color.RED) && west.colorWest.equals(color.RED)) {
                south.nextColor();
            }
            if(north.colorNorth.equals(color.RED) && south.colorSouth.equals(color.RED)) {
                west.nextColor();
            }
            if(south.colorSouth.equals(color.RED) && north.colorNorth.equals(color.RED) && south.colorPedestrianSouth.equals(color.RED)) {
                west.nextColorArrow();
            }
            if(west.colorLeftArrowWest.equals(color.RED) && north.colorNorth != color.RED) {
                north.nextColorPedestrian();
            }
            if(west.colorLeftArrowWest.equals(color.RED) && east.colorEast != color.GREEN ) {
                east.nextColorConditionalArrow();
            }
            if(west.colorWest.equals(color.RED) && north.colorNorth.equals(color.RED) && south.colorSouth != color.GREEN && south.colorPedestrianSouth.equals(color.RED)) {
                east.nextColorArrow();
            }
            if(west.colorLeftArrowWest.equals(color.RED)) {
                south.nextColorPedestrian();
            }

            if(east.colorEast.equals(color.RED) && west.colorWest.equals(color.RED) && west.colorLeftArrowWest.equals(color.RED)) {
                west.nextColorPedestrian();
            }
            }
        }
    }


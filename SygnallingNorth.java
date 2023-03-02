package OJOJO;


public class SygnallingNorth extends Sygnalling {
    public color getColorNorth(){
        return colorNorth;
    }
    public color getColorPedestrianNorth(){
        return colorPedestrianNorth;
    }
    private final boolean isCarNorth = true;
    private final boolean isPedestrianNorth = true;
    public color colorNorth;
    public color colorPedestrianNorth;
    private color colorPreviousNorth;
    public SygnallingNorth(){
        colorNorth = color.RED;
        colorPedestrianNorth = color.RED;
        colorPreviousNorth = color.NONE;
    }

    public void nextColor() {
        if (isCarNorth) {
            switch (colorNorth) {
                case RED, GREEN -> {
                    colorPreviousNorth = colorNorth;
                    colorNorth = color.YELLOW;

                }
                case YELLOW -> {

                    if (colorPreviousNorth.equals(color.RED)) {
                        colorNorth = color.GREEN;
                    } else {
                        colorNorth = color.RED;
                    }
                }
            }
        } else {
            colorNorth = color.RED;
        }
    }
        public void nextColorPedestrian() {
        if (isPedestrianNorth) {
            switch (colorPedestrianNorth) {
                case RED ->{
                    if (colorNorth.equals(color.RED)) {
                        colorPedestrianNorth = color.GREEN;
                    }
                }
                case GREEN ->{
                    if (colorNorth != color.RED) {
                        colorPedestrianNorth = color.RED;
                    }
            }
            }
        }
        }
    }




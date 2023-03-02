package OJOJO;


public class SygnallingSouth extends Sygnalling {
    public color getColorSouth() {
        return colorSouth;
    }

    public color getColorPedestrianSouth() {
        return colorPedestrianSouth;
    }

    private boolean isCarSouth = true;
    private boolean isPedestrianSouth = false;
    public color colorSouth;
    public color colorPedestrianSouth;
    private color colorPreviousSouth;

    public SygnallingSouth() {
        colorSouth = color.RED;
        colorPedestrianSouth = color.RED;
        colorPreviousSouth = color.NONE;
    }



    public void nextColor() {
        if (isCarSouth){
            switch (colorSouth) {
                case RED, GREEN -> {
                    colorPreviousSouth = colorSouth;
                    colorSouth = color.YELLOW;

                }

                case YELLOW -> {

                    if (colorPreviousSouth.equals(color.RED)) {
                        colorSouth = color.GREEN;
                    } else {
                        colorSouth = color.RED;

                    }
                }


            }
        }
    }
        public void nextColorPedestrian() {
            if (isPedestrianSouth) {
                switch (colorPedestrianSouth) {
                    case RED -> {
                        if (colorSouth.equals(color.RED)) {
                            colorPedestrianSouth = color.GREEN;
                        }
                    }
                    case GREEN -> {
                        if (colorSouth.equals(color.YELLOW)) {
                            colorPedestrianSouth = color.RED;
                        }
                    }
                }
            } else {
                colorPedestrianSouth = color.RED;

            }
        }
    }





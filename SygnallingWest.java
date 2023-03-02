package OJOJO;

import java.util.concurrent.TimeUnit;

    public class SygnallingWest extends Sygnalling {

        public color getColorWest() {
            return colorWest;
        }

        public color getColorLeftArrowWest() {
            return colorLeftArrowWest;
        }

        public color getColorPedestrianWest() {
            return colorPedestrianWest;
        }

        public boolean isCarWest = true;
        public boolean isCarArrowWest = true;
        public boolean isPedestrianWest = true;
        public color colorWest;
        public color colorLeftArrowWest;
        private color colorPedestrianWest;
        private color colorPreviousWest;
        private color colorPreviousLeftArrowWest;

        public SygnallingWest() {
            colorWest = color.RED;
            colorLeftArrowWest = color.RED;
            colorPedestrianWest = color.RED;
            colorPreviousWest = color.NONE;
            colorPreviousLeftArrowWest = color.NONE;
        }



        public void nextColor() {
            if (isCarWest) {
                switch (colorWest) {
                    case RED, GREEN -> {
                        colorPreviousWest = colorWest;
                        colorWest = color.YELLOW;

                    }

                    case YELLOW -> {
                        if (colorPreviousWest.equals(color.RED)) {
                            colorWest = color.GREEN;

                        } else {
                            colorWest = color.RED;
                        }
                    }
                }
            }else {
                    colorWest = color.RED;

                }


            }

            public void nextColorArrow() {
                if (isCarArrowWest) {
                    switch (colorLeftArrowWest) {

                        case RED, GREEN -> {
                            colorPreviousLeftArrowWest = colorLeftArrowWest;
                            colorLeftArrowWest = color.YELLOW;


                        }

                        case YELLOW -> {

                            if (colorPreviousLeftArrowWest.equals(color.RED)) {
                                colorLeftArrowWest = color.GREEN;
//
                            } else {
                                colorLeftArrowWest = color.RED;
//
                            }
                        }
                    }
                } else {
                    colorLeftArrowWest = color.RED;

                    }
                }

        public void nextColorPedestrian() {
            if (isPedestrianWest) {
                switch (colorPedestrianWest) {
                    case RED-> {
                        if (colorWest.equals(color.RED)) {
                            colorPedestrianWest = color.GREEN;
                        }
                    }
                    case GREEN ->{
                        if (colorWest != color.RED) {
                            colorPedestrianWest = color.RED;
                        }
                    }
                }
            } else {
                colorPedestrianWest = color.RED;


            }

        }
    }


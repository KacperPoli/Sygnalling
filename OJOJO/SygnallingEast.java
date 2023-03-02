
package OJOJO;

        import java.util.concurrent.TimeUnit;

public class SygnallingEast extends Sygnalling {
    public color getColorEast() {
        return colorEast;
    }

    public color getColorLeftArrowEast() {
        return colorLeftArrowEast;
    }

    public color getColorConditionalRightArrowEast() {
        return colorConditionalRightArrowEast;
    }

    private boolean isCarEast = true;
    private boolean isCarArrowEast = true;
    public color colorEast;
    public color colorLeftArrowEast;
    private color colorConditionalRightArrowEast;
    private color colorPreviousEast;
    private color colorPreviousLeftArrowEast;

    public SygnallingEast() {
        colorEast = color.RED;
        colorLeftArrowEast = color.RED;
        colorConditionalRightArrowEast = color.NONE;
        colorPreviousEast = color.NONE;
        colorPreviousLeftArrowEast = color.NONE;
    }


    public void nextColor() {
        if (isCarEast) {
            switch (colorEast) {
                case RED, GREEN -> {
                    colorPreviousEast = colorEast;
                    colorEast = color.YELLOW;

                }

                case YELLOW -> {

                    if (colorPreviousEast.equals(color.RED)) {
                        colorEast = color.GREEN;

                    } else {
                        colorEast = color.RED;

                    }
                }

            }
        } else {
            colorEast = color.RED;
        }
    }
        public void nextColorArrow() {
            if (isCarArrowEast) {
                switch (colorLeftArrowEast) {
                    case RED, GREEN -> {
                        colorPreviousLeftArrowEast = colorLeftArrowEast;
                        colorLeftArrowEast = color.YELLOW;



                    }
                    case YELLOW -> {

                        if (colorPreviousLeftArrowEast.equals(color.RED)) {
                            colorLeftArrowEast = color.GREEN;

                        } else {
                            colorLeftArrowEast = color.RED;

                        }
                    }

                }
            } else {

                }
                colorLeftArrowEast = color.RED;
            }
    public void nextColorConditionalArrow() {
        if (isCarArrowEast) {
            switch (colorConditionalRightArrowEast) {
                case NONE ->{
                    if (colorEast.equals(color.RED)) {
                        colorConditionalRightArrowEast = color.GREEN;
                    } }
                case GREEN ->{
                    if (colorEast.equals(color.GREEN)) {
                        colorConditionalRightArrowEast = color.NONE;
                    }}

            }
        } else {
            colorConditionalRightArrowEast = color.NONE;
        }
    }
}


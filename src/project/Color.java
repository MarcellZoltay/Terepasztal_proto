package project;

/**
 * 
 */
public enum Color {
    ENGINE,
    COAL_CAR,
    BLUE,
    RED,
    GREEN,
    YELLOW,
    PINK,
    BLUE_GRAY,
    RED_GRAY,
    GREEN_GRAY,
    YELLOW_GRAY,
    PINK_GRAY;

    public Color opposit() {
        switch(this) {
            case BLUE: return Color.BLUE_GRAY;
            case RED: return Color.RED_GRAY;
            case GREEN: return Color.GREEN_GRAY;
            case YELLOW: return Color.YELLOW_GRAY;
            case PINK: return Color.PINK_GRAY;
            case BLUE_GRAY: return Color.BLUE;
            case RED_GRAY: return Color.RED;
            case GREEN_GRAY: return Color.GREEN;
            case YELLOW_GRAY: return Color.YELLOW;
            case PINK_GRAY: return Color.PINK;
            default: return this;
        }
    }

    public boolean isEmpty(){
        switch(this) {
            case BLUE: return false;
            case RED: return false;
            case GREEN: return false;
            case YELLOW: return false;
            case PINK: return false;
            case BLUE_GRAY: return true;
            case RED_GRAY: return true;
            case GREEN_GRAY: return true;
            case YELLOW_GRAY: return true;
            case PINK_GRAY: return true;
            default: return true;
        }
    }

}
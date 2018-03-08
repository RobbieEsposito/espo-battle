package Mechanics;

public class TrainingBuild {
    public enum Build {
        TANK, SWEEPER, SURVIVALIST, BREAKER, SPEEDSTER, WALL, NULL
    }
    
    public static Build stringToBuild(String name) {
        switch (name) {
            case "Breaker":
                return Build.BREAKER;
            case "Wall":
                return Build.WALL;
            case "Speedster":
                return Build.SPEEDSTER;
            case "Tank":
                return Build.TANK;
            case "Sweeper":
                return Build.SWEEPER;
            case "Survivalist":
                return Build.SURVIVALIST;
            default:
                return Build.NULL;
        }
    }

    public static String buildToString(Build build) {
        switch (build) {
            case BREAKER:
                return "Breaker";
            case WALL:
                return "Wall";
            case SPEEDSTER:
                return "Speedster";
            case TANK:
                return "Tank";
            case SWEEPER:
                return "Sweeper";
            case SURVIVALIST:
                return "Survivalist";
            default:
                return "";
        }
    }
}

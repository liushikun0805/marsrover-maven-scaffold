public class Rover {
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    private int x;
    private int y;
    private String direction;

    public void land(Area area, int x, int y, String direction) {
        if (!area.containsPositionX(x)) {
            throw new IllegalArgumentException("x=" + x + " is out of area width " + area.getWidth());
        }
        if (!area.containsPositionY(y)) {
            throw new IllegalArgumentException("y=" + y + " is out of area height " + area.getHeight());
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String getPosition() {
        return "" + this.x + this.y + this.direction;
    }

    public void move(Area area) {
        if (direction.equals("E")) {
            x += 1;
        } else if (direction.equals("W")) {
            x -= 1;
        } else if (direction.equals("N")) {
            y += 1;
        } else {
            y -= 1;
        }
        land(area, this.x, this.y, this.direction);
    }

    public void turnLeft() {
        if (direction.equals("E")) {
            direction = "N";
        } else if (direction.equals("N")) {
            direction = "W";
        } else if (direction.equals("W")) {
            direction = "S";
        } else if (direction.equals("S")) {
            direction = "E";
        }
    }

    public void turnRight() {
        if (direction.equals("E")) {
            direction = "S";
        } else if (direction.equals("S")) {
            direction = "W";
        } else if (direction.equals("W")) {
            direction = "N";
        } else if (direction.equals("N")) {
            direction = "E";
        }
    }
}

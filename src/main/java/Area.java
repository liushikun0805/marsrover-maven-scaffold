public class Area {
    private final int width;
    private final int height;

    public Area(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public boolean containsPositionX(int x) {
        return x <= this.width && x >= 1;
    }

    public boolean containsPositionY(int y) {
        return y <= this.height && y >= 1;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}

public class RoverController {
    private Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String execute(String mission) {
        //String mission = "10,10,5,5,E,M,L,M";
        String[] commands = mission.split(",");
        int areaWidth = Integer.parseInt(commands[0]);
        int areaHeight = Integer.parseInt(commands[1]);
        Area area = new Area(areaWidth, areaHeight);

        int x = Integer.parseInt(commands[2]);
        int y = Integer.parseInt(commands[3]);

        String direction = commands[4];

        rover.land(new Area(areaWidth, areaHeight), x, y, direction);

        for (int i = 5; i < commands.length; i++) {
            moveToCommand(commands[i], area);
        }
        return rover.getPosition();
    }

    public void moveToCommand(String command, Area area) {
        if (command.equals("F")) {
            rover.move(area);
        } else if (command.equals("L")) {
            rover.turnLeft();
        } else {
            rover.turnRight();
        }
    }
}

import static org.fest.assertions.api.Assertions.assertThat;


public class RoverTest {
    public  void should_turn_left(){
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5, Rover.SOUTH);
        String position = rover.getPosition();
        assertThat(position.endsWith("55E"));
    }
}

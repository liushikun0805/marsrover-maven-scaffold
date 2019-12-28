import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_land_the_rover_on_area() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.EAST);
        String position = rover.getPosition();
        assertEquals(position,"55E");
    }

    @Test
    public void should_move_forward_when_direction_to_east() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.EAST);
        rover.move(area);
        String position = rover.getPosition();
        assertEquals(position,"65E");
    }

    @Test
    public void should_move_forward_when_direction_to_west() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.WEST);
        rover.move(area);
        String position = rover.getPosition();
        assertEquals(position,"45W");
    }

    @Test
    public void should_move_forward_when_direction_to_north() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.NORTH);
        rover.move(area);
        String position = rover.getPosition();
        assertEquals(position,"56N");
    }

    @Test
    public void should_move_forward_when_direction_to_south() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.SOUTH);
        rover.move(area);
        String position = rover.getPosition();
        assertEquals(position,"54S");
    }

    @Test
    public void should_turn_left() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.SOUTH);
        rover.turnLeft();
        assertEquals(rover.getPosition(),"55E");

        rover.turnLeft();
        assertEquals(rover.getPosition(),"55N");

        rover.turnLeft();
        assertEquals(rover.getPosition(),"55W");

        rover.turnLeft();
        assertEquals(rover.getPosition(),"55S");
    }

    @Test
    public void should_turn_right() {
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,Rover.SOUTH);
        rover.turnRight();
        assertEquals(rover.getPosition(),"55W");

        rover.turnRight();
        assertEquals(rover.getPosition(),"55N");

        rover.turnRight();
        assertEquals(rover.getPosition(),"55E");

        rover.turnRight();
        assertEquals(rover.getPosition(),"55S");
    }

    @Test
    public void should_execute_batch_commands() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10,10,5,5,E,F,L,F";
        String position = roverController.execute(mission);
        assertEquals(position,"66N");

        mission = "10,10,5,5,W,F,R,F";
        position = roverController.execute(mission);
        assertEquals(position,"46N");


        mission = "10,10,5,5,W,F,R,F,L,L,F";
        position = roverController.execute(mission);
        assertEquals(position,"45S");
    }

    @Test
    public void should_warning_when_land_right_width_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("x=20 is out of area width 10");
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,20,30,Rover.SOUTH);
    }

    @Test
    public void should_warning_when_land_left_width_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("x=0 is out of area width 10");
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,0,30,Rover.SOUTH);
    }

    @Test
    public void should_warning_when_land_up_height_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("y=20 is out of area height 10");
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,10,20,Rover.SOUTH);
    }

    @Test
    public void should_warning_when_land_down_height_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("y=0 is out of area height 10");
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,10,0,Rover.SOUTH);
    }

    @Test
    public void should_warning_when_move_right_width_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("x=11 is out of area width 10");
        Area area = new Area(10,10) ;
        Rover rover = new Rover();
        rover.land(area,10,10,Rover.EAST);
        rover.move(area);

        area = new Area(10,10) ;
        rover = new Rover();
        rover.land(area,1,1,Rover.WEST);
        rover.move(area);
    }

    @Test
    public void should_warning_when_move_left_width_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("x=0 is out of area width 10");
        Area area = new Area(10,10) ;
        Rover rover = new Rover();
        rover.land(area,1,1,Rover.WEST);
        rover.move(area);
    }

    @Test
    public void should_warning_when_move_up_height_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("y=11 is out of area height 10");
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,1,10,Rover.NORTH);
        rover.move(area);
    }

    @Test
    public void should_warning_when_move_down_height_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("y=0 is out of area height 10");
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,1,1,Rover.SOUTH);
        rover.move(area);
    }
}

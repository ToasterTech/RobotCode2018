package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.SetElevatorHeightWithEncoder;
import main.java.frc.team5332.commands.intake.ExpelBlockCommand;
import main.java.frc.team5332.robot.CMap;

public class AutoScaleSameSide extends CommandGroup {

    public AutoScaleSameSide(){

        int angle = (CMap.startingSpot == 'L') ? -90 : 90;
        System.out.println("Angle Set to " + angle);
        addParallel(new SetElevatorHeightWithEncoder(CMap.switchHeight)); //Raise Elevator
        addSequential(new EncoderDrive(CMap.distanceToScaleFromWall)); //Needs to be in Feet
        addSequential(new TurnToAngle(angle)); //Face Scale
        addSequential(new ExpelBlockCommand(), 5); //Tells the Robot that this command takes 5 seconds

    }

}

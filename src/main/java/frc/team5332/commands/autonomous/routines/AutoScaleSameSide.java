package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.elevator.TimeElevator;
import main.java.frc.team5332.robot.CMap;


public class AutoScaleSameSide extends CommandGroup {

    public AutoScaleSameSide(char robotPosition){

        SmartDashboard.putString("DB/String 5", "Auto Scale Same Side Running");

        int turnMultiplier = (robotPosition == 'L') ? 1 : -1;

        //addParallel(new TimeElevator(4, -0.5));
        addSequential(new TimeDrive(1.5, 1, 1));
        addSequential(new TimeDrive(0.5, 0, 0));
        addSequential(new TimeElevator(2, -1));
        addSequential(new TimeDrive(1, 0.3 * turnMultiplier, -0.3 * turnMultiplier));
        addSequential(new TimeDrive(2, 0.2, 0.2));
        addSequential(new TimeExpelBlockCommand(2));


        //int angle = (CMap.startingSpot == 'L') ? -90 : 90;
        //System.out.println("Angle Set to " + angle);
        //addParallel(new SetElevatorHeightWithEncoder(CMap.switchHeight)); //Raise Elevator
        //addSequential(new EncoderDrive(CMap.distanceToScaleFromWall)); //Needs to be in Feet
        //addSequential(new TurnToAngle(angle)); //Face Scale
        //addSequential(new ExpelBlockCommand(), 5); //Tells the Robot that this command takes 5 seconds

    }



}

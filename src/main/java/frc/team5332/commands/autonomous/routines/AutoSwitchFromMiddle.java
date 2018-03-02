package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.TimeElevator;
import main.java.frc.team5332.robot.CMap;

public class AutoSwitchFromMiddle extends CommandGroup {

    public AutoSwitchFromMiddle(char platePosition){
        System.out.println("AUTO SWITCH MIDDLE");


        SmartDashboard.putString("DB/String 5", "Auto Switch From Middle");

        addParallel(new TimeElevator(2, -0.5)); //Raise Elevator
        addSequential(new TimeDrive(1, 0.5, 0.5)); //Drive halfway to switch
        addSequential(new TimeDrive(0.5, 0, 0)); //Stop to Reduce Bumpiness
        if(platePosition == 'L') {
            addSequential(new TimeDrive(0.85, -0.3, 0.3)); //Turn to Left Plate
        } else {
            addSequential(new TimeDrive(0.85, 0.3, -0.3)); //Turn to right Plate
        }
        addSequential(new TimeDrive(0.5, 0, 0)); //Stop again
        addSequential(new TimeDrive(1, 0.5, 0.5)); //Drive Straight
        addSequential(new TimeDrive(0.5, 0, 0)); //Stop
        if(platePosition == 'L') {
            addSequential(new TimeDrive(0.85, 0.3, -0.3)); //Turn Again
        } else {
            addSequential(new TimeDrive(0.85, -0.3, 0.3)); //Turn Again
        }
        addSequential(new TimeDrive(1, 0.3, 0.3)); //Drive into Switch
        addSequential(new TimeExpelBlockCommand(3));
        //addSequential(new TimeDrive(1, 0.3, -0.3));
        //addSequential(new TimeDrive(2, 0.2, 0.2));
        //addSequential(new TimeExpelBlockCommand(2));

        /*
        int firstTurnAngle = (CMap.plateOwnership.charAt(0) == 'L') ? 90 : -90;
        int secondTurnAngle = -firstTurnAngle;
        addParallel(new SetElevatorHeightWithEncoder(CMap.switchHeight));
        addSequential(new EncoderDrive(CMap.distanceToAutoLine));
        addSequential(new TurnToAngle(firstTurnAngle));
        addSequential(new EncoderDrive(CMap.fenceLength/2));
        addSequential(new TurnToAngle(secondTurnAngle));
        addSequential(new TimeDrive(3, 0.5, 0.5));
        addSequential(new ExpelBlockCommand());
        System.out.println("We should be good.");*/

    }

    @Override
    protected void end() {
        super.end();

        SmartDashboard.putString("DB/String 5", "Auto Finished");
    }
}

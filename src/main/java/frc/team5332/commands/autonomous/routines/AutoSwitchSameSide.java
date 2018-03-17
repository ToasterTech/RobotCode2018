package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.elevator.TimeElevator;
import main.java.frc.team5332.robot.CMap;

public class AutoSwitchSameSide extends CommandGroup {
    public AutoSwitchSameSide(char robotPosition){
        SmartDashboard.putString("DB/String 5", "Auto Switch Same Side Running");

        if(robotPosition == 'L') {
            addParallel(new TimeElevator(5, -0.5));
            addSequential(new TimeDrive(2.5, 0.5, 0.5));
            addSequential(new TimeDrive(1, 0, 0));
            addSequential(new TimeDrive(1, 0.3, -0.3));
            addSequential(new TimeDrive(2, 0.2, 0.2));
            addSequential(new TimeExpelBlockCommand(2));
        } else {
            addParallel(new TimeElevator(5, -0.5));
            addSequential(new TimeDrive(2.5, 0.5, 0.5));
            addSequential(new TimeDrive(1, 0, 0));
            addSequential(new TimeDrive(1, -0.3, 0.3));
            addSequential(new TimeDrive(2, 0.2, 0.2));
            addSequential(new TimeExpelBlockCommand(2));
        }

        /*
        int angle = (CMap.startingSpot == 'L') ? -90 : 90;
        System.out.println("Angle Set to " + angle);
        addParallel(new SetElevatorHeightWithEncoder(CMap.switchHeight)); //Raise Elevator
        //addSequential(new TimeDrive(10, 0.5, 0.5));
        addSequential(new EncoderDrive(CMap.distanceToSwitchFromWall)); //Needs to be in Feet
        addSequential(new TurnToAngle(angle)); //Face Switch
        addSequential(new TimeDrive(2, 0.5, 0.5)); //Make sure Robot bumper is contacting fence
        addSequential(new ExpelBlockCommand(), 5); //Tells the Robot that this command takes 5 seconds*/
    }

    @Override
    protected void end() {
        super.end();
        SmartDashboard.putString("DB/String 5", "Autonomous Finished");
    }
}

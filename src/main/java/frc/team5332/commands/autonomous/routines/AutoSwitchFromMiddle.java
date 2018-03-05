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
        SmartDashboard.putString("DB/String 5", "Auto Switch From Middle");
        addParallel(new TimeElevator(2, -0.5)); //Raise Elevator

        if(platePosition == 'R'){ //Plate is on the Right
            addSequential(new TimeDrive(0.5, 0.8, 0.8)); //Drive Straight into Switch
            addSequential(new TimeExpelBlockCommand(10));
        } else { //Plate is on the Left
            addSequential(new TimeDrive(1, 0.5, 0.5)); //Drive halfway to switch
            addSequential(new TimeDrive(0.5, 0, 0)); //Stop to Reduce Bumpiness
            addSequential(new TimeDrive(0.85, -0.3, 0.3)); //Turn to Left Plate
            addSequential(new TimeDrive(0.5, 0, 0)); //Stop again
            addSequential(new TimeDrive(1, 0.5, 0.5)); //Drive Straight
            addSequential(new TimeDrive(0.5, 0, 0)); //Stop
            addSequential(new TimeDrive(0.85, 0.3, -0.3)); //Turn Again
            addSequential(new TimeDrive(1, 0.3, 0.3)); //Drive into Switch
            addSequential(new TimeExpelBlockCommand(3));
        }
    }

    @Override
    protected void end() {
        super.end();

        SmartDashboard.putString("DB/String 5", "Auto Finished");
    }
}

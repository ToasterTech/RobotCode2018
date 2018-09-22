package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.TimeElevator;

public class AutoScaleOppositeSide extends CommandGroup {

    public AutoScaleOppositeSide(char robotPosition){
        SmartDashboard.putString("DB/String 6", "AUTO SCALE OPPOSITE SIDE");

        int multiplier = (robotPosition == 'L') ? 1 : -1;

        addSequential(new TimeDrive(1, 1, 1));
        addSequential(new TurnToAngle(85*multiplier));
        addSequential(new TimeDrive(1, 1, 1));
        addSequential(new TurnToAngle(0));
        addSequential(new TimeElevator(5, -1));
        addSequential(new TimeExpelBlockCommand(4));
    }

}

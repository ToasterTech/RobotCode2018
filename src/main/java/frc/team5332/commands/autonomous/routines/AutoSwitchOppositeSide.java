package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.robot.CMap;

public class AutoSwitchOppositeSide extends CommandGroup {

    public AutoSwitchOppositeSide(char robotPosition) {
        SmartDashboard.putString("DB/String 5", "Auto Switch Opposite Side Running");
        /*
        int angle = (CMap.startingSpot == 'L') ? -90 : 90;

        addParallel(new SetElevatorHeightWithEncoder(CMap.switchHeight));
        //addSequential(new TimeDrive(10, 0.5, 0.5));
        addSequential(new EncoderDrive(CMap.distanceToBackOfSwitchFromWall));
        addSequential(new TurnToAngle(angle));
        addSequential(new EncoderDrive(CMap.distanceAcrossBackOfSwitch));
        addSequential(new TurnToAngle(angle));
        addSequential(new ExpelBlockCommand(), 5);*/
    }
}

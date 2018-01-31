package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.SetElevatorHeightWithEncoder;
import main.java.frc.team5332.robot.CMap;

public class AutoSwitchFromMiddle extends CommandGroup {

    public AutoSwitchFromMiddle(){
        int firstTurnAngle = (CMap.plateOwnership.charAt(0) == 'L') ? 90 : -90;
        int secondTurnAngle = -firstTurnAngle;
        addParallel(new SetElevatorHeightWithEncoder(CMap.switchHeight));
        addSequential(new EncoderDrive(CMap.distanceToAutoLine));
        addSequential(new TurnToAngle(firstTurnAngle));
        addSequential(new EncoderDrive(CMap.fenceLength/2));
        addSequential(new TurnToAngle(secondTurnAngle));
        addSequential(new TimeDrive(3, 0.5, 0.5));
        addSequential(new ExpelBlockCommand());
        System.out.println("We should be good.");

    }

}

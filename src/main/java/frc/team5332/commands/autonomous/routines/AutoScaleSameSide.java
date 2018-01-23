package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.elevator.SetElevatorHeightWithEncoder;
import main.java.frc.team5332.robot.CMap;

public class AutoScaleSameSide extends CommandGroup {

    public AutoScaleSameSide(){

        if(CMap.startingSpot.equals("L")){
            addParallel(new SetElevatorHeightWithEncoder(CMap.scaleHeight));
            addSequential(new TimeDrive(10, 0.5, 0.5));
            addSequential(new TimeDrive(3, 0.5, -0.5));
        } else {
            addParallel(new SetElevatorHeightWithEncoder(CMap.scaleHeight));
            addSequential(new TimeDrive(10, 0.5, 0.5));
            addSequential(new TimeDrive(3, -0.5, 0.5));
        }

    }

}

package main.java.frc.team5332.commands.teleopCommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.frc.team5332.commands.carriage.IntakeCubeIntoCarriage;
import main.java.frc.team5332.commands.carriage.TimeIntakeCubeIntoCarriage;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.intake.SpinIntakeRollers;
import main.java.frc.team5332.commands.intake.TimeSpinIntakeRollers;

public class TimeIntakeCube extends CommandGroup {

    public TimeIntakeCube(double time){
        addParallel(new TimeSpinIntakeRollers(-1, time));
        addParallel(new TimeIntakeCubeIntoCarriage(time));
    }
}

package main.java.frc.team5332.commands.teleopCommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.frc.team5332.commands.carriage.IntakeCubeIntoCarriage;
import main.java.frc.team5332.commands.intake.SpinIntakeRollers;

public class NormalIntakeCube extends CommandGroup {

    public NormalIntakeCube(){
        addParallel(new SpinIntakeRollers(-1));
        addParallel(new IntakeCubeIntoCarriage());
    }
}

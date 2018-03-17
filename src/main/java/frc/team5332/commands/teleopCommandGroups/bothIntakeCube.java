package main.java.frc.team5332.commands.teleopCommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.frc.team5332.commands.intake.ChangeIntakeState;
import main.java.frc.team5332.commands.intake.SpinIntakeRollers;

public class bothIntakeCube extends CommandGroup {

    public bothIntakeCube(){
        addParallel(new ChangeIntakeState(true));
        addParallel(new SpinIntakeRollers(1.0));
    }

}

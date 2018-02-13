package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeCube extends CommandGroup{

    public IntakeCube(){
        addParallel(new OpenArms());
        addParallel(new SpinIntakeRollers(1));
    }

}

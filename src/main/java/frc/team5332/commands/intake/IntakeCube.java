package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.frc.team5332.commands.carriage.IntakeCubeIntoCarriage;

public class IntakeCube extends CommandGroup{

    public IntakeCube(){
        addParallel(new OpenArms());
        addParallel(new SpinIntakeRollers(1));
        addParallel(new IntakeCubeIntoCarriage());
    }

}

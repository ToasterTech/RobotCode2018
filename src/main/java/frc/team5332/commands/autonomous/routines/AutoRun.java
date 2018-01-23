package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.frc.team5332.commands.drive.TimeDrive;

public class AutoRun extends CommandGroup {

    public AutoRun(){
        addSequential(new TimeDrive(5, 0.5, 0.5));
    }


}

package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.frc.team5332.commands.drive.TimeDrive;

public class AutoRun extends CommandGroup {

    public AutoRun(){
        System.out.println("AUTO RUN ACTIVATED");
        addSequential(new TimeDrive(5, 0.5, 0.5));
    }

    @Override
    protected void end() {
        super.end();
        System.out.println("AUTO RUN COMPLETED");
    }
}

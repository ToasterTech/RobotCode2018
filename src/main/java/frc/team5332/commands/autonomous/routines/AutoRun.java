package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.drive.TimeDrive;

public class AutoRun extends CommandGroup {

    public AutoRun(){
        SmartDashboard.putString("DB/String 5", "Auto Run Running");
        addSequential(new TimeDrive(5, 0.5, 0.5));
    }

    @Override
    protected void end() {
        super.end();
        SmartDashboard.putString("DB/String 5", "Autonomous Finished");
    }
}

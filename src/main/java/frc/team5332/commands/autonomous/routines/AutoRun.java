package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.drive.TimeDrive;

public class AutoRun extends CommandGroup {

    public AutoRun(){
        //addSequential(new TimeDrive(2.5, 0.5, 0.5));


    }

    @Override
    protected void execute() {
        super.execute();
        SmartDashboard.putString("DB/String 6", "Auto Run Running");
    }

    @Override
    protected void end() {
        super.end();
        System.out.println("AUTONOMOUS FINISHED");
        SmartDashboard.putString("DB/String 5", "Autonomous Finished");
    }
}

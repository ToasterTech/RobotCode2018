package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.elevator.TimeElevator;
import main.java.frc.team5332.robot.CMap;

public class AutoSwitchSameSide extends CommandGroup {
    public AutoSwitchSameSide(char robotPosition){
        SmartDashboard.putString("DB/String 5", "Auto Switch Same Side Running");

        //double turnAngle = (robotPosition == 'R') ? -1 : 1;

        addSequential(new TimeDrive(3, 0, 0));

        addSequential(new TimeDrive(3, 0.5, 0.5));
        addParallel(new TimeElevator(.75, 1));
        if (robotPosition == 'R'){
            addSequential(new TimeDrive(.5, 0, 1));
        } else {
            addSequential(new TimeDrive(.5, 1, 0));
        }
        addSequential(new TimeDrive(1.5, 0.3, 0.3));
        addSequential(new TimeExpelBlockCommand(3));

        addSequential(new TimeDrive(1, -0.3, -0.3));
        addSequential(new TimeElevator(.75, -.5));
    }

    @Override
    protected void end() {
        super.end();
        SmartDashboard.putString("DB/String 5", "Autonomous Finished");
    }
}

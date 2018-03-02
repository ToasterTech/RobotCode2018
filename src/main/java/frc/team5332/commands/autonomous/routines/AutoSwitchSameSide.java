package main.java.frc.team5332.commands.autonomous.routines;

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

        int turnMultiplier = (robotPosition == 'L') ? 1 : -1;

        addParallel(new TimeElevator(2, -0.5));
        addSequential(new TimeDrive(2.5, 0.5, 0.5));
        addSequential(new TimeDrive(1, 0, 0));
        addSequential(new TimeDrive(1, 0.3 * turnMultiplier, -0.3 * turnMultiplier));
        addSequential(new TimeDrive(2, 0.2, 0.2));
        addSequential(new TimeExpelBlockCommand(2));

    }

    @Override
    protected void end() {
        super.end();
        SmartDashboard.putString("DB/String 5", "Autonomous Finished");
    }
}

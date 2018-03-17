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

        double turnAngle = (robotPosition == 'R') ? 90 : -90;


        addSequential(new TimeDrive(1, 1, 1));
        addSequential(new TurnToAngle(turnAngle));
        addParallel(new TimeDrive(0.5, 0.5, 0.5));
        addParallel(new TimeElevator(2, -1));
        addSequential(new TimeExpelBlockCommand(5));

    }

    @Override
    protected void end() {
        super.end();
        SmartDashboard.putString("DB/String 5", "Autonomous Finished");
    }
}

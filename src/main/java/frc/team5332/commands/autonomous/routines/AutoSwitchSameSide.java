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
import main.java.frc.team5332.util.PlaybackRecording;
import main.java.frc.team5332.util.ToasterDVR;

public class AutoSwitchSameSide extends CommandGroup {
    public AutoSwitchSameSide(char robotPosition){
        SmartDashboard.putString("DB/String 6", "Auto Switch Same Side Running");

        addSequential(new TimeDrive(2.0, 0.5, 0.5));

        if(robotPosition == 'R') {
            addSequential(new PlaybackRecording(ToasterDVR.switchSameRight));
        } else {
            addSequential(new PlaybackRecording(ToasterDVR.switchSameLeft));
        }
    }

    @Override
    protected void end() {
        super.end();
        SmartDashboard.putString("DB/String 6", "Autonomous Finished");
    }
}

package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.TimeElevator;
import main.java.frc.team5332.commands.intake.ChangeIntakeState;
import main.java.frc.team5332.commands.intake.OpenCloseIntakeArms;
import main.java.frc.team5332.robot.CMap;
import main.java.frc.team5332.util.PlaybackRecording;
import main.java.frc.team5332.util.ToasterDVR;

public class AutoSwitchFromMiddle extends CommandGroup {

    public AutoSwitchFromMiddle(char platePosition){
        SmartDashboard.putString("DB/String 6", "Auto Switch From Middle Running");

        if(platePosition == CMap.leftPos.charAt(0)){
            addSequential(new PlaybackRecording(ToasterDVR.switchMiddleLeft));
        } else {
            addSequential(new PlaybackRecording(ToasterDVR.switchMiddleRight));
        }


    }

    @Override
    protected void end() {
        super.end();

        System.out.println("AUTO FINISHED");
        SmartDashboard.putString("DB/String 5", "Auto Finished");
    }
}

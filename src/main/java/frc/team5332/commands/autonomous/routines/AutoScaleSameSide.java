package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.TimeElevator;
import main.java.frc.team5332.commands.teleopCommandGroups.TimeIntakeCube;
import main.java.frc.team5332.robot.CMap;
import main.java.frc.team5332.util.PlaybackRecording;
import main.java.frc.team5332.util.ToasterDVR;

import javax.swing.*;


public class AutoScaleSameSide extends CommandGroup {

    public AutoScaleSameSide(char robotPosition){
        DriverStation.reportWarning("Auto Scale Same Side (" + robotPosition + ") activated", false);

        SmartDashboard.putString("DB/String 6", "Auto Scale Same Side Running");
        if(robotPosition == CMap.leftPos.charAt(0)){
            addSequential(new PlaybackRecording(ToasterDVR.scaleSameLeft));
        } else {
            addSequential(new PlaybackRecording(ToasterDVR.scaleSameRight));
        }



    }

    @Override
    protected void end() {
        super.end();
        SmartDashboard.putString("DB/String 6", "Autonomous Finished");
    }



}

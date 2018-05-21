package main.java.frc.team5332.util;

import com.ctre.phoenix.drive.DriveMode;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.util.ArrayList;

public class PlaybackRecording extends Command{
    ArrayList<Cycle> playbackCycles;
    int cycleIndex;
    String fileName;

    public PlaybackRecording(String file){
        cycleIndex = 0;
        fileName = file;
        try{
            playbackCycles = CMap.mainDVR.readPath(fileName);
        } catch (Exception e){
            DriverStation.reportError("Unable to Get Cycles", e.getStackTrace());
        }
    }

    public PlaybackRecording(ArrayList<Cycle> cycles){
        cycleIndex = 0;
        playbackCycles = cycles;
    }

    @Override
    protected void execute() {

        Cycle currentCycle = playbackCycles.get(cycleIndex);
        CMap.drive.tankDrive(currentCycle.leftJoystickValue, currentCycle.rightJoystickValue);
        cycleIndex += 1;

    }

    @Override
    protected boolean isFinished() {
        return cycleIndex >= playbackCycles.size();
    }

    @Override
    protected void end() {
        CMap.drive.tankDrive(0, 0);
        System.out.println("Finished Playback");

    }
}

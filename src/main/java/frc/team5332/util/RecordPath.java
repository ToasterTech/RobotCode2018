package main.java.frc.team5332.util;

import com.ctre.phoenix.drive.DriveMode;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.util.ArrayList;

public class RecordPath extends Command{
    ArrayList<Cycle> recordingCycles = new ArrayList<>();
    String fileName;

    public RecordPath(String file){
        fileName = file;
    }


    @Override
    protected void execute() {
        recordingCycles.add(new Cycle(CMap.gamepad.getRawAxis(CMap.leftYAXis), CMap.gamepad.getRawAxis(CMap.rightYAxis)));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        try {
            CMap.mainDVR.writePath(recordingCycles, fileName);
        } catch (Exception e){
            DriverStation.reportError("Recording Saving Failed", e.getStackTrace());
        }

    }
}

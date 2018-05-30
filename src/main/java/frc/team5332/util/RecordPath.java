package main.java.frc.team5332.util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.util.ArrayList;

public class RecordPath extends Command{
    ArrayList<Cycle> recordingCycles = new ArrayList<>();
    String fileName;
    boolean warningIssued = false;

    public RecordPath(String file){
        fileName = file;
    }


    @Override
    protected void execute() {
        if(!warningIssued){
            DriverStation.reportWarning("Recording Starting", false);
            warningIssued = true;
        }

        recordingCycles.add(new Cycle(CMap.gamepad.getRawAxis(CMap.leftYAXis), CMap.gamepad.getRawAxis(CMap.rightYAxis),
                CMap.operatorJoystick.getY(), CMap.carriage.getMotorSpeed(), CMap.intake.getRollerSpeed(),
                CMap.intake.getIntakeArmOpenOrClosedState(), CMap.intake.getIntakeArmUpOrDownState()));

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        warningIssued = false;
        try {
            ToasterDVR.writePath(recordingCycles, fileName);
        } catch (Exception e){
            DriverStation.reportError("Recording Saving Failed", e.getStackTrace());
        }

    }
}

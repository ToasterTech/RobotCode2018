package main.java.frc.team5332.util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.util.ArrayList;

public class PlaybackRecording extends Command{
    boolean warningIssued = false;
    ArrayList<Cycle> playbackCycles = new ArrayList<>();
    int cycleIndex;
    String fileName;

    public PlaybackRecording(String file){
        cycleIndex = 0;
        fileName = file;
        try{
            playbackCycles = ToasterDVR.readPath(fileName);
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
        if(!warningIssued){
            warningIssued = true;
            DriverStation.reportWarning("Playback Starting", false);
        }
        if(playbackCycles.size() == 0){
            try{
                playbackCycles = ToasterDVR.readPath(fileName);
            } catch (Exception e){
                DriverStation.reportError("Unable to Get Cycles", e.getStackTrace());
            }
        }

        Cycle currentCycle = playbackCycles.get(cycleIndex);
        CMap.drive.tankDrive(-currentCycle.leftJoystickValue, -currentCycle.rightJoystickValue);
        CMap.elevator.setMotorSpeed(currentCycle.elevatorJoystickValue);
        CMap.carriage.setCarriageMotor(currentCycle.getCarriageMotorValues());
        CMap.intake.spinRollers(currentCycle.getIntakeMotorValues());
        CMap.intake.changeIntakeArmState(currentCycle.getIntakeArmsDown());
        CMap.intake.changeOpenCloseIntakeState(currentCycle.getIntakeArmsOpen());


        cycleIndex += 1;

    }

    @Override
    protected boolean isFinished() {
        return cycleIndex >= playbackCycles.size();
    }

    @Override
    protected void end() {
        cycleIndex = 0;
        playbackCycles = new ArrayList<>();
        CMap.drive.tankDrive(0, 0);
        CMap.elevator.setMotorSpeed(0);
        System.out.println("Finished Playback");

    }
}

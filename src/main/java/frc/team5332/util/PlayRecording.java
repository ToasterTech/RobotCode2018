package main.java.frc.team5332.util;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.io.File;
import java.util.ArrayList;

public class PlayRecording extends Command {
    int cycle;
    ToasterDVR dvr;
    ArrayList<Cycle> cycles = new ArrayList<Cycle>();

    public PlayRecording(ToasterDVR callingDVR, File playbackFile){
        cycle = 0;
        dvr = callingDVR;

        try {
            cycles = dvr.readPath(playbackFile);
        }catch (Exception e){
            System.out.println();
        }
    }

    @Override
    protected void execute() {
        CMap.drive.tankDrive(cycles.get(cycle).leftJoystickValue, cycles.get(cycle).rightJoystickValue);
        cycle += 1;
    }

    @Override
    protected boolean isFinished() {
        return cycle >= cycles.size();
    }

    @Override
    protected void end() {
        System.out.println("Finishing Recording");

    }
}

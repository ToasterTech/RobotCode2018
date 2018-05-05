package main.java.frc.team5332.util;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.util.ArrayList;

public class PlayRecording extends Command {
    int cycle;
    ArrayList<Cycle> cycles = new ArrayList<Cycle>();

    public PlayRecording(){
        cycle = 0;

        try {
            cycles = CMap.readPath();
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

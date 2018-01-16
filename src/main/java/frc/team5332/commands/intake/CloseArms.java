package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class CloseArms extends Command {

    public CloseArms(){
        requires(CMap.intake);
    }

    @Override
    protected void execute() {
        CMap.intake.changeStatus(false);
    }

    @Override
    protected boolean isFinished() {
        return !CMap.intake.getSolenoidStatus();
    }

    @Override
    protected void end() {
        //Empty Because no real way to end it
    }
}

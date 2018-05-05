package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class OpenCloseIntakeArms extends Command {
    boolean state;

    public OpenCloseIntakeArms(){

    }

    @Override
    protected void execute() {
        CMap.intake.changeOpenCloseIntakeState();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        super.end();
    }
}

package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class ChangeIntakeState extends Command {
    boolean state;

    public ChangeIntakeState(boolean newState){
        state = newState;
    }

    @Override
    protected void execute() {
        CMap.intake.changeIntakeArmState(state);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.end();
    }
}

package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class ExpelBlockCommand extends Command {

    public ExpelBlockCommand(){
        requires(CMap.intake);
    }

    public void execute(){
        CMap.intake.spinRollers(1);
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){
        CMap.intake.stopRollers();
    }

}

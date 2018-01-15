package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class IntakeBlockCommand extends Command {

    public IntakeBlockCommand(){
        requires(CMap.intake);
    }

    public void execute(){
        CMap.intake.spinMotors(-1);
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){
        CMap.intake.stopMotors();
    }
}

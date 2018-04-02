package main.java.frc.team5332.commands.carriage;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.commands.intake.TriggerSpinCubeInIntake;
import main.java.frc.team5332.robot.CMap;

public class SlowExpelBlockCommand extends Command {

    public SlowExpelBlockCommand(){
        requires(CMap.intake);
    }

    public void execute(){
        CMap.carriage.expelCube(0.4);
        CMap.intake.spinRollers(.4);
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){
        CMap.carriage.stopMotors();
        CMap.intake.stopRollers();

        Scheduler.getInstance().add(new TriggerSpinCubeInIntake());
    }

}

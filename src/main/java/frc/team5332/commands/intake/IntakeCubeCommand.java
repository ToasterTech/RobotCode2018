package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class IntakeCubeCommand extends Command {

    public IntakeCubeCommand(){

    }

    @Override
    protected void execute() {
        System.out.println("COMMAND IS RUNNING");
        CMap.intake.spinIntakeAxisMotors(-1);
        CMap.intake.spinRollers(1);
        CMap.carriage.intakeCube();

        CMap.armsOpenTime += 1;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.intake.stopIntakeAxisMotors();
        CMap.intake.stopRollers();
        CMap.carriage.stopMotors();
    }
}

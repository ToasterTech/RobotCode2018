package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;
import main.java.frc.team5332.subsystems.Intake;

public class IntakeCube extends Command{

    public IntakeCube(){
        requires(CMap.intake);
    }

    public void execute(){
        CMap.intake.intakeCube();
    }

    @Override
    protected boolean isFinished() {
        return CMap.intake.cubeIsIn();
    }

    @Override
    protected void end() {
        CMap.intake.stopMotors();
    }



}
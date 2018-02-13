package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.robot.CMap;

public class OpenArms extends Command {

    public OpenArms(){
        requires(CMap.intake);
    }

    @Override
    protected void execute() {
        CMap.intake.spinIntakeAxisMotors(1);


    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.intake.stopIntakeAxisMotors();
        //Scheduler.getInstance().add(new SpinIntakeMotors());
    }
}

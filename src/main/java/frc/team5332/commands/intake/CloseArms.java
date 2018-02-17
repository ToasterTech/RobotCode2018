package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.robot.CMap;

public class CloseArms extends Command {

    public CloseArms(){
        requires(CMap.intake);
    }

    @Override
    protected void execute() {
        CMap.intake.spinIntakeAxisMotors(1);
        CMap.armsOpenTime -= 1;
        System.out.println("RUNNING");
    }

    @Override
    protected boolean isFinished() {
        System.out.println("LEFT: " + CMap.intake.limitSwitchA.get());
        System.out.println("Right: " + CMap.intake.limitSwitchB.get());
        return !CMap.intake.limitSwitchA.get() && !CMap.intake.limitSwitchB.get();
        //return CMap.armsOpenTime <= 0;
    }

    @Override
    protected void end() {
        CMap.intake.stopIntakeAxisMotors();
        System.out.println("DONE");
        //Scheduler.getInstance().add(new SpinIntakeMotors());
    }
}

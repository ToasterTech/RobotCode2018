package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class TestMotorInput extends Command {

    //VictorSP motor;
    SpeedControllerGroup motor;
    public TestMotorInput(int port){
        //motor = new VictorSP(port);
        motor = new SpeedControllerGroup(new VictorSP(CMap.intakeAxes));;
    }

    public void execute(){
        motor.set(1.0);
    }

    public boolean isFinished(){
        return false;
    }

}

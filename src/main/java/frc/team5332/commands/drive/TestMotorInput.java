package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class TestMotorInput extends Command {

    //VictorSP motor;
    SpeedControllerGroup motor;
    public TestMotorInput(int port){
        //motor = new VictorSP(port);

        Spark invertedMotor = new Spark(CMap.rightCarriageMotor);
        invertedMotor.setInverted(true);
        motor = new SpeedControllerGroup(invertedMotor, new Talon(CMap.leftCarriageMotor));;
    }

    public void execute(){
        motor.set(0.6);
    }

    public boolean isFinished(){
        return false;
    }

}

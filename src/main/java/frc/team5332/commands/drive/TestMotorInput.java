package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;

public class TestMotorInput extends Command {

    VictorSP motor;
    public TestMotorInput(int port){
        motor = new VictorSP(port);
    }

    public void execute(){
        motor.set(1.0);
    }

    public boolean isFinished(){
        return false;
    }

}

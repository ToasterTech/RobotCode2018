package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

/**
 * This subsystem represents the carriage that moves up and down
 * on the elevator.
 */
public class Carriage extends Subsystem {
    VictorSP leftMotor, rightMotor;
    DigitalInput limitSwitch;


    public Carriage(){
        super("Carriage");
        limitSwitch = new DigitalInput(CMap.intakeLimitSwitch);

        leftMotor  = new VictorSP(CMap.leftCarriageMotor);
        rightMotor = new VictorSP(CMap.rightCarriageMotor);
    }

    protected void initDefaultCommand(){

    }

    /**
     * This method takes in the cube.
     */
    public void intakeCube(){
        leftMotor.set(-1);
        rightMotor.set(-1);
    }

    /**
     * This method removes the cube.
     */
    public void expelCube(){
        leftMotor.set(1);
        rightMotor.set(1);
    }

    /**
     * This method stops the motors from running.
     */
    public void stopMotors(){
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

    /**
     * This method returns the status of the limit switch. If the switch
     * is pressed, then the method returns true.
     *
     * @return
     */
    public boolean cubeIsIn(){
        return limitSwitch.get();
    }
}

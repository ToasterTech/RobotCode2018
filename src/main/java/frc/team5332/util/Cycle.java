package main.java.frc.team5332.util;

public class Cycle {

    double leftJoystickValue;
    double rightJoystickValue;

    public Cycle(){
        leftJoystickValue = 0.0;
        rightJoystickValue = 0.0;
    }

    public Cycle(double leftJoystickValue, double rightJoystickValue) {
        this.leftJoystickValue = leftJoystickValue;
        this.rightJoystickValue = rightJoystickValue;
    }


    public double getLeftJoystickValue() {
        return leftJoystickValue;
    }

    public void setLeftJoystickValue(double leftJoystickValue) {
        this.leftJoystickValue = leftJoystickValue;
    }

    public double getRightJoystickValue() {
        return rightJoystickValue;
    }

    public void setRightJoystickValue(double rightJoystickValue) {
        this.rightJoystickValue = rightJoystickValue;
    }
}

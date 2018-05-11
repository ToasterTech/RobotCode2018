package main.java.frc.team5332.util;

public class Cycle {

    int cycleIndex;
    double leftJoystickValue;
    double rightJoystickValue;

    public Cycle(){
        cycleIndex = 0;
        leftJoystickValue = 0.0;
        rightJoystickValue = 0.0;
    }

    public Cycle(int cycleIndex, double leftJoystickValue, double rightJoystickValue) {
        this.cycleIndex = cycleIndex;
        this.leftJoystickValue = leftJoystickValue;
        this.rightJoystickValue = rightJoystickValue;
    }

    public int getCycleIndex() {

        return cycleIndex;
    }

    public void setCycleIndex(int cycleIndex) {
        this.cycleIndex = cycleIndex;
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

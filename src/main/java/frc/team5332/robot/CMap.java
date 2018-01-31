package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import main.java.frc.team5332.commands.carriage.IntakeCubeIntoCarriage;
import main.java.frc.team5332.commands.intake.CloseArms;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.intake.OpenArms;
import main.java.frc.team5332.subsystems.*;
import main.java.frc.team5332.subsystems.drive.DriveTrain;

public class CMap {
    //Input Devices - Joysticks
    public static Joystick gamepad          = new Joystick(0);
    public static Joystick operatorJoystick = new Joystick(1);


    public static int leftXAxis = 0; //Left X-Axis
    public static int leftYAXis = 1; //Left Y-Axis
    public static int rightXAxis = 4; //Right X-Axis
    public static int rightYAxis = 5; //Right Y-Axis
    public static int leftTriggerAxis = 2;
    public static int rightTriggerAxis = 3;

    //Input Devices - Joystick Buttons - Gamepad
    private static int greenButton = 1;
    private static int redButton = 2;
    private static int blueButton = 3;
    private static int yellowButton = 4;
    private static int leftBumper  = 5;
    private static int rightBumper = 6;

    //Input Devices - Joystick Buttons - Operator Stick
    private static int button1 = 1;
    private static int button2 = 2;

    private static JoystickButton openArmsButton = new JoystickButton(gamepad ,leftBumper);
    private static JoystickButton closeArmsButton = new JoystickButton(gamepad, rightBumper);

    private static JoystickButton intakeCubeButton = new JoystickButton(operatorJoystick, button1);
    private static JoystickButton expelCubeButton = new JoystickButton(operatorJoystick, button2);
    //Input Devices - Buttons

    //PWM Motor Ports
    public static int leftDriveMotors = 0;
    public static int rightDriveMotors = 1;

    public static int intakeRollers = 2;
    public static int intakeAxes = 3;

    public static int carriageMotor = 4;
    public static int elevatorMotor = 5;

    //DIO Ports
    public static int intakeLimitSwitch = 0;

    public static int leftDriveEncoderPortA  = 1;
    public static int leftDriveEncoderPortB  = 2;
    public static int rightDriveEncoderPortA = 3;
    public static int rightDriveEncoderPortB = 4;
    public static int elevatorEncoderPortA   = 5;
    public static int elevatorEncoderPortB   = 6;


    //Analog Ports

    //Relay Ports



    //Subsystems
    public static DriveTrain drive = new DriveTrain();
    public static Intake intake;
    public static Carriage carriage;// = new Intake();
    public static Elevator elevator;


    //Other Miscellaneous Objects
    public static String plateOwnership = "";
    public static char startingSpot = 'D';
    public static String autoPreference = "";

    //Measurements in Inches
    public static double scaleHeight = 65;
    public static double switchHeight = 0;
    public static double fenceWidth = 48;
    public static double switchLength = 36;
    public static double distanceToAutoLine = 10;
    public static double fenceLength = 40;

    public static double distanceToSwitchFromWall = 20;
    public static double distanceToBackOfSwitchFromWall = distanceToSwitchFromWall + 5;
    public static double distanceAcrossBackOfSwitch = 30;
    public static double distanceToScaleFromWall = 40;

    public static void setupJoystickButtons(){
        openArmsButton.toggleWhenPressed(new OpenArms());
        closeArmsButton.toggleWhenPressed(new CloseArms());

        intakeCubeButton.toggleWhenPressed(new IntakeCubeIntoCarriage());
        expelCubeButton.toggleWhenPressed(new ExpelBlockCommand());
    }
}

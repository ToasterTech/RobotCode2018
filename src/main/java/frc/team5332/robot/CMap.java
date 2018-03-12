package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import main.java.frc.team5332.commands.intake.*;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.subsystems.*;
import main.java.frc.team5332.subsystems.drive.DriveTrain;

public class CMap {
    public static Timer closeArmsTimer;

    //Input Devices - Joysticks
    public static Joystick gamepad          = new Joystick(0);
    public static Joystick operatorJoystick = new Joystick(1);
    public static int armsOpenTime = 0;

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

    //private static JoystickButton openArmsButton = new JoystickButton(gamepad ,leftBumper);
    //private static JoystickButton closeArmsButton = new JoystickButton(gamepad, rightBumper);

    private static JoystickButton intakeCubeButtonComplete = new JoystickButton(gamepad, rightBumper);
    private static JoystickButton intakeCubeButtonCarriage = new JoystickButton(gamepad, leftBumper);
    private static JoystickButton expelCubeButton = new JoystickButton(operatorJoystick, 2);
    //Input Devices - Buttons

    //PWM Motor Ports
    public static int leftDriveMotors = 1;
    public static int rightDriveMotors = 0;

    public static int intakeRollerRight = 2;
    public static int intakeRollerLeft = 4;
    public static int intakeAxes = 6;

    public static int leftCarriageMotor = 9; //7
    public static int rightCarriageMotor = 8;

    public static int elevatorMotor1 = 3;
    public static int elevatorMotor2 = 5;

    //DIO Ports
    public static int windowMotorLimitSwitchA = 2;
    public static int windowMotorLimitSwitchB = 3;

    public static int leftDriveEncoderPortA  = 0;
    public static int leftDriveEncoderPortB  = 1;
    public static int rightDriveEncoderPortA   = 4;
    public static int rightDriveEncoderPortB   = 5;


    //Analog Ports

    //Relay Ports



    //Subsystems
    public static DriveTrain drive = new DriveTrain();
    public static Intake intake  = new Intake();
    public static Carriage carriage = new Carriage();
    public static Elevator elevator = new Elevator();


    //Other Miscellaneous Objects
    public static String plateOwnership = "";
    public static char startingSpot = 'D';
    public static Object autoPreference = "";

    public static SendableChooser autoChooser,
                                  positionChooser;

    //Measurements in Inches
    public static double scaleHeight = 65;
    public static double switchHeight = 0;
    public static double fenceWidth = 48;
    public static double switchLength = 36;
    public static double distanceToAutoLine = 10;
    public static double fenceLength = 40;
    public static double maxChange = 0.5;

    public static double distanceToSwitchFromWall = 20;
    public static double distanceToBackOfSwitchFromWall = distanceToSwitchFromWall + 5;
    public static double distanceAcrossBackOfSwitch = 30;
    public static double distanceToScaleFromWall = 40;

    public static boolean leftTriggerPreviouslyPressed = false,
            rightTriggerPreviouslyPressed = false,
            motorsIntaking = false,
            motorsExpelling = false;
    public static void setupJoystickButtons(){
        intakeCubeButtonComplete.whenReleased(new CloseArms());
        //intakeCubeRightArmButton.whenReleased();
        //intakeCubeLeftArmButton.whenReleased();

        intakeCubeButtonComplete.whileHeld(new IntakeCubeCommandWhole());
        expelCubeButton.whileHeld(new ExpelBlockCommand());

        intakeCubeButtonCarriage.whileHeld(new IntakeCubeWithCarriage());
        //intakeCubeRightArmButton.whileHeld();
        //intakeCubeLeftArmButton.whileHeld();
    }
}

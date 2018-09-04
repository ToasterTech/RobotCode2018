package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import main.java.frc.team5332.commands.carriage.SlowExpelBlockCommand;
import main.java.frc.team5332.commands.intake.*;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.teleopCommandGroups.NormalIntakeCube;
import main.java.frc.team5332.subsystems.*;
import main.java.frc.team5332.subsystems.drive.DriveTrain;
import main.java.frc.team5332.util.Cycle;
import main.java.frc.team5332.util.PlaybackRecording;
import main.java.frc.team5332.util.RecordPath;
import main.java.frc.team5332.util.ToasterDVR;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CMap {
    //Autonomous
    public static final String leftPos   = "Left",
                      centerPos = "Middle",
                      rightPos  = "Right";

    public static final String autoRun    = "Auto Run",
                      switchOnly = "Switch",
                      scaleOnly  = "Scale",
                      normal     = "Normal";

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

    private static JoystickButton carriageIntakeCubeButton = new JoystickButton(gamepad, leftBumper);
    public static JoystickButton slowOutakeButton = new JoystickButton(gamepad, yellowButton);
    private static JoystickButton normalIntakeCubeButton = new JoystickButton(gamepad, rightBumper);
    private static JoystickButton changeArmsButton = new JoystickButton(gamepad, blueButton);
    public static JoystickButton openCloseIntakeArmsButton = new JoystickButton(gamepad, redButton);
    private static JoystickButton expelCubeButton = new JoystickButton(operatorJoystick, 1);

    //Toaster DVR Controls
    private static JoystickButton recordingToggle = new JoystickButton(operatorJoystick, 5);
    private static JoystickButton playbackToggle = new JoystickButton(operatorJoystick, 6);
    //Input Devices - Buttons

    //PWM Motor Ports
    public static int leftDriveMotors = 1;
    public static int rightDriveMotors = 0;

    public static int intakeRollerRight = 2;
    public static int intakeRollerLeft = 4;

    public static int leftCarriageMotor = 9; //7
    public static int rightCarriageMotor = 8;

    public static int elevatorMotor1 = 3;
    public static int elevatorMotor2 = 5;
    public static int elevatorMotor3 = 6;

    public static int leftDriveEncoderPortA  = 0;
    public static int leftDriveEncoderPortB  = 1;
    public static int rightDriveEncoderPortA   = 4;
    public static int rightDriveEncoderPortB   = 5;


    //Analog Ports

    //Relay Ports


    //Pnematics
    public static Compressor compressor = new Compressor();
    public static int intakeSolenoid = 0;
    public static int openCloseSolenoidA = 1;
    public static int openCloseSolenoidB = 2;

    //Subsystems
    public static DriveTrain drive = new DriveTrain();
    public static Intake intake  = new Intake();
    public static Carriage carriage = new Carriage();
    public static Elevator elevator = new Elevator();


    //Other Miscellaneous Objects
    public static String plateOwnership = "";

    public static void setupJoystickButtons(){
        normalIntakeCubeButton.whileHeld(new NormalIntakeCube());

        changeArmsButton.whenPressed(new ChangeIntakeState()); //It makes it the opposite
        openCloseIntakeArmsButton.whileHeld(new ExpelBlockCommand());
        carriageIntakeCubeButton.whenPressed(new OpenCloseIntakeArms());

        expelCubeButton.whileHeld(new ExpelBlockCommand());

        slowOutakeButton.whileHeld(new SlowExpelBlockCommand());

        recordingToggle.toggleWhenPressed(new RecordPath(ToasterDVR.switchSameRight));
        playbackToggle.toggleWhenPressed(new PlaybackRecording(ToasterDVR.switchSameRight));

    }




}

package main.java.frc.team5332.util;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseEnum;
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

public class ToasterDVR {
    //Recording Name Constants
    public final static String autoRun = "AutoRun.csv",
                        SwitchSameLeft = "leftSwitchSameLeft.csv",
                        switchSameRight = "SwitchSameRight.csv",
                        switchMiddleLeft = "SwitchMiddleLeft.csv",
                        switchMiddleRight = "SwitchMiddleRight.csv",
                        scaleSameLeft = "ScaleSameLeft.csv",
                        scaleOppositeLeft = "ScaleOppositeLeft.csv",
                        scaleOppositeRight = "ScaleOppositeRight.csv",
                        scaleSameRight = "ScaleSameRight.csv";



    private static File recordingsDir = new File("/home/lvuser", "Recordings");
    private static String[] variableNames = {"leftJoystickValue", "rightJoystickValue", "elevatorJoystickValue", "carriageMotorValues", "intakeMotorValues", "intakeArmsOpen", "intakeArmsDown"};
    private static CellProcessor[] cellProcessors = {new ParseDouble(), new ParseDouble(), new ParseDouble(), new ParseDouble(), new ParseDouble(), new ParseEnum(DoubleSolenoid.Value.class), new ParseBool()};

    //private static String[] variableNames = {"intakeArmsDown"};
    //private static CellProcessor[] cellProcessors = {new ParseBool()};

    private ToasterDVR(){


    }

    public static void writePath(ArrayList<Cycle> cycles, String recordingName) throws Exception{
        if(!recordingName.contains(".csv")){
            recordingName = recordingName + ".csv";
        }
        File path = new File(recordingsDir, recordingName);

        ICsvBeanWriter writer = new CsvBeanWriter(new FileWriter(path, false), CsvPreference.STANDARD_PREFERENCE);


        for(Cycle cycle : cycles){
            writer.write(cycle, variableNames, cellProcessors);
        }

        writer.close();
        DriverStation.reportWarning("Recording Successful and saved at " + path.getAbsolutePath(), false);
    }

    public static ArrayList<Cycle> readPath(String recordingName) throws Exception{
        if(!recordingName.contains(".csv")){
            recordingName = recordingName + ".csv";
        }
        File path = new File(recordingsDir, recordingName);


        ArrayList<Cycle> cycles = new ArrayList<>();

        if(!path.exists()){
            DriverStation.reportError("File does not exist.", false);
        }

        ICsvBeanReader reader = new CsvBeanReader(new FileReader(path), CsvPreference.STANDARD_PREFERENCE);

        Cycle currentCycle;
        while((currentCycle = reader.read(Cycle.class, variableNames, cellProcessors)) != null){
            cycles.add(currentCycle);
        }
        reader.close();

        return cycles;
    }



}

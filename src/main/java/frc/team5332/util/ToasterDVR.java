package main.java.frc.team5332.util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
import java.sql.Driver;
import java.util.ArrayList;

public class ToasterDVR {
    private int currentState;
    private File recordingsDir;

    public String[] variableNames = {"leftJoystickValue", "rightJoystickValue", "elevatorJoystickValue"};
    public CellProcessor[] cellProcessors = {new ParseDouble(), new ParseDouble(), new ParseDouble()};

    //DVR States
    public static int IDLE = 1;
    public static int RECORDING = 2;
    public static int PLAYBACK = 3;

    public ToasterDVR(){
        recordingsDir = new File("/home/lvuser", "Recordings");
        currentState = IDLE;

    }

    public void setupSmartDashboard(){

    }

    public int getCurrentState(){
        return currentState;
    }

    public String[] getRecordings(){
        return recordingsDir.list();
    }


    public void writePath(ArrayList<Cycle> cycles, String recordingName) throws Exception{
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

    public ArrayList<Cycle> readPath(String recordingName) throws Exception{
        if(!recordingName.contains(".csv")){
            recordingName = recordingName + ".csv";
        }
        File path = new File(recordingsDir, recordingName);

        ArrayList<Cycle> cycles = new ArrayList<>();

        ICsvBeanReader reader = new CsvBeanReader(new FileReader(path), CsvPreference.STANDARD_PREFERENCE);

        Cycle currentCycle;
        while((currentCycle = reader.read(Cycle.class, variableNames, cellProcessors)) != null){
            cycles.add(currentCycle);
        }
        reader.close();

        return cycles;
    }



}

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

    public String[] variableNames = {"cycleIndex", "leftJoystickValue", "rightJoystickValue"};
    public CellProcessor[] cellProcessors = {new ParseInt(), new ParseDouble(), new ParseDouble()};

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


    public boolean startRecording(String recordingName){
        //First, let's make sure the DVR is not active.
        if(currentState == RECORDING | currentState == PLAYBACK){
            DriverStation.reportWarning("Playback or Recording is already occuring. Please kill that before starting a recording.", false);
            return false;
        }

        //Next, let's make sure that we have a file name to work with.
        if(recordingName.length() == 0){
            DriverStation.reportWarning("Recording Must have a name.", false);
            return false;
        }


        //All right! Let's load up the command.
        Scheduler.getInstance().add(new RecordCommand(this, recordingName));
        currentState = RECORDING;
        DriverStation.reportWarning("Recording is Starting.", false);
        return true;
    }

    public boolean startPlayback(String recordingName){
        //First, let's make sure the DVR is not active already.
        if(currentState == RECORDING | currentState == PLAYBACK){
            DriverStation.reportWarning("Playback or Recording is already occuring. Please kill that before starting a recording.", false);
            return false;
        }

        //Next, let's make sure that the file exists.
        if(!recordingName.contains(".csv")){
            recordingName = recordingName + ".csv";
        }
        File currentRecording = new File(recordingsDir, recordingName);

        if(!currentRecording.exists()){
            DriverStation.reportWarning("Recording does not exist!", false);
            System.out.println("Existing Files\n");
            for(String recording : recordingsDir.list()){
                System.out.println(recording);
            }
            return false;
        }

        Scheduler.getInstance().add(new PlayRecording(this, currentRecording));
        currentState = PLAYBACK;
        DriverStation.reportWarning("Playback is Starting.", true);
        return true;
    }

    public void stopProcess(){
        if(currentState == RECORDING){
            currentState = IDLE;
            DriverStation.reportWarning("Recording Stopping", false);
        } else if(currentState == PLAYBACK){
            currentState = IDLE;
            DriverStation.reportWarning("Stopping Playback", false);
        } else {
            DriverStation.reportWarning("DVR is already idle", false);
        }
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

    public ArrayList<Cycle> readPath(File path) throws Exception{

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

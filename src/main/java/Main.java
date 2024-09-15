// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import edu.wpi.first.networktables.BooleanPublisher;
import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class Main {
  
  public static int team = 4039;
  public static boolean server = false;
   
  //Network Table Publishers
  static BooleanPublisher pubDetectedNote;
  static DoublePublisher pubXCenter;
  static DoublePublisher pubYCenter;
  static DoublePublisher pubWidth;
  static DoublePublisher pubHeight;
  static DoublePublisher pubAngle;
  static DoublePublisher pubThreadCounter;
  static DoublePublisher pubThreadCounterTime;      
  static DoublePublisher pubThreadsPerSecond;
  
  
  // Set the Method to choose the Object returned.
  // LOWEST returns the Object with teh smallest Y Center
  // LARGEST returns teh Object with the Largest Area
  
  /*** Main ***/
  public static void main(String[] args) {

    // start NetworkTables
    NetworkTableInstance ntinst = NetworkTableInstance.getDefault();
    if (server) {
      System.out.println("Setting up NetworkTables server");
      ntinst.startServer();
    } else {
      System.out.println("Setting up NetworkTables client for team " + team);
      ntinst.startClient4("wpilibpi");
      
         ntinst.startDSClient();
   
    }
    NetworkTable piVisionTable = ntinst.getTable("PiVision");

    // Setup Network Table Publisher Topics
    pubDetectedNote = piVisionTable.getBooleanTopic("DetectedNote").publish();
    pubXCenter = piVisionTable.getDoubleTopic("XCenter").publish();
    pubYCenter = piVisionTable.getDoubleTopic("YCenter").publish();
    pubWidth = piVisionTable.getDoubleTopic("Width").publish();
    pubHeight = piVisionTable.getDoubleTopic("Height").publish();
    pubAngle = piVisionTable.getDoubleTopic("Angle").publish();
    pubThreadCounter = piVisionTable.getDoubleTopic("ThreadCounter").publish();
    pubThreadCounterTime  = piVisionTable.getDoubleTopic("ThreadCounterTime").publish();      
    pubThreadsPerSecond  = piVisionTable.getDoubleTopic("ThreadsPerSecond").publish();

            //Update Network Tables
            pubDetectedNote.set(true);
            pubXCenter.set(1);
            pubYCenter.set(1);
            pubWidth.set(1);
            pubHeight.set(1);
            pubAngle.set(1);


    Sound sound = new Sound();

    // loop forever
    for (;;) {
      System.out.println("Playing sound");
      try {
        sound.playSound("crushedcan.wav");
        Thread.sleep(5000);
       
      } catch (InterruptedException ex) {
        return;
      }
    }
  }
}

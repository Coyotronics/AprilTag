package com.coyotronics.frc2022.commands;

import com.coyotronics.frc2022.Constants;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SwitchCameraCommand extends CommandBase {
    VideoSink serv;
    UsbCamera cam0, cam1;
    public SwitchCameraCommand(VideoSink server, UsbCamera camField, UsbCamera camIntake) {
        this.serv = server;
        this.cam0 = camField;
        this.cam1 = camIntake;
    }
    public void initialize() {
        System.out.println("CHANGING");
        if(Constants.Vars.cam == 0) {
            SmartDashboard.putString("Camera", "1: Intake");
            System.out.println("CHANGING TO 1");
            Constants.Vars.cam = 1;
            this.serv.setSource(cam1);
        } else {
            SmartDashboard.putString("Camera", "0: Field");
            System.out.println("CHANGING TO 0");
            Constants.Vars.cam = 0;
            this.serv.setSource(cam0);
        }
    }
    public void end(boolean interrupted) { }
     public boolean isFinished() {
        return true;
    }
}

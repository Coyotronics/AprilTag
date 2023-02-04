// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.coyotronics.frc2022;

import com.coyotronics.frc2022.commands.Drive.ManualDrive;
import com.coyotronics.frc2022.commands.Shooter.ShootCommand;
import com.coyotronics.frc2022.commands.VIsion.Vision;
import com.coyotronics.frc2022.commands.Auto.Groups.Shoot;
import com.coyotronics.frc2022.commands.Auto.Sequences.EmptyAuto;
import com.coyotronics.frc2022.commands.Auto.Sequences.OneBallAuto;
import com.coyotronics.frc2022.commands.Auto.Sequences.TwoBallAuto;
import com.coyotronics.frc2022.subsystems.DischargeSubsystem;
import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;
import com.coyotronics.frc2022.subsystems.GryoSubsystem;
import com.coyotronics.frc2022.subsystems.IntakeSubsystem;
import com.coyotronics.frc2022.subsystems.TransportSubsystem;
// import com.coyotronics.frc2022.commands.Auto.Visions.RedBallPipelineVTwo;
import com.coyotronics.frc2022.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.vision.VisionThread;


import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;

import org.photonvision.PhotonCamera;

import edu.wpi.first.cscore.CvSource;
public class RobotContainer {
  public static XboxController controller = new XboxController(Constants.Common.kController);
  private final DriveBaseSubsystem driveBase = new DriveBaseSubsystem();
  private final VisionSubsystem visionSubsystem = new VisionSubsystem();
  ManualDrive drive = new ManualDrive(driveBase);
  Vision vision;
  PhotonCamera camera;
  private final Command m_emptyAuto = new EmptyAuto();

  SendableChooser<Command> m_Chooser = new SendableChooser<>();

  public RobotContainer() {
    System.out.print("STARTING");
    startVision();
    setDefaults();
    configureButtonBindings();
   
  }
  public void startVision() {
    camera = new PhotonCamera("apriltagcam");;
    vision = new Vision(visionSubsystem, camera, driveBase);

  }

  public void setDefaults() {
    driveBase.setDefaultCommand(drive);
    visionSubsystem.setDefaultCommand(vision);
    m_Chooser.addOption("No Auto", m_emptyAuto);
    m_Chooser.addOption("No Auto", m_emptyAuto);
    SmartDashboard.putData(m_Chooser);
    
  }

  private void configureButtonBindings() {
  }

  public Command getAutonomousCommand() {
    return m_Chooser.getSelected();
  }
}

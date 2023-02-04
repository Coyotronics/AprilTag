// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.coyotronics.frc2022.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.coyotronics.frc2022.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class DriveBaseSubsystem extends SubsystemBase {
    private DifferentialDrive differentialDrive;

    private WPI_VictorSPX m_rightFrontMotor;
    private WPI_VictorSPX m_rightBackMotor;
    private WPI_VictorSPX m_leftFrontMotor; 
    private WPI_VictorSPX m_leftBackMotor;

    private MotorControllerGroup leftMotors;
    private MotorControllerGroup rightMotors;

  public DriveBaseSubsystem() {
    m_leftFrontMotor = new WPI_VictorSPX(Constants.Drive.kLeftFrontMotor);
    m_leftBackMotor = new WPI_VictorSPX(Constants.Drive.kLeftBackMotor);
    m_rightFrontMotor = new WPI_VictorSPX(Constants.Drive.kRightFrontMotor);
    m_rightBackMotor = new WPI_VictorSPX(Constants.Drive.kRightBackMotor);

    WPI_VictorSPX[] motors = {m_leftFrontMotor, m_leftBackMotor, m_rightFrontMotor, m_rightBackMotor}; //first 2 = left, second 2 = right;
    // for(WPI_VictorSPX motor : motors){
      // motor.restoreFactoryDefaults()
    // }

    //group motors
    leftMotors = new MotorControllerGroup(m_leftFrontMotor, m_leftBackMotor);
    rightMotors = new MotorControllerGroup(m_rightFrontMotor, m_rightBackMotor);

    rightMotors.setInverted(true);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
    
  }
  public void tankDrive(double left, double right) { //[-1...0...1] speed, speed, squareInputs = true
    differentialDrive.tankDrive(left, right, true);
  }
  public void arcadeDrive(double translational, double rotational) {
    SmartDashboard.putNumber("Foward", translational);
    SmartDashboard.putNumber("Turning", rotational);
    differentialDrive.arcadeDrive(translational, rotational, true);
  }
  public void arcadeDriveAuto(double translational, double rotational) {
    differentialDrive.arcadeDrive(translational, rotational, false);
  }
  // public void setMotorSpeeds(double one, double two) {
  //   this.motorspeed1 = one;
  //   this.motorspeed2 = two;
  // } 
  // private void periodicDrive() {
  //   if(Constants.Vars.cDriveType == Constants.Drive.DriveType.ARCADE)
  //     arcadeDrive(this.motorspeed1, this.motorspeed2);
  //   if(Constants.Vars.cDriveType == Constants.Drive.DriveType.TANK)
  //     tankDrive(this.motorspeed1, this.motorspeed2);
    
  //   SmartDashboard.putNumber("Motor Speed 1", motorspeed1);
  //   SmartDashboard.putNumber("Motor Speed 2", motorspeed2);
  // }
  public void stop() {
    if(Constants.Vars.cDriveType == Constants.Drive.DriveType.ARCADE)
      arcadeDrive(0, 0);
    else
      tankDrive(0, 0);
  }

 @Override
  public void periodic() {
      // periodicDrive();
  }
    
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

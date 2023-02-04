package com.coyotronics.frc2022.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.coyotronics.frc2022.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;


public class GryoSubsystem extends SubsystemBase {
  
  AHRS gyro;

  public GryoSubsystem() {
    try {
	    gyro =new AHRS(SerialPort.Port.kUSB);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
    this.gyro.calibrate();
    
  }
  public double getAngle() {
    return this.gyro.getAngle();
  }
  public void zeroOut() {
    this.gyro.zeroYaw();
  }
  public AHRS getGyro() {
    return this.gyro;
  }
  

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Connected", this.gyro.isConnected());
    SmartDashboard.putBoolean("Calibrated", !this.gyro.isCalibrating());
    SmartDashboard.putNumber("Rel Angle", this.gyro.getAngle());
  }
  @Override
  public void simulationPeriodic() {}
}

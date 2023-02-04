package com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces;
import com.coyotronics.frc2022.Constants.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;
import com.coyotronics.frc2022.subsystems.GryoSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class DriveTo extends CommandBase { //centimeters
    private final DriveBaseSubsystem driveBase;
    private final double movePerThread =  0.0405 * 2;
    private double speed = 0.25 * 2;
    private double radiusToMove;
    private double radiusMoved = 0;
    double initialAngle = 0;
    private final byte NAVX_DEVICE_UPDATE_RATE_HZ = 50;
    private final double TOLERANCE_DEGREES = 2.0;
    private final double P = 0.005;
    GryoSubsystem gyro;
    public double AUCSpeed(double distance) {
        if(distance <= 5) {
            return Math.max(distance / 5 * speed, 0.2);
        } else
            return speed;
    }
    public DriveTo(DriveBaseSubsystem db, GryoSubsystem gyro,double radius) {
        this.driveBase = db;
        this.radiusToMove = radius;
        this.gyro = gyro;
        addRequirements(this.driveBase);
    }
    public void initialize() {
        this.driveBase.stop();    
        this.radiusMoved = 0;
        this.initialAngle = gyro.getAngle();
    }
    public boolean isDone() {
        return Math.abs(this.radiusMoved - this.radiusToMove) < (0.05);
    }
    public void execute() {
        SmartDashboard.putString("Doing", "Driving");
        if(isDone()) return;
        double speedMove = AUCSpeed(Math.abs(radiusToMove - radiusMoved));
        // double error = -(gyro.getAngle() - initialAngle);
        // double correctPower = P * error;
        if(radiusToMove > 0){
            radiusMoved += (speedMove / speed) * movePerThread;
            driveBase.arcadeDriveAuto(-speedMove, 0);
        }
        else{
            radiusMoved -= (speedMove / speed) * movePerThread;
            driveBase.arcadeDriveAuto(speedMove, 0);
        }
    }
    public void end(boolean interrupted) {
        this.driveBase.stop();
    }
     public boolean isFinished() {
        return isDone();
    }
}

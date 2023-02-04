package com.coyotronics.frc2022.commands.Drive;

import com.coyotronics.frc2022.Constants;
import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ManualDrive extends CommandBase {
  private final DriveBaseSubsystem driveBase;

  public ManualDrive(DriveBaseSubsystem db) {
    this.driveBase = db;
    addRequirements(db);
  }

  public void initialize() {
    this.driveBase.stop();
  }

    public void execute() {
        if(Constants.Vars.cDriveType == Constants.Drive.DriveType.ARCADE)
            DirectionalDrive.drive(this.driveBase);
        else
            TankDrive.drive(this.driveBase);  
    }
    public void end(boolean interrupted) {
        this.driveBase.stop();
    }
     public boolean isFinished() {
        return false;
    }
}

package com.coyotronics.frc2022.commands.Auto.Groups;
import com.coyotronics.frc2022.Constants.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;

public class ReleaseIntake extends CommandBase { //centimeters
    private final DriveBaseSubsystem driveBase;
    int iterations = 0;
    public ReleaseIntake(DriveBaseSubsystem db) {
        this.driveBase = db;
        addRequirements(this.driveBase);
    }
    public void initialize() {
        iterations = 0;
        this.driveBase.stop();    
    }
    public boolean isDone() {
        return iterations > 30;
    }
    public void execute() {
        ++iterations;
        if(this.iterations > 15)
            this.driveBase.arcadeDrive(-0.65, 0);
        else
            this.driveBase.arcadeDrive(0.65, 0);
    }
    public void end(boolean interrupted) {
        this.driveBase.stop();
    }
     public boolean isFinished() {
        return isDone();
    }
}

package com.coyotronics.frc2022.commands.VIsion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;
import com.coyotronics.frc2022.subsystems.GryoSubsystem;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FindAndPursueAT extends CommandBase {
    private final DriveBaseSubsystem drivebase;
    double kP = 0.7;
    int numclear = 0;
	double speed;
	int count = 0;
    public FindAndPursueAT(DriveBaseSubsystem driveBase, double speed) {
        this.drivebase = driveBase;
		this.speed = speed;
        addRequirements(driveBase);

    }

    @Override
    public void initialize() {
        drivebase.stop();
    }

    @Override
    public void execute() {
        if(VV.trackingtest.targets) {
            VV.trackingtest.iterationsFromLastTarget = 0;
            drivebase.stop();
            if(Math.abs(VV.trackingtest.theta) < VV.trackingtest.angleTolerance) {
                if(VV.trackingtest.X < 0.35) {
                    drivebase.stop();
                } else {
                    drivebase.arcadeDriveAuto((VV.trackingtest.X) * VV.trackingtest.transkP, 0);
                }
            } else {
                drivebase.arcadeDriveAuto(0, MathUtil.clamp((-VV.trackingtest.theta) * VV.trackingtest.anglekP, -0.5, 0.5));

            }

        } 
        else if(VV.trackingtest.iterationsFromLastTarget < 11) {
            drivebase.stop();
            VV.trackingtest.iterationsFromLastTarget++;
        }
        else {
            drivebase.arcadeDriveAuto(0, 0.3);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drivebase.stop();
    }
}
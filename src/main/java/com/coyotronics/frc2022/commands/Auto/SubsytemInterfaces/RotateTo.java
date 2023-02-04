package com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;
import com.coyotronics.frc2022.subsystems.GryoSubsystem;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateTo extends CommandBase {
    /** Creates a new TurnToNAngle. */
    public double turnAngle = 0, currentAngle = 0, tempAngle;
    private final DriveBaseSubsystem drivebase;
    private final GryoSubsystem gyro;
    double tolerance = 2;
    double kP = 0.03;
    int numclear = 0;
    public RotateTo(DriveBaseSubsystem driveBase, GryoSubsystem gyro, double angle) {
        this.tempAngle = angle;
        this.drivebase = driveBase;
        this.gyro = gyro;
        addRequirements(driveBase, gyro);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        gyro.zeroOut();
        currentAngle = gyro.getAngle();
        this.turnAngle = gyro.getAngle() + this.tempAngle;
        drivebase.stop();
        numclear = 0;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        SmartDashboard.putNumber("Want Angle", this.turnAngle);
        SmartDashboard.putString("Doing", "Rotating");
        currentAngle = gyro.getAngle();
        double error = turnAngle - currentAngle;
        double speed;
        speed = kP * error;
        speed = MathUtil.clamp(speed, -0.5, 0.5);
        drivebase.arcadeDriveAuto(0, -speed);

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drivebase.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(Math.abs(turnAngle - currentAngle) < tolerance) {
            ++numclear;
            if(numclear > 10)
                return true;
        } else 
            numclear = 0;
        return false;
    }


}
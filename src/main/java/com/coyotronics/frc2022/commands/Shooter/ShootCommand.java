package com.coyotronics.frc2022.commands.Shooter;

import com.coyotronics.frc2022.subsystems.DischargeSubsystem;
import com.coyotronics.frc2022.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootCommand extends CommandBase {
    private final DischargeSubsystem shooter;
    private Constants.Shooter.ShootType type;
    public ShootCommand(DischargeSubsystem ss, Constants.Shooter.ShootType hub) {
        this.shooter = ss;
        this.type = hub;
        addRequirements(this.shooter);
    }

    public void initialize() {
        this.shooter.reset();
    }

    public void execute() {
        if(this.type == Constants.Shooter.ShootType.HIGH) {
            this.shooter.shootDischarge(Constants.Shooter.kDischargeSpeedHighHub);
        } else {
            this.shooter.shootDischarge(Constants.Shooter.kDischargeSpeedLowHub);
        }
    }
    public void end(boolean interrupted) {
        this.shooter.stop();
    }
     public boolean isFinished() {
        return false;
    }
}

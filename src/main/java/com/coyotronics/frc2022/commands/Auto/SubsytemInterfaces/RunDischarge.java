package com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces;

import com.coyotronics.frc2022.subsystems.DischargeSubsystem;
import com.coyotronics.frc2022.subsystems.IntakeSubsystem;
import com.coyotronics.frc2022.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunDischarge extends CommandBase {
    private final DischargeSubsystem discharge;
    private double seconds;
    private Constants.Shooter.ShootType type;
    int iterations = 0;
    public RunDischarge(DischargeSubsystem ss, double seconds, Constants.Shooter.ShootType type) {
        this.discharge = ss;
        this.seconds = seconds;
        this.type = type;
        addRequirements(this.discharge);
    }
    public void initialize() {
        this.iterations = 0;
        this.discharge.reset();
        this.discharge.shootDischarge((type == Constants.Shooter.ShootType.HIGH) ? Constants.Shooter.kDischargeSpeedHighHub : Constants.Shooter.kDischargeSpeedLowHub);
    }
    public void execute() {
        ++iterations;
    }
    public void end(boolean interrupted) {
        this.discharge.stop();
    }
     public boolean isFinished() {
        return this.iterations * 0.03 >= seconds;
    }
}

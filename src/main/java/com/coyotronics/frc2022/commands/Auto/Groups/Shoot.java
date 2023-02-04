package com.coyotronics.frc2022.commands.Auto.Groups;

import com.coyotronics.frc2022.subsystems.IntakeSubsystem;
import com.coyotronics.frc2022.subsystems.TransportSubsystem;
import com.coyotronics.frc2022.subsystems.DischargeSubsystem;
import com.coyotronics.frc2022.Constants;
import com.coyotronics.frc2022.Constants.Intake;
import com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces.RunDischarge;
import com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces.RunIntake;
import com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces.RunTransport;

import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Shoot extends SequentialCommandGroup {
    public Shoot(TransportSubsystem ts, DischargeSubsystem ds, double seconds, Constants.Shooter.ShootType type) { 
        addCommands(
            new RunDischarge(ds, seconds - 2, Constants.Shooter.ShootType.HIGH),
            new ParallelCommandGroup(
                new RunDischarge(ds, 2, Constants.Shooter.ShootType.HIGH),
                new RunTransport(ts, 2, false)
            )
        );
    }
    public Shoot(TransportSubsystem ts, DischargeSubsystem ds, double seconds, Constants.Shooter.ShootType type, boolean runback) {
        addCommands(
            new ParallelCommandGroup(
                new RunDischarge(ds, seconds - 2, Constants.Shooter.ShootType.HIGH),
                new RunTransport(ts, seconds - 2, true)
            ),
            new ParallelCommandGroup(
                new RunDischarge(ds, 2, Constants.Shooter.ShootType.HIGH),
                new RunTransport(ts, 2, false)
            )
        );
    }
}

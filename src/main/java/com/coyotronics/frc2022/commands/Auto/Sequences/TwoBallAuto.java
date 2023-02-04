package com.coyotronics.frc2022.commands.Auto.Sequences;
import com.coyotronics.frc2022.commands.Auto.Groups.DriveAndIntake;
import com.coyotronics.frc2022.commands.Auto.Groups.ReleaseIntake;
import com.coyotronics.frc2022.commands.Auto.Groups.Shoot;
import com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces.DriveTo;
import com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces.RotateTo;
import com.coyotronics.frc2022.subsystems.DischargeSubsystem;
import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;
import com.coyotronics.frc2022.subsystems.GryoSubsystem;
import com.coyotronics.frc2022.subsystems.IntakeSubsystem;
import com.coyotronics.frc2022.subsystems.TransportSubsystem;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import com.coyotronics.frc2022.Constants;
public class TwoBallAuto extends SequentialCommandGroup {
    public TwoBallAuto(DriveBaseSubsystem drive, DischargeSubsystem shooter, IntakeSubsystem intake, TransportSubsystem transport, GryoSubsystem gyro) {
        addCommands(
            new DriveTo(drive, gyro, -3.5),
            new Shoot(transport, shooter, 4, Constants.Shooter.ShootType.HIGH),
            new DriveTo(drive, gyro, -2)
            // new ReleaseIntake(drive),
            // new RotateTo(drive, gyro, 180),
            // new DriveAndIntake(drive, intake, gyro, transport, 5, 100),
            // new RotateTo(drive, gyro, 180),
            // new DriveTo(drive, gyro, 8.5),
            // new Shoot(transport, shooter, 4, Constants.Shooter.ShootType.HIGH)
        );
    }
}

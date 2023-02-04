package com.coyotronics.frc2022.commands.Auto;
import com.coyotronics.frc2022.Constants;
import com.coyotronics.frc2022.Constants.Auto;
import com.coyotronics.frc2022.Constants.Drive;
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

public class AutoSequence extends SequentialCommandGroup {
    public AutoSequence(DriveBaseSubsystem drive, DischargeSubsystem shooter, IntakeSubsystem intake, TransportSubsystem transport, GryoSubsystem gyro) {
       // addCommands(
        //     new ReleaseIntake(drive),
        //     new RotateTo(drive, 180),
        //     new DriveAndIntake(drive, intake, transport, 6, 10000),
        //     new RotateTo(drive, 180),
        //     new DriveTo(drive, 15),
        //     new Shoot(transport, shooter, 5)
        // );
    // }
        addCommands(
            // new DriveTo(drive, -2)
            // new Shoot(transport, shooter, 3),
            new DriveTo(drive, gyro, -1),
            new RotateTo(drive, gyro, 180),
            new ReleaseIntake(drive),
            // new DriveAndIntake(drive, intake, gyro, transport, 8, 10),
            new RotateTo(drive, gyro, 180),
            new DriveTo(drive, gyro, 9),
            new Shoot(transport, shooter, 5, Constants.Shooter.ShootType.HIGH)

            // new DriveTo(drive, -3),
            // new ReleaseIntake(drive),
            // new RotateTo(drive, 160),
            // new DriveAndIntake(drive, intake, transport, 3, 150)
            

            // new RotateTo(drive, -150),
            // new DriveTo(drive, 6)
            // new Shoot(transport, shoot, 3)
        );
    }
}

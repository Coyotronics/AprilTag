package com.coyotronics.frc2022.commands.Auto.Sequences;
import com.coyotronics.frc2022.Constants.Auto;
import com.coyotronics.frc2022.Constants.Drive;
import com.coyotronics.frc2022.commands.Auto.Groups.DriveAndIntake;
import com.coyotronics.frc2022.commands.Auto.Groups.ReleaseIntake;
import com.coyotronics.frc2022.commands.Auto.Groups.Shoot;
import com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces.DriveTo;
import com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces.RotateTo;
import com.coyotronics.frc2022.subsystems.DischargeSubsystem;
import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;
import com.coyotronics.frc2022.subsystems.IntakeSubsystem;
import com.coyotronics.frc2022.subsystems.TransportSubsystem;
import com.coyotronics.frc2022.subsystems.GryoSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import com.coyotronics.frc2022.Constants;
public class OneBallAuto extends SequentialCommandGroup {
    public OneBallAuto(DriveBaseSubsystem drive, DischargeSubsystem shooter, IntakeSubsystem intake, TransportSubsystem transport, GryoSubsystem gyro) {
        addCommands(
            // new DriveTo(drive, gyro, -2.5),
            new Shoot(transport, shooter, 4.5, Constants.Shooter.ShootType.HIGH)
            // new DriveTo(drive, gyro, -3)
        );
    }
}

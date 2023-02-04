package com.coyotronics.frc2022.commands.Shooter;

import com.coyotronics.frc2022.subsystems.TransportSubsystem;
import com.coyotronics.frc2022.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;

// public class RunTransportCommand extends CommandBase {
//     private final TransportSubsystem transport;

//     public RunTransportCommand(TransportSubsystem ss) {
//         this.transport = ss;
//         addRequirements(this.transport);
//     }

//     public void initialize() {
//         this.transport.reset();
//     }

//     public void execute() {
//         this.transport.runTransport(Constants.Shooter.kTransportSpeed);
//     }
//     public void end(boolean interrupted) {
//         this.transport.stop();
//     }
//      public boolean isFinished() {
//         return false;
//     }
// }

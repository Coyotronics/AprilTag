package com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces;

import com.coyotronics.frc2022.subsystems.IntakeSubsystem;
import com.coyotronics.frc2022.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIntake extends CommandBase {
    private final IntakeSubsystem intake;
    private double seconds;
    int iterations = 0;
    public RunIntake(IntakeSubsystem ss, double seconds) {
        this.intake = ss;
        this.seconds = seconds;
        addRequirements(this.intake);
    }
    public void initialize() {
        this.intake.reset();
        iterations = 0;
        this.intake.run();
    }
    public void execute() {
        ++iterations;
    }
    public void end(boolean interrupted) {
        this.intake.stop();
    }
     public boolean isFinished() {
        return this.iterations * 0.030 >= seconds;
    }
}

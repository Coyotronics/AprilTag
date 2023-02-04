package com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces;

import com.coyotronics.frc2022.subsystems.TransportSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunTransport extends CommandBase {
    private final TransportSubsystem transport;
    private double seconds;
    boolean backward;
    int iterations = 0;
    public RunTransport(TransportSubsystem ts, double seconds, boolean backward) {
        this.transport = ts;
        this.seconds = seconds;
        this.backward = backward;
        addRequirements(this.transport);
    }
    public void initialize() {
        iterations = 0;
        this.transport.reset();
        if(this.backward)
            this.transport.runBackward();
        else
            this.transport.run();
    }
    public void execute() {
        ++iterations;
    }
    public void end(boolean interrupted) {
        this.transport.stop();
    }
     public boolean isFinished() {
        return this.iterations * 0.03 >= seconds;
    }
}

package com.coyotronics.frc2022.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

abstract public class ToggleSubsystem extends SubsystemBase {
    CANSparkMax m_motor;
    double speed;   
    double toggleSpeed;
    public ToggleSubsystem(int kMotor, double maxspeed) {
        this.m_motor = new CANSparkMax(kMotor, MotorType.kBrushless);
        this.m_motor.restoreFactoryDefaults();
        this.toggleSpeed = maxspeed;
        this.reset();
    }
    public void reset() {
        this.m_motor.set(this.speed = 0);
    } 
    public void stop() {reset();}
    public void run() {this.speed = toggleSpeed; }
    @Override
    public void periodic() {this.m_motor.set(this.speed);}
    @Override
    public void simulationPeriodic() {}
}

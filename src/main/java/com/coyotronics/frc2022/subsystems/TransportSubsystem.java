package com.coyotronics.frc2022.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TransportSubsystem extends SubsystemBase{
    VictorSPX m_motor;
    double speed;   
    double toggleSpeed;
    public TransportSubsystem(int kMotor, double maxspeed) {
        this.m_motor = new VictorSPX(kMotor);
        this.toggleSpeed = maxspeed;
        this.reset();
    }
    public void reset() {
        this.m_motor.set(ControlMode.PercentOutput, this.speed = 0);
    } 
    public void stop() {reset();}
    public void run() {this.speed = toggleSpeed; }
    public void runBackward() { this.speed = -toggleSpeed; }
    @Override
    public void periodic() {this.m_motor.set(ControlMode.PercentOutput, this.speed);}
    @Override
    public void simulationPeriodic() {}
}

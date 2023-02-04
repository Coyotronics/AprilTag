package com.coyotronics.frc2022.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.coyotronics.frc2022.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DischargeSubsystem extends SubsystemBase {
  
  private CANSparkMax m_dischargeMotor;

  public DischargeSubsystem() {
    m_dischargeMotor = new CANSparkMax(Constants.Shooter.kDischargeMotor, MotorType.kBrushless);

    m_dischargeMotor.restoreFactoryDefaults();
  }
  public void reset() {
    this.m_dischargeMotor.set(0);
  }
  public void stop() {
    this.reset();
  }
  public void shootDischarge(double speed) {
    this.m_dischargeMotor.set(speed);
  }

  @Override
  public void periodic() {}
  @Override
  public void simulationPeriodic() {}
}

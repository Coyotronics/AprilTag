package com.coyotronics.frc2022.subsystems;


import com.coyotronics.frc2022.Constants;

public class IntakeSubsystem extends ToggleSubsystem {
  public IntakeSubsystem() {
    super(Constants.Intake.kIntakeMotor, -Constants.Intake.kIntakeSpeed);
  }
  public void runFoward() {
    super.speed = -Constants.Intake.kIntakeSpeed;
  }
  public void runBackward() {
    super.speed = Constants.Intake.kIntakeSpeed;
  }
}

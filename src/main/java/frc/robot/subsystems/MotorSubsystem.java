package frc.robot.subsystems;



import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorSubsystem extends SubsystemBase {

  private CANSparkMax buttonMotor;
  private CANSparkMax axisMotor;
  private RelativeEncoder buttonMotorEncoder;
  private RelativeEncoder axisMotorEncoder;

  public MotorSubsystem() {
    buttonMotor = new CANSparkMax(Constants.MotorConstants.BUTTON_MOTOR_PORT, MotorType.kBrushless);
    axisMotor = new CANSparkMax(Constants.MotorConstants.AXIS_MOTOR_PORT, MotorType.kBrushless);
    buttonMotorEncoder = buttonMotor.getEncoder();
    axisMotorEncoder = axisMotor.getEncoder();
  }

  public void spinButtonMotor(double speed) {
    buttonMotor.set(speed);
  }

  public void spinAxisMotor(double speed) {
    axisMotor.set(speed);
  }

  public void stopButtonMotor() {
    buttonMotor.set(Constants.Speeds.STOP_SPEED);
  }

  public void stopAxisMotor() {
    axisMotor.set(Constants.Speeds.STOP_SPEED);
  }

  /////////////////////New methods for this class return encoder values

  public double getAxisMotorEncoder() {
    return axisMotorEncoder.getPosition();
  }

  public double getButtonMotorEncoder() {
    return buttonMotorEncoder.getPosition();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Button Motor Position: ", buttonMotorEncoder.getPosition());
    SmartDashboard.putNumber("Axis Motor Position: ", axisMotorEncoder.getPosition());
  }
}
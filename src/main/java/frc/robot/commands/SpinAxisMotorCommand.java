
package frc.robot.commands;

import frc.robot.subsystems.MotorSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;


public class SpinAxisMotorCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final MotorSubsystem m_subsystem;
  private final Supplier <Double> speedFunction;

 
  public SpinAxisMotorCommand(MotorSubsystem subsystem, Supplier<Double> speedFunction) {
    m_subsystem = subsystem;
    this.speedFunction = speedFunction;
   
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    double currentSpeed = speedFunction.get()*.25;
    if (currentSpeed > -.1 && currentSpeed < .1) {
      currentSpeed = 0;
    }
    m_subsystem.spinAxisMotor(currentSpeed);
  }

  
  @Override
  public void end(boolean interrupted) {
  m_subsystem.stopAxisMotor();
  }

 
  @Override
  public boolean isFinished() {
    if(m_subsystem.getAxisMotorEncoder() > 40.0 || m_subsystem.getAxisMotorEncoder() < -40.0) {
      return true;
    }
    
    else {
      return false;
    }

  }
}
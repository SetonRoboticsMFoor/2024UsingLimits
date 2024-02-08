
package frc.robot.commands;

import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class SpinButtonMotorForwardCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final MotorSubsystem m_subsystem;
  private double speed;

 
  public SpinButtonMotorForwardCommand(MotorSubsystem subsystem, double speed) {
    m_subsystem = subsystem;
    this.speed = speed;
   
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    m_subsystem.spinButtonMotor(speed);
  }

  
  @Override
  public void end(boolean interrupted) {
    m_subsystem.stopButtonMotor();
  }

 
  @Override
  public boolean isFinished() {
    if(m_subsystem.getButtonMotorEncoder() > 40) {
      return true;
    } 
    
    else {
      return false;
    }
}
}
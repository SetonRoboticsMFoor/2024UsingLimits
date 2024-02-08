
package frc.robot;

import frc.robot.commands.SpinAxisMotorCommand;
import frc.robot.commands.SpinButtonMotorForwardCommand;
import frc.robot.commands.SpinButtonMotorRevCommand;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private MotorSubsystem m_motorSubsystem;
  private Joystick m_controller;
  private JoystickButton m_forwButton;
  private JoystickButton m_revButton;

  public RobotContainer() {
    m_motorSubsystem = new MotorSubsystem();
    m_controller = new Joystick(Constants.OperatorConstants.DRIVER_CONTROLLER_PORT);
    m_forwButton = new JoystickButton(m_controller, Constants.OperatorConstants.FWD_BUTTON_PORT);
    m_revButton = new JoystickButton(m_controller, Constants.OperatorConstants.REV_BUTTON_PORT);

    m_motorSubsystem.setDefaultCommand(
        new SpinAxisMotorCommand(m_motorSubsystem, ()-> m_controller.getRawAxis(Constants.OperatorConstants.DRIVE_AXIS)));

    configureBindings();
    m_forwButton.toggleOnTrue(new SpinButtonMotorForwardCommand(m_motorSubsystem, Constants.Speeds.FWD_DRIVE_SPEED));
    m_revButton.toggleOnTrue(new SpinButtonMotorRevCommand(m_motorSubsystem, Constants.Speeds.REV_DRIVE_SPEED));

  }

  private void configureBindings() {
  }
}
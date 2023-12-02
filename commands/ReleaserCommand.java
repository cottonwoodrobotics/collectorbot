// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ReleaserSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.GenericHID;

/** An example command that uses an example subsystem. */
public class ReleaserCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ReleaserSubsystem m_subsystem;
  private final GenericHID m_controller;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ReleaserCommand(ReleaserSubsystem subsystem, GenericHID controller) {
    m_subsystem = subsystem;
    m_controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = 0;
    boolean releaseButtonPressed = m_controller.getRawButton(Constants.buttonRelease);
    boolean latchButtonPressed = m_controller.getRawButton(Constants.buttonLatch);
    if (releaseButtonPressed) {
        speed = 0.5;
    } else if (latchButtonPressed) {
        speed = -0.5;
    } else {
        speed = 0;
    }
    m_subsystem.release(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

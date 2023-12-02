// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.CollectorCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ReleaserCommand;
import frc.robot.subsystems.CollectorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ReleaserSubsystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final GenericHID m_driverController = new GenericHID(Constants.OperatorConstants.kDriverControllerPort);
  // The robot's subsystems and commands are defined here...
  /* Subsystems */
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final CollectorSubsystem m_collectorSubsystem = new CollectorSubsystem();
  private final ReleaserSubsystem m_releaserSubsystem = new ReleaserSubsystem();

  /* Commands */
  private final DriveCommand m_driveCommand = new DriveCommand(m_driveSubsystem, m_driverController);
  private final CollectorCommand m_collectorCommand = new CollectorCommand(m_collectorSubsystem, m_driverController);
  private final ReleaserCommand m_releaserCommand = new ReleaserCommand(m_releaserSubsystem, m_driverController);
  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_driveSubsystem.setDefaultCommand(m_driveCommand);
    m_collectorSubsystem.setDefaultCommand(m_collectorCommand);
    m_releaserSubsystem.setDefaultCommand(m_releaserCommand);
  }

  private void configureBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
    return null;
  }
}

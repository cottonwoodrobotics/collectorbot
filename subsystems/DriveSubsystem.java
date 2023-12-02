// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    motorBackLeft.restoreFactoryDefaults();
    motorBackRight.restoreFactoryDefaults();
    motorFrontLeft.restoreFactoryDefaults();
    motorFrontRight.restoreFactoryDefaults();

    motorBackLeft.setInverted(true);
    motorFrontLeft.setInverted(true);

    motorBackLeft.setSmartCurrentLimit(38);
    motorBackRight.setSmartCurrentLimit(38);
    motorFrontLeft.setSmartCurrentLimit(38);
    motorFrontRight.setSmartCurrentLimit(38);
    motorBackLeft.setSecondaryCurrentLimit(40);
    motorBackRight.setSecondaryCurrentLimit(40);
    motorFrontLeft.setSecondaryCurrentLimit(40);
    motorFrontRight.setSecondaryCurrentLimit(40);

  }
  CANSparkMax motorBackLeft = new CANSparkMax(Constants.IDBackLeft, MotorType.kBrushless);
  CANSparkMax motorBackRight = new CANSparkMax(Constants.IDBackRight, MotorType.kBrushless);
  CANSparkMax motorFrontLeft = new CANSparkMax(Constants.IDFrontLeft, MotorType.kBrushless);
  CANSparkMax motorFrontRight = new CANSparkMax(Constants.IDFrontRight, MotorType.kBrushless);

  public void driveCartesian(double xSpeed, double ySpeed, double zRotation) {
    WheelSpeeds wheelSpeeds = MecanumDrive.driveCartesianIK(xSpeed, ySpeed, zRotation);

    motorFrontLeft.set(wheelSpeeds.frontRight);
    motorFrontRight.set(wheelSpeeds.frontLeft);
    motorBackLeft.set(wheelSpeeds.rearLeft);
    motorBackRight.set(wheelSpeeds.rearRight);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

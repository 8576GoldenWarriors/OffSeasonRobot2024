// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Commands.ElevatorDownCommand;
import frc.robot.Commands.ElevatorUpCommand;
import frc.robot.Commands.IntakeInCommand;
import frc.robot.Commands.IntakeOutCommand;
import frc.robot.Commands.SwerveDrive;
import frc.robot.Constants.Constants;
import frc.robot.Subsystems.Elevator;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Drivetrain;


public class RobotContainer {
  Intake m_intake = new Intake();
  Elevator m_elevator = new Elevator();
  public static final Drivetrain m_drivetrain = Drivetrain.getInstance();

  public static final CommandXboxController driverController = new CommandXboxController(Constants.ControllerConstants.driverControllerPort);
  CommandXboxController operatorController = new CommandXboxController(Constants.ControllerConstants.operatorControllerPort);

  private final JoystickButton resetHeading_Start = new JoystickButton(driverController.getHID(), XboxController.Button.kStart.value);

  private final SendableChooser<Command> autoChooser;


  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new SwerveDrive());
   //Add all the choise of Autonomous modes to the Smart Dashboard
    autoChooser = AutoBuilder.buildAutoChooser();
    
    configureBindings();
  }

  private void configureBindings() {
    //Driver controller
    resetHeading_Start.onTrue(
      new InstantCommand(m_drivetrain::zeroHeading, m_drivetrain));

    operatorController.y().whileTrue(new ElevatorUpCommand(m_elevator));
    operatorController.a().whileTrue(new ElevatorDownCommand(m_elevator));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

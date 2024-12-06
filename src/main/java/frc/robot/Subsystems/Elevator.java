// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import au.grapplerobotics.LaserCan;
import au.grapplerobotics.LaserCan.Measurement;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

import frc.robot.Constants.Constants;

public class Elevator extends PIDSubsystem {
  static CANSparkMax leftMotor = new CANSparkMax(Constants.ElevatorConstants.leftElevatorSparkMaxID, MotorType.kBrushless);
  static CANSparkMax rightMotor = new CANSparkMax(Constants.ElevatorConstants.rightElevatorSparkMaxID, MotorType.kBrushless);

  static LaserCan lc = new LaserCan(30);


  static double temp = 0.0;
  public Elevator() {
    
    super(new PIDController(0.5, temp, temp));


    leftMotor.setIdleMode(IdleMode.kBrake);
    leftMotor.setInverted(false);

    rightMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setInverted(true);

    setSetpoint(Constants.ElevatorConstants.kExampleSetpoint);

    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Measurement measurement = lc.getMeasurement();
    

    SmartDashboard.putNumber("Laser Measurement", measurement.distance_mm);

  }

  public void setSpeed(double speed) {
    leftMotor.set(speed);
    rightMotor.set(speed);
  }

  @Override
  protected void useOutput(double output, double setpoint) {
      setSpeed(output);//plan to use feedforward in the future
      
  }
  @Override
  protected double getMeasurement() {
      
      return 0; //Configure after we get an encoder
  }
}

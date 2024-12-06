package frc.robot.Constants;

import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public class Constants {
    
    public class IntakeConstants{
        public static final int intakeSparkMaxID = 20; // Change this later
        public static final double intakeOutSpeed = 0.5;
        public static final double intakeInSpeed = -0.5;
    }

    public class ControllerConstants{
        public static final int driverControllerPort = 0;
        public static final int operatorControllerPort = 1;
    }

    public class ElevatorConstants{
        public static final int leftElevatorSparkMaxID = 12;
        public static final int rightElevatorSparkMaxID = 11;
        public static final double elevatorUpSpeed = 0.2;
        public static final double elevatorDownSpeed = -0.2;
        public static final int laserCanId = 30;
        public static final double kPUp = 0.0;
        public static final double kIUp = 0.0;
        public static final double kDUp = 0.0;

        
        public static final double kPDown = 0.0;   
        public static final double kIDown = 0.0;
        public static final double kDDown = 0.0;

        public static final double kExampleSetpoint = 10;
    }

     public static final class SwerveConstants{


     public static final int LEFT_FRONT_DRIVE_ID = 7;
     public static final int RIGHT_FRONT_DRIVE_ID = 1;
     public static final int LEFT_BACK_DRIVE_ID = 4; // 5
     public static final int RIGHT_BACK_DRIVE_ID = 3; // 3
    
     public static final int LEFT_FRONT_TURN_ID = 6;
     public static final int RIGHT_FRONT_TURN_ID = 8;
     public static  final int LEFT_BACK_TURN_ID = 5; // 4 
     public static final int RIGHT_BACK_TURN_ID = 2; // 2
    
    public static final int LEFT_FRONT_CANCODER_ID = 3;
    public static final int RIGHT_FRONT_CANCODER_ID = 4;
    public static final int LEFT_BACK_CANCODER_ID = 0; // 2
    public static final int RIGHT_BACK_CANCODER_ID = 1;

    public static final int PIGEON_ID = 0;

    //COMP OFFSETS
    public static  double LEFT_FRONT_OFFSET =0.205811;//0.206055; //0.222412;//0.213135;//0.216064;//0.721680;//0.732666;//0.292969;//0.723145;//0.717041;//0.717041;//0.710938 ;//0.725098;//0.719971;	
    public static  double RIGHT_FRONT_OFFSET = 0.798828;//0.301514;//0.799072;//0.302246;//0.306885;//0.792725;//0.712891;//0.817383;
    public static  double LEFT_BACK_OFFSET = 0.253662;//0.517090;//0.524902;//0.017334;//0.794189;//0.818115;//0.300781;//0.303711;//0.847412;//0.448730;//0.455322;//0.418945;//0.490967;//0.519043;
    public static  double RIGHT_BACK_OFFSET = 0.666748;//0.514160;//0.512451;//0.011475 ;//0.012451;//0.014404;//0.510498;//0.504883;//0.013916; 

    public static final double WHEEL_DIAMETER = Units.inchesToMeters(4.00); //originally 4 in template
    public static final double DRIVE_MOTOR_GEAR_RATIO = 6.75;
    public static final double TURN_MOTOR_GEAR_RATIO = 150.0/7;
    public static final double DRIVE_MOTOR_PCONVERSION = WHEEL_DIAMETER * Math.PI / DRIVE_MOTOR_GEAR_RATIO;
    public static final double TURN_MOTOR_PCONVERSION = 2 * Math.PI / TURN_MOTOR_GEAR_RATIO;//2 * Math.PI
    public static final double DRIVE_MOTOR_VCONVERSION = DRIVE_MOTOR_PCONVERSION / 60.0;
    public static final double TURN_MOTOR_VCONVERSION = TURN_MOTOR_PCONVERSION / 60.0;
    public static final double KP_TURNING = 0.575;

    public static final double DRIVETRAIN_MAX_SPEED = 5.3;//4.0, 5.5;
    public static final double DRIVETRAIN_MAX_ANGULAR_SPEED = 5 * Math.PI; //3.5, 4.25, 5

    //Teleop constraints
    public static final double TELE_DRIVE_MAX_SPEED = DRIVETRAIN_MAX_SPEED / 0.89; //0.85
    public static final double TELE_DRIVE_MAX_ANGULAR_SPEED = DRIVETRAIN_MAX_ANGULAR_SPEED / 1.75;
    public static final double TELE_DRIVE_MAX_ACCELERATION = 7.5; //3
    public static final double TELE_DRIVE_MAX_ANGULAR_ACCELERATION = 15; //

    public static final double AUTO_KP_TTANSLATION = 1.35; //1.15
    public static final double AUTO_KP_ROTATIONAL = 0.1; //0.1

    public static final double TRACK_WIDTH = Units.inchesToMeters(23.875);
    public static final double WHEEL_BASE = Units.inchesToMeters(23.875);
    public static final double DRIVE_BASE_RADIUS = Math.sqrt((Math.pow(TRACK_WIDTH, 2) + Math.pow(WHEEL_BASE, 2))) / 2.0;

    public static final HolonomicPathFollowerConfig AUTO_CONFIG = new HolonomicPathFollowerConfig(
      new PIDConstants(AUTO_KP_TTANSLATION, 0, 0),
      new PIDConstants(AUTO_KP_ROTATIONAL, 0, 0),
      DRIVETRAIN_MAX_SPEED,
      DRIVE_BASE_RADIUS,
      new ReplanningConfig()
    );


    //Swerve Kinematics
    public static final SwerveDriveKinematics DRIVE_KINEMATICS = new SwerveDriveKinematics(
        new Translation2d(WHEEL_BASE / 2, TRACK_WIDTH / 2),
        new Translation2d(WHEEL_BASE / 2, -TRACK_WIDTH / 2),
        new Translation2d(-WHEEL_BASE / 2, TRACK_WIDTH / 2),
        new Translation2d(-WHEEL_BASE / 2, -TRACK_WIDTH / 2)
    );

  }


 }
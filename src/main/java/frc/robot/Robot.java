// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  XboxController xboxController1 = new XboxController(0);
  XboxController xboxController2 = new XboxController(1);


  private SparkMax kaldirindir1 = new SparkMax(6, MotorType.kBrushed);
  private SparkMax kaldirindir2 = new SparkMax(7, MotorType.kBrushed);
  private SparkMax asansormotorsol = new SparkMax(1, MotorType.kBrushless);
  private SparkMax asansormotorsag = new SparkMax(5, MotorType.kBrushless);
  private SparkMax coraloynarmotor = new SparkMax(29, MotorType.kBrushless);
  private SparkMax coralalatmotor = new SparkMax(2, MotorType.kBrushed);
  private SparkMax algalatmotorsol = new SparkMax(3, MotorType.kBrushed);
  private SparkMax algalatmotorsag = new SparkMax(38, MotorType.kBrushed);
  private SparkMax algoynarmotor = new SparkMax(34, MotorType.kBrushed);
  public RelativeEncoder coraloynarmotorEncoder = coraloynarmotor.getEncoder();
  public RelativeEncoder asansormotorsagEncoder = asansormotorsag.getEncoder();




/* 
  public final RelativeEncoder coraloynarmotorencoder = coraloynarmotor.getEncoder();
  public final RelativeEncoder ElevatorEncoder1 = asansormotorsag.getEncoder();
  public final RelativeEncoder ElevatorEncoder2 = asansormotorsol.getEncoder();*/
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {

  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    }
  

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
     SmartDashboard.putNumber("Elevator Velocity1", coraloynarmotorEncoder.getVelocity());

    SmartDashboard.putNumber("Coral Motor Encoder", coraloynarmotorEncoder.getPosition());
    SmartDashboard.putNumber("Asansor Motor Encoder", asansormotorsagEncoder.getPosition());



double soljoystickkontrolcu1 = -xboxController1.getRawAxis(1);
double sagjoystickkontrolcu1 = -xboxController1.getRawAxis(5);
double soljoystickkontrolcu2 = -xboxController2.getRawAxis(1);
double sagjoystickkontrolcu2 = -xboxController2.getRawAxis(5);
double sagtrigerkontrolcu1 = xboxController1.getRawAxis(3);
double soltrigerkontrolcu1 = xboxController1.getRawAxis(2);

asansormotorsol.set(sagjoystickkontrolcu1);
asansormotorsag.set(-sagjoystickkontrolcu1);

kaldirindir1.set(soljoystickkontrolcu1*0.6);
kaldirindir2.set(-soljoystickkontrolcu1*0.6);

coralalatmotor.set(sagjoystickkontrolcu2);
algalatmotorsag.set(- soljoystickkontrolcu2);


algalatmotorsol.set(-soljoystickkontrolcu2);

coraloynarmotor.set(soltrigerkontrolcu1*-0.2);

  }
  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}
  
  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}

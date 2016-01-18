package org.usfirst.frc.team5590.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class RobotMap {
	public static SpeedController drivetrainLeftTrackMotor;
    public static SpeedController drivetrainRightTrackMotor;
    public static SpeedController ballCollectorMotor;
    public static SpeedController ballShooterMotor;
    public static SpeedController breachArmMotor;
    
    public static RobotDrive robotDrive;
    
    public static Encoder breachArmEncoder;
    
    //DIO slots
    public static int leftTrackSlot = 1;
    public static int rightTrackSlot = 2;
    public static int ballCollectorSlot = 3;
    public static int ballShooterSlot = 4;
    public static int breachArmMotorSlot = 5;
    
    //PWM slots
    public static int breachArmEncoderSlot0 = 1;
    public static int breachArmEncoderSlot1 = 2;
    
    public static void init(){
    	drivetrainLeftTrackMotor = new TalonSRX(leftTrackSlot);
    	LiveWindow.addActuator("Drivetrain", "Left Track", (LiveWindowSendable) drivetrainLeftTrackMotor);
    	
    	drivetrainRightTrackMotor = new TalonSRX(rightTrackSlot);
    	LiveWindow.addActuator("Drivetrain", "Left Track", (LiveWindowSendable) drivetrainRightTrackMotor);
    
    	robotDrive = new RobotDrive(drivetrainLeftTrackMotor, drivetrainRightTrackMotor);
    	
    	robotDrive.setSafetyEnabled(false);
    	robotDrive.setExpiration(.1);
    	robotDrive.setSensitivity(.5);
    	robotDrive.setMaxOutput(1.0);
    
    	ballCollectorMotor = new TalonSRX(ballCollectorSlot);
    	LiveWindow.addActuator("Ball Collector", "Collector", (LiveWindowSendable) ballCollectorMotor);
    
    	ballShooterMotor = new TalonSRX(ballShooterSlot);
    	LiveWindow.addActuator("Ball Shooter", "Shooter", (LiveWindowSendable) ballShooterMotor);
    
    	breachArmMotor = new TalonSRX(breachArmMotorSlot);
    	LiveWindow.addActuator("Breach Arm", "Arm", (LiveWindowSendable) breachArmMotor);
    	
    	// !!! THESE ENCODER VALEUS NEED TO BE VALIDATED/CHANGED FOR THIS
    	// YEAR'S SPECS !!!
    	breachArmEncoder = new Encoder(breachArmEncoderSlot0, breachArmEncoderSlot1, false, EncodingType.k2X);
    	breachArmEncoder.setMinRate(.1);
    	breachArmEncoder.setDistancePerPulse(.014);
    	breachArmEncoder.setSamplesToAverage(30);
    	
    }
}

package org.usfirst.frc.team5590.robot.commands.autonomous;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5590.robot.subsystems.*;
import org.usfirst.frc.team5590.robot.Robot;

/**
 *
 */
public class DriveStraightTimed extends Command {
	
	public Drivetrain drivetrain = Robot.drivetrain;
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private double Kp = .05;
	private double speed;
	private double time;

    public DriveStraightTimed(double speed, double time) {
    	this.speed = speed;
    	this.time = time;
        requires(drivetrain);
        gyro = new ADXRS450_Gyro();             
        drivetrain.setExpiration(696.9);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.stop();
    	System.out.println("Driving straight");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double angle = gyro.getAngle(); // get current heading
        drivetrain.spinDrive(-speed, -angle*Kp); // drive towards heading 0
        Timer.delay(0.004);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.stop();
    }
}

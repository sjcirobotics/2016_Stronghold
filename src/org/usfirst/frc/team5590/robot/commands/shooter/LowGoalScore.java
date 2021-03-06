package org.usfirst.frc.team5590.robot.commands.shooter;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.commands.AutoCollect;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowGoalScore extends CommandGroup {
    
    public  LowGoalScore() {
    	requires(Robot.shooter);
        requires(Robot.collector);
        addSequential(new ShooterDeploy());
        addSequential(new AutoShoot());
        Timer.delay(3.0);
        addParallel(new AutoCollect());
        System.out.println("LOW GOAL SCORED!!!!!!!!!!!!!!!!");
    }
}

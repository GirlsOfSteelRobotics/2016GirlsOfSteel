package org.usfirst.frc.team3504.robot.commands.autonomous;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoLowBar extends Command {

	private double inches;
	
    public AutoLowBar(double distance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        inches = distance;
        SmartDashboard.putBoolean("Autonomous is Finished!", false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.resetEncoderDistance();
    	SmartDashboard.putNumber("Autonomous Distance", inches);
    	SmartDashboard.putNumber("Encoder distance initially AutoDriveDistance:", Robot.chassis.getEncoderDistance());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.driveSpeed(-.1);
    	Robot.chassis.printEncoderValues();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.chassis.getEncoderDistance() >= inches;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    	SmartDashboard.putBoolean("Autonomous is Finished!", true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
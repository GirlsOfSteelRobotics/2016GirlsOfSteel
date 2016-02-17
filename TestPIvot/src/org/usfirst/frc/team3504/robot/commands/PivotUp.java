
package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3504.robot.Robot;

/**
 *
 */
public class PivotUp extends Command {

    public PivotUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pivot);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pivot.setTalon(0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pivot.setTalon(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
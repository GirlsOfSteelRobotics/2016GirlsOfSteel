package org.usfirst.frc.team3504.robot.commands.autonomous;

import org.usfirst.frc.team3504.robot.commands.NudgeFlapDown;
import org.usfirst.frc.team3504.robot.commands.NudgeFlapUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLowBarAndScore extends CommandGroup {
    
    public  AutoLowBarAndScore() {
    	addSequential(new NudgeFlapDown());
    	addSequential(new AutoDriveBackwards(186, .6));
    	addSequential(new NudgeFlapUp()); 
    	addSequential(new AutoTurn(21, 0.3));
    	addSequential(new AutoDriveForward(140, .6));
    	addSequential(new AutoPivotDown(0.5));
    	addSequential(new AutoReleaseBall(2.0));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

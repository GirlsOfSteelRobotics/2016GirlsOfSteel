package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flap extends Subsystem {

	private CANTalon flapTalon;
	private static final double TOP_POSITION = 0;
	private static final double BOTTOM_POSITION = .3; 
	private static final double MIDDLE_POSITION = .15; 
	private static final int INCREMENT = 100;


	public Flap(){
		flapTalon = new CANTalon(RobotMap.FLAP_MOTOR);
		flapTalon.ConfigFwdLimitSwitchNormallyOpen(false);
		flapTalon.ConfigRevLimitSwitchNormallyOpen(false);
		flapTalon.enableBrakeMode(true);

		flapTalon.setEncPosition(0);
		flapTalon.setProfile(0);
		flapTalon.setF(0.0);
		flapTalon.setP(0.5);
		flapTalon.setI(0.0); 
		flapTalon.setD(0.0);

		flapTalon.changeControlMode(CANTalon.TalonControlMode.Position);
		flapTalon.set(0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public void incrementGoal(boolean up){
		if(up)
			flapTalon.set((flapTalon.getEncPosition() + INCREMENT) / 1024); 
		else
			flapTalon.set((flapTalon.getEncPosition() - INCREMENT) / 1024);
	}
	
	public void flapToTop(){
		flapTalon.set(TOP_POSITION);
	}

	public void flapToBottom(){
		flapTalon.set(BOTTOM_POSITION);
	}

	public void flapToMiddle(){
		flapTalon.set(MIDDLE_POSITION);
	}

	public void stop(){
		flapTalon.set(flapTalon.getEncPosition() / 1024); 
	}


	//assuming that going forward will raise the flap and going backwards will lower the flap
	public boolean getTopLimitSwitch(){
		return flapTalon.isFwdLimitSwitchClosed();
	}
	public boolean getBottomLimitSwitch(){
		return flapTalon.isRevLimitSwitchClosed();
	}

	public double getFlapEncoder() {
		return flapTalon.getEncPosition();
	}
}

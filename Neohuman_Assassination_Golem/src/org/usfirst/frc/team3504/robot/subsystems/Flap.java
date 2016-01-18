package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flap extends Subsystem {
    
	private CANTalon flapTalon;
	private CANTalon flapTalon2;

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	 public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	 }
	
	 public Flap(){
		 flapTalon = new CANTalon(RobotMap.FLAP_A);
		 flapTalon2 = new CANTalon(RobotMap.FLAP_B);
		 
		 //We think a second talon is a slave... but we aren't sure
		 flapTalon2.changeControlMode(CANTalon.TalonControlMode.Follower);
		 flapTalon2.set(flapTalon.getDeviceID());
	 }
	public void setTalon(double speed){
		flapTalon.set(speed);
	}
	
	public void stopTalon(){
		flapTalon.set(0.0);
	}
	
	//assuming that going forward will raise the flap and going backwards will lower the flap
	public boolean getTopLimitSwitch(){
		return flapTalon.isFwdLimitSwitchClosed();
	}
	public boolean getBottomLimitSwitch(){
		return flapTalon.isRevLimitSwitchClosed();
	}
	
	

   
}

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
	private static final double maxEncoder = 360; //max encoder val
	private static final double TOP_POSITION = 0;
	private static final double BOTTOM_POSITION = .3; 
	private static final double MIDDLE_POSITION = .15; 


	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private double encOffsetValue = 0;



	public Flap(){
		flapTalon = new CANTalon(RobotMap.FLAP_MOTOR);
		flapTalon.ConfigFwdLimitSwitchNormallyOpen(false);
		flapTalon.ConfigRevLimitSwitchNormallyOpen(false);
		flapTalon.enableBrakeMode(true);

		flapTalon.setEncPosition(0);
		flapTalon.setProfile(0);
		flapTalon.setF(0.0);
		flapTalon.setP(8.0);
		flapTalon.setI(0.003); 
		flapTalon.setD(0.08);

		flapTalon.changeControlMode(CANTalon.TalonControlMode.Position);
		flapTalon.set(0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}

	public void flapUp(){
		flapTalon.setEncPosition((int) (TOP_POSITION * 360));
	}

	public void flapDown(){
		flapTalon.setEncPosition((int) (BOTTOM_POSITION * 360));
	}

	public void flapMiddle(){
		flapTalon.setEncPosition((int) (MIDDLE_POSITION * 360));
	}

	public void flapManual(double speed){
		flapTalon.set(speed);
	}

	public void setTalon(double speed){
		flapTalon.set(speed);
	}

	public void stopTalon(){
		flapTalon.set(0.0);
	}

	public double getThrottle() {
		return Robot.oi.getOperatorStickThrottle();
	}

	public double getMaxEnc() {
		return maxEncoder;
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

	public double getFlapEncoderDistance() {
		return (getFlapEncoder() - encOffsetValue); //TODO: know how far encoder is
	}

	public void resetDistance() {
		encOffsetValue = getFlapEncoder();
	}
}

package org.usfirst.frc.team4587.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import utility.Gyro;

/**
 *
 */
public class Auto1678 extends CommandGroup {

    public Auto1678(String side) {
    	boolean blue;
    	if(side.equals("blue")){
    		blue = true;
    	}else{
    		blue = false;
    	}
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
    	//addSequential(new AutonomousDriveStraightDistance(100, 0.55));
    	if(blue){
        	addSequential(new FollowChezyPath("1678Path0",true,false,-1,0));
        	addSequential(new BallIntakeDown());
        	addSequential(new EjectGear());
        	addSequential(new FollowChezyPath("1678Path1",true,false,-1,0));
        	addSequential(new AimAndShoot());
        	//addSequential(new Shoot());
        	//addSequential(new BallIntakeOn());
        	addSequential(new Delay(150));
        	addSequential(new ShooterOff());
        	addSequential(new AutonomousTurnSimple(-90));
        	addSequential(new FollowChezyPath("1678Path2",true,false,-1,Gyro.getYaw()));
    	}else{
        	addSequential(new FollowChezyPath("1678Path0",true,true,1,0));
        	addSequential(new BallIntakeDown());
        	addSequential(new EjectGear());
        	addSequential(new FollowChezyPath("1678Path1",true,true,1,0));
        	addSequential(new AimAndShoot());
        	//addSequential(new Shoot());
        	//addSequential(new BallIntakeOn());
        	addSequential(new Delay(150));
        	addSequential(new ShooterOff());
        	addSequential(new AutonomousTurnSimple(90));
        	addSequential(new FollowChezyPath("1678Path2",true,true,1,Gyro.getYaw()));
    	}
    	//addSequential(new Delay(10));
    	//addSequential(new HopperOut());
    	//addSequential(new AutonomousTurnSimple(15));
    	/*addSequential(new Delay(25));
    	addSequential(new ToggleGearIntakeMotors());
    	addSequential(new FollowChezyPath(1));*/
    }
}

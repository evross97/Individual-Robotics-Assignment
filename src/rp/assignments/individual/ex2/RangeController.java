package rp.assignments.individual.ex2;

import javax.swing.plaf.synth.SynthSeparatorUI;

import lejos.robotics.RangeFinder;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;
import rp.util.Rate;

public class RangeController implements StoppableRunnable {
	
	private final DifferentialDriveRobot robo;
	private final RangeFinderDescription desc;
	private final RangeFinder ranger;
	private final float maxD;
	private final float k = 0.3f;
	private double speed;
	private boolean moving = true;

	public RangeController( DifferentialDriveRobot _robot, RangeFinderDescription _desc, 
			RangeFinder _ranger, Float _maxDistance)
	{
		this.robo = _robot;
		this.desc = _desc;
		this.ranger = _ranger;
		this.maxD = _maxDistance - 0.2f;

	}

	@Override
	public void run() 
	{
		Rate r = new Rate((1000/desc.getRate())*2);
		while(moving)
		{
			robo.getDifferentialPilot().forward();
			float range = ranger.getRange();
			float ran = range - maxD;
			speed = robo.getDifferentialPilot().getTravelSpeed() + (ran + desc.getNoise())*k;
			if ((range + desc.getNoise()) < maxD)
			{
				robo.getDifferentialPilot().stop();
				robo.getDifferentialPilot().setTravelSpeed(0);
			}
			else if ((range + desc.getNoise()) > maxD)
			{
				if(speed < robo.getDifferentialPilot().getMaxTravelSpeed())
				{
					robo.getDifferentialPilot().setTravelSpeed(speed);
				}
				else
				{
					robo.getDifferentialPilot().setTravelSpeed(0.4);
				}
				
			}
			
			r.sleep();
			
			
		}
	}

	@Override
	public void stop() 
	{
		moving = false;
		robo.getDifferentialPilot().stop();
	}

}

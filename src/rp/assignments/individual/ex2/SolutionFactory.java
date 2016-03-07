package rp.assignments.individual.ex2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import lejos.robotics.RangeFinder;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

public class SolutionFactory {

	public static StoppableRunnable createRangeController( DifferentialDriveRobot _robot, RangeFinderDescription _desc, 
															RangeFinder _ranger, Float _maxDistance)
	{
		return new RangeController(_robot, _desc, _ranger, _maxDistance);
	}
	
	public static void main(String[] args)
	{
		Result result = JUnitCore
                .runClasses(rp.assignments.individual.ex2.Ex2Tests.class);

        System.out.println(String.format("%d/%d tests successful",
                result.getRunCount() - result.getFailureCount(),
                result.getRunCount()));
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
	}

}

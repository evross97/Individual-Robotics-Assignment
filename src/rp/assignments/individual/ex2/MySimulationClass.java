package rp.assignments.individual.ex2;

import rp.robotics.testing.RobotTest;

import rp.robotics.testing.TestViewer;

public class MySimulationClass {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Ex2Tests tests = new Ex2Tests();
         RobotTest<?> test = tests.createSlowTest();
         //RobotTest<?> test = tests.createMediumToFastTest();
        //RobotTest<?> test = tests.createMediumTest();
        //RobotTest<?> test = tests.createFastTest();
        TestViewer demo = new TestViewer(test, test.getSimulation());
        demo.run(); 
	}

}

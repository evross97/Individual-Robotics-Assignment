package rp.assignments.individual.ex2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SolutionFactoryTest {

	@Test
	public void testCreateRangeController() {
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

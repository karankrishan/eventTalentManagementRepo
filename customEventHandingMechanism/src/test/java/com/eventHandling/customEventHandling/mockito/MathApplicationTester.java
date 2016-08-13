package com.eventHandling.customEventHandling.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	@InjectMocks
	MathApplication application = new MathApplication();

	@Mock
	CalculatorrService calcService;

	@Test
	public void testAdd() {
		when(calcService.add(10.0, 20.0)).thenReturn(30.00);
		Assert.assertEquals(application.add(10.0, 20.0), 30.0, 0);
	}

}

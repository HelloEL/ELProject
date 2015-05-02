package crisisAndEvent;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoaderControllerTest {

	@Test
	public void testLoadCrisisAndEvent() {
		LoaderController loaderController = new LoaderController();
		assertEquals(false,(new LoaderController()).loadCrisisAndEvent());
	}

}

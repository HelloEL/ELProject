package crisisAndEvent;

import static org.junit.Assert.*;

import org.junit.Test;

import crisisAndEvent.loader.LoaderController;

public class LoaderControllerTest {

	@Test
	public void testLoadCrisisAndEvent() {
		LoaderController loaderController = new LoaderController();
		assertEquals(false,(new LoaderController()).loadCrisisAndEvent());
	}

}

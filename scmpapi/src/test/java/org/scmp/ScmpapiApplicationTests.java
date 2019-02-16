package org.scmp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.scmp.controller.ScmpController;
import org.scmp.service.MyThread;
import org.scmp.service.ScmpService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScmpapiApplicationTests {


	@InjectMocks
	ScmpController scmpController;
	
	@Mock
	ScmpService  scmpService;
	
	@Test
	public void loadMap() {
		{ 
			 for (Long i=(long) 0; i<100; i++) 
		        {
					MyThread object = new MyThread(i+1); 
		            object.start(); 
		        }
        } 
	}
}


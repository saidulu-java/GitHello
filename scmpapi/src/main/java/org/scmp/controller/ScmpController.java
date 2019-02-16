package org.scmp.controller;

import org.scmp.service.ScmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ScmpController {
	
	@Autowired
	ScmpService scmpService;
	
	
	@GetMapping("/version/{scmpNumber}")
	public  Long  getScmpVersion(@PathVariable String scmpNumber) {
		scmpService.loadMap();
		Long versionNumber=scmpService.getScmpVersion(scmpNumber);
		return versionNumber;
		
	}
	
	
	@PutMapping("/version/{scmpNumber}/{versionNumber}")
	public boolean verifyScmpVersion(@PathVariable String scmpNumber, @PathVariable Long versionNumber) {
		
		Long exstingVersion =null;
		boolean flag= false;
	//	scmpService.loadMap();
		exstingVersion=scmpService.getScmpVersion(scmpNumber);
		if(exstingVersion==null) {
			return false;
		}
		
       else if(exstingVersion!=null && exstingVersion.equals(versionNumber)) {
			scmpService.addVersionNumber(scmpNumber, versionNumber);
			flag =true;
 		}else if(exstingVersion < versionNumber) {
			scmpService.updateVersionNumber(scmpNumber, versionNumber);
			flag = true;
		}
		
		
		
		
		return flag;
		
	}

}

package com.acontroller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bservice.IdeleteService;
import com.domain.User;
import com.proxy.ReaderProxy;

@RestController
@PropertySource("classpath:messages.properties") /* place the properties file under src/main/resources */
public class DeleteController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private IdeleteService deleteService;

    @Autowired
    private ReaderProxy readerProxy;
	
	@PostMapping("/delete")
	public List<User> deleteById(@RequestBody User user) {

		deleteService.deleteUserById(user);
		
		//String uploadRoot = System.getProperty("catalina.base");
		String uploadRoot = "C:" + File.separator + "_local_git_repository";
		String uploadLocation = uploadRoot + File.separator + env.getProperty("img_path") + File.separator + env.getProperty("img_folder") + File.separator;
		String file = uploadRoot + File.separator + env.getProperty("img_path") + File.separator + env.getProperty("img_folder") + File.separator + user.getUserId() +".jpg";

	    File myObj = new File(file); 
	    if (myObj.delete()) { 
	      System.out.println("Deleted the file: " + myObj.getName());
	    } else {
	      System.out.println("Failed to delete the file.");
	    } 		
		
		List<User> userList = readerProxy.read();

		return userList;

	}

}





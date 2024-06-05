package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Model.User;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	RestTemplate rs;
	
	//From admin---------------------------------------------------------------------------
	
	@PostMapping("/admin/profile/{username}")
	
	//public void 
	
//	@PostMapping("/register")
//    public String register(@RequestBody User user) {
//		
//        
//    }
//from AccountManager-------------------------------------------------------------------------------
	
	@GetMapping("/checkBalance/{username}")
    public double checkBalance(@PathVariable String username) {
        double customerResponse=rs.getForObject("http://localhost:8899/api/checkBalance/"+username, Double.class);
        return customerResponse;
	}
	
//	 @GetMapping("/profile/{username}")
//	 public User getProfile(@PathVariable String username) {
//		 rs.getForObject("http://localhost:8899/api/profile/"+username, String.class);
//		 return 
//	 }
	
	@PostMapping("/register")
	public void register(@RequestBody User user) {
		rs.postForLocation("http://localhost:8899/api/register/"+user, User.class);
	}
//	
	
	 @PutMapping("/withdraw/{username}/{amount}")
    public void  withdraw(@PathVariable String username,@PathVariable double amount) {
       rs.put("http://localhost:8899/api/withdraw/"+username+"/"+amount, String.class);
	    
	 }
	 
	 @PutMapping("/deposit/{username}/{amount}")
	 public void deposit(@PathVariable String username,@PathVariable double amount) {
		 rs.put("http://localhost:8899/api/deposit/"+username+"/"+amount, String.class);
	 }
	 
	 
}

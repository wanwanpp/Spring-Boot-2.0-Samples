package com.bee.sample.ch3.controller;

import com.bee.sample.ch3.entity.User;
import com.bee.sample.ch3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * mvc url映射测试
 * @author lijiazhi
 *
 */
@Controller
@RequestMapping("/urlmapper")
public class URLMapperController {
	
	@Autowired UserService userService;

	@RequestMapping(path="/user/all/*.json" ,method = RequestMethod.GET)
	@ResponseBody
	public   List<User> allUser() {
        return userService.allUser();
    }

	@RequestMapping(path="/user/{id}.json" ,method = RequestMethod.GET)
	@ResponseBody
	public   User getById( @PathVariable Long id) {
        return userService.getUserById(id);
    }
	
	@GetMapping(path = "/{userId}.json", produces = "application/json")
	@ResponseBody
	public   User getUserById( @PathVariable Long userId) {
        return userService.getUserById(userId);
    }
	
	@GetMapping(value="/consumes/test.json",consumes = "application/json" )
	@ResponseBody
	public   User forJson() {
	  return userService.getUserById(1L);
	}

    /**
     * 从配置中读取random的值
     * @return
     */
	@GetMapping("/${random}.json")
	@ResponseBody
	public String getProperties(){
		return "hahaha";
	}

}

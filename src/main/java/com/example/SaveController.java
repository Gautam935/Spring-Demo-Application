package com.example;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;

@RestController
public class SaveController {
	
	@Autowired
	TestRepo repo;

	@POST
	@RequestMapping("Save/{name}/{qty}/{price}")
	@ApiOperation(value = "post a product")
	public String getMsg(@PathVariable("name") String nameVal,@PathVariable("qty") Integer quantity,@PathVariable("price") Integer cost) {
		Details detail = new Details();
		detail.setProductName(nameVal);
		detail.setProductQty(quantity);
		detail.setProductPrice(cost);
		repo.save(detail);
		return nameVal + " Records are inserted successfully";
	}
	

}

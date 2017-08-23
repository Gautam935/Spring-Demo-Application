package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@SpringBootApplication
public class TestCont {

	private static Log log= LogFactory.getLog(TestCont.class);
	@Autowired
	TestRepo repo;

	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	protected ResponseEntity<Response> addProduct(@RequestBody Details form) {

		log.info("Inside addProduct");
		Response response = new Response();

		Map<String, String> head = new HashMap<String, String>();
		Map<String, Object> body = new HashMap<String, Object>();

		Details detail = new Details();
		detail.setProductName(form.getProductName());
		detail.setProductQty(form.getProductQty());
		detail.setProductPrice(form.getProductPrice());
		repo.save(detail);
		log.info("Records are inserted successfully");

		head.put("status", "AddProduct");
		body.put("Details", detail);
		response.setHead(head);
		response.setBody(body);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	/*@POST
	@RequestMapping("add/{name}/{qty}/{price}")
	@ApiOperation(value = "post a product")
	public String getMsg(@PathVariable("name") String nameVal, @PathVariable("qty") Integer quantity,
			@PathVariable("price") Integer cost) {
		Details detail = new Details();
		detail.setProductName(nameVal);
		detail.setProductQty(quantity);
		detail.setProductPrice(cost);
		repo.save(detail);
		log.info("Records are inserted successfully");
		return nameVal + " Records are inserted successfully";
	}
*/
	@GET
	@Produces("application/json")
	@RequestMapping("search/{product name}")
	@ApiOperation(value = "post a product2")
	public Details searchNamesforlist(@PathVariable("product name") String product) {
		log.info("controller add name yes===============" + product);
		//System.out.println("controller add name yes===============" + product);
		Details list = repo.findProductDetailsByProductName(product);
		return list;
	}

	@GET
	@Produces("application/json")
	@RequestMapping("search/all product")
	@ApiOperation(value = "post all product")
	public List<Details> searchAllProduct() {
		log.info("inside all search product===============");
		//System.out.println("inside all search product===============");

		List<Details> list = (List<Details>) repo.findAll();
		// testing.add(nameVal);
		return list;
	}
}

package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestCont.class)
@WebAppConfiguration
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).defaultRequest(post("/")).build();

	}

	/*@Test
	public void addNewProduct() {

		try {
			System.out.println("inside try============");
			if (this.mockMvc == null) {
				System.out.println("====first null=====");
			}
			this.mockMvc
					.perform(post("/add/MotoG/1/15000")
							.contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
*/
	@Test
	public void getAllProduct() {

		try {
			System.out.println("inside try============");
			if (this.mockMvc == null) {
				System.out.println("====first null=====");
			}
			this.mockMvc
					.perform(get("/search/all product")
							.contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Test
	public void getAllProductByName() {

		try {
			System.out.println("inside try============");
			if (this.mockMvc == null) {
				System.out.println("====first null=====");
			}
			this.mockMvc
					.perform(get("/search/MotoG")
							.contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}

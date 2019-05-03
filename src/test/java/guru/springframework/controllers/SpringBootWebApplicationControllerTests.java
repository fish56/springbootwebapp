package guru.springframework.controllers;

import guru.springframework.SpringBootWebApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationControllerTests {
	@Autowired
	private WebApplicationContext wac;

	protected MockMvc mockMvc;

	// 初始化mockMvc供子类继承
	@Before
	public void setMockMvc(){
		mockMvc = MockMvcBuilders
				.webAppContextSetup(wac).build();
	}

	@Test
	public void isMockMvcOk(){
		Assert.assertNotNull(mockMvc);
	}
}

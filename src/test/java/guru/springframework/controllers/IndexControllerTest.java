package guru.springframework.controllers;

import guru.springframework.SpringBootWebApplicationTests;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

public class IndexControllerTest extends SpringBootWebApplicationControllerTests {

    @Test
    public void index() throws Exception{

        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");

        mockMvc.perform(builder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(ok);
    }
}
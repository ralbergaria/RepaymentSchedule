package com.rafaelalbergaria.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.text.SimpleDateFormat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafaelalbergaria.model.Plan;
/**
 * Test Restfull
 * @author Rafael
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RepaymentScheduleRestTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired 
	private ObjectMapper mapper;
	
	@Test
	public void getGeneratePlan()
	  throws Exception {
	     
	    Plan plan = new Plan(5000.00, 5.0F, 24, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2018"));	    
	    String json = mapper.writeValueAsString(plan);
	    
	    mvc.perform(MockMvcRequestBuilders.post("/generate-plan")
	      .contentType(MediaType.APPLICATION_JSON)
	      .content(json))
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(jsonPath("$[0].remainingOutstandingPrincipal",  CoreMatchers.is(4801.47)))
	      .andExpect(jsonPath("$[1].borrowerPaymentAmount", CoreMatchers.is(219.36)))
	      .andExpect(jsonPath("$[23].initialOutstandingPrincipal", CoreMatchers.is(218.44)));
	}
	
}

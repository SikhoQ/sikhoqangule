package com.enviro.assessment.grad001.sikhoqangule;

import com.enviro.assessment.grad001.sikhoqangule.model.WasteCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WasteSortingApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAllCategories() {
		ResponseEntity<WasteCategory[]> response = restTemplate.getForEntity("/api/categories", WasteCategory[].class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}
}
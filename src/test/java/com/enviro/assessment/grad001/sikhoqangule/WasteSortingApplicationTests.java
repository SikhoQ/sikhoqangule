package com.enviro.assessment.grad001.sikhoqangule;

import com.enviro.assessment.grad001.sikhoqangule.entity.WasteCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

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

	@Test
	public void testCreateCategory() {
		WasteCategory newCategory = new WasteCategory("Metal", "Metal waste such as cans");
		ResponseEntity<WasteCategory> response = restTemplate.postForEntity("/api/categories", newCategory, WasteCategory.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo("Metal");
	}

	@Test
	public void testGetCategoryById() {
		WasteCategory newCategory = new WasteCategory("Paper", "Normal paper");
		ResponseEntity<WasteCategory> created = restTemplate.postForEntity("/api/categories", newCategory, WasteCategory.class);
		Long createdId = Objects.requireNonNull(created.getBody()).getId();

		ResponseEntity<WasteCategory> response = restTemplate.getForEntity("/api/categories/" + createdId, WasteCategory.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}


	@Test
	public void testDeleteCategory() {
		restTemplate.delete("/api/categories/1");
		ResponseEntity<WasteCategory> response = restTemplate.getForEntity("/api/categories/1", WasteCategory.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}
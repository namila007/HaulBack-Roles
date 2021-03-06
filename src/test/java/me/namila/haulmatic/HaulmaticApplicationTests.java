package me.namila.haulmatic;

import me.namila.haulmatic.controllers.RoleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static me.namila.haulmatic.constants.statics.ApiEndPoints.BASE_END_POINT;
import static me.namila.haulmatic.constants.statics.ApiEndPoints.STATUS_END_POINT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class HaulmaticApplicationTests {

	private final static String STATUS_URL = BASE_END_POINT + STATUS_END_POINT;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RoleController roleController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(roleController).isNotNull();
	}

	@Test
	public void statusShouldReturnOK() throws Exception {
		this.mockMvc.perform(get(STATUS_URL)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("OK")));
	}

}

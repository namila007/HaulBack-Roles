package me.namila.haulmatic.unit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static me.namila.haulmatic.constants.statics.ApiEndPoints.BASE_END_POINT;
import static me.namila.haulmatic.constants.statics.ApiEndPoints.STATUS_END_POINT;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BaseControllerTest {
    private final static String END_POINT = BASE_END_POINT + STATUS_END_POINT;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void statusShouldReturnOK() throws Exception {
        this.mockMvc.perform(get(END_POINT)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")));
    }
}

package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void pi_returnsPI() throws Exception {
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void volume_returnsVolume() throws Exception {
        this.mvc.perform(get("/math/volume/3/3/3").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x3x3 rectangle is 27"));
    }
}

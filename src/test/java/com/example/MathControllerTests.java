package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;

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
        this.mvc.perform(get("/math/volume/3/3/3")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x3x3 rectangle is 27"));
    }

    @Test
    public void testCircleArea() throws Exception {

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", Double.toString(4));

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(String.format("Area of a circle with a radius of 4 is 50.26548")));
    }

    @Test
    public void testRectangleArea() throws Exception {
        this.mvc.perform(post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("height", "2")
                .param("width", "3")
                .param("type","rectangle"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Area of a 2x3 rectangle is 6")));
    }

    @Test
    public void testInvalidArea() throws Exception {
        this.mvc.perform(post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("radius", Double.toString(2))
                .param("type","fdgfg"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));
    }
}

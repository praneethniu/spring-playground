package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    @GetMapping("/pi")
    public String pi() {
        return String.valueOf(Math.PI);
    }

    @RequestMapping("/volume/{length}/{width}/{height}")
    public String getVolume(@PathVariable("length") int length,
                            @PathVariable("width") int width,
                            @PathVariable("height") int height)
    {
        return String.format("The volume of a %dx%dx%d rectangle is %d",
                length, width, height,length*width*height);
    }
}

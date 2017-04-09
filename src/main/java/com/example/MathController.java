package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static java.lang.Math.PI;

@RestController
@RequestMapping("/math")
public class MathController {
    @GetMapping("/pi")
    public String pi() {
        return String.valueOf(PI);
    }

    @RequestMapping("/volume/{length}/{width}/{height}")
    public String getVolume(@PathVariable("length") int length,
                            @PathVariable("width") int width,
                            @PathVariable("height") int height)
    {
        return String.format("The volume of a %dx%dx%d rectangle is %d",
                length, width, height,length*width*height);
    }

    @PostMapping(value = "/area", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String areaFromParams(@RequestParam String type,
                                        @RequestParam(required = false) BigDecimal radius,
                                        @RequestParam(required = false) BigDecimal width,
                                        @RequestParam(required = false) BigDecimal height) {

        if(type == null) {
            return "Invalid";
        }

        switch (type.toLowerCase()) {
            case "circle":
                if (radius == null) {
                    return "Invalid";
                }

                BigDecimal circleArea = new BigDecimal(PI * radius.doubleValue() * radius.doubleValue());
                return  String.format("Area of a circle with a radius of %s is %s", radius,
                        circleArea.setScale(5, BigDecimal.ROUND_HALF_EVEN));
            case "rectangle":
                if (width == null || height == null)
                    return "Invalid";
                return String.format("Area of a %sx%s rectangle is %s", height, width,
                        new BigDecimal(width.doubleValue() * height.doubleValue()));
            default:
                return "Invalid";
        }


    }

}

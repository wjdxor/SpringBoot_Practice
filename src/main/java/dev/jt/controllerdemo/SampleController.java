package dev.jt.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 어노테이션 인터페이스
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(
            value = "/hello",
            method = RequestMethod.GET
    )

    public String hello(
            @RequestParam(name = "id", required = false, defaultValue = "") String id
    ){
        logger.info("Path: Hello");
        logger.info("Query Param id: " + id);
        return "/hello.html";
    }

    @GetMapping(
            value = "/hello/{id}"
    )
    public String helloPath(@PathVariable("id") String id){
        logger.info("Path Varialble is : " + id);
        return "/hello.8080";
    }

    @GetMapping(
            "/get-profile"
    )
    public @ResponseBody SamplePayload getProfile(){
        return new SamplePayload("JT",20, "developer");
    }


}


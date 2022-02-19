package dev.jt.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("view")
public class SampleJspController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

//  JSP 실습
    @GetMapping("/sample-jsp")
    public String sampleJsp(Model model){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName();

        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam",22,"Student"));
        profiles.add(new SamplePayload("Bradley",24,"Accountant"));
        profiles.add(new SamplePayload("Charlie",27,"Developer"));

        model.addAttribute("profiles",profiles);
        return "view-jsp";
    }
//  Thyme 실습
    @GetMapping("/sample-thyme")
    public ModelAndView sampleThyme(){
        logger.info("in sample Thyme");

        ModelAndView modelAndView = new ModelAndView();
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam",22,"Student"));
        profiles.add(new SamplePayload("Bradley",24,"Accountant"));
        profiles.add(new SamplePayload("Charlie",27,"Developer"));

        modelAndView.addObject("profiles",profiles);
        modelAndView.setViewName("view-thyme");

        return modelAndView;
    }

}

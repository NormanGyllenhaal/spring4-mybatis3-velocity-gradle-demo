package site.lovecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import site.lovecode.service.UserService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/3/25.
 */
@Controller
public class testController {

    @Resource
    private UserService userService;

    @RequestMapping(value="/test1.htm")
    public ModelAndView test1(Model model){
         model.addAttribute("list",userService.getUser());
        return new ModelAndView("test1");
    }
}

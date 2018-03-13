package com.fizz.spring.part5.web;

import com.fizz.spring.part5.data.SpittleRepository;
import com.fizz.spring.part5.entity.Spittle;
import com.fizz.spring.part5.service.SpittleService;
import com.fizz.spring.part5.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    private SpittleService spittleService;

    //private static SpittleRepository spittleRepository;

   /* @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }*/

    @RequestMapping(method= RequestMethod.GET)
    public String spittles(
            @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
            @RequestParam(value="count", defaultValue="20") int count, Model model) {
        List<Spittle> list = spittleService.findSpittles(max, count);
        model.addAttribute("spittleList", list);
        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        Spittle spittle = spittleService.findOne(spittleId);
        model.addAttribute("spittle", spittle);
        return "spittle";
    }

}

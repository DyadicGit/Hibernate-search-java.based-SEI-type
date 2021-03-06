package org.hanbo.mvc.controller;

import org.hanbo.mvc.entities.Sys_meta_question;
import org.hanbo.mvc.entities.Sys_meta_questionRepoInterface;
import org.hanbo.mvc.entities.Sys_meta_questionService;
import org.hanbo.mvc.helpers.Pasirinkimai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloWorld {
    @Autowired
    private Sys_meta_questionService _repo;

    //used for running the indexing process
    @RequestMapping(value = "/")
    public String welcome(Model mav) throws Exception {
        _repo.indexSys_meta_question();
        mav.addAttribute("message", "Hello World!");
        return "hello";
    }

    // creates a new empty view
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPage(Model model) {
        model.addAttribute("pasirinkimai", new Pasirinkimai());
        return "search";
    }

    //gets the typed search_word and retrieves found items
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model,
            @RequestParam("searchText")
                    String searchText, @ModelAttribute("pasirinkimai")Pasirinkimai pasirinkimai
    ) throws Exception {
        List<Sys_meta_question> allFound = _repo.searchForBook(searchText);
        if (searchText.length() != 0) {
            model.addAttribute("allFound", allFound);
        } else {
            model.addAttribute("arIvede", "ne");
        }
        return "search";
    }

    @ModelAttribute("webParamList")
    public List<String> populateWebParamList() {
        //Data referencing for web framework checkboxes
        return Arrays.asList("valdzios deficitas ir skola_EN(ESA95)", "uzimtumas_EN", "uzsienio kontroliuojamos imones", "valdzios islaidos pagal funkcijas", "ukininkai ir fiziniai asmenys_EN");
    }
    @ModelAttribute("webQuestion_textList")
    public List<String> populateQuestion_textList() {
        //Data referencing for web framework checkboxes
        List<String> question_textList = new ArrayList<String>();
        question_textList.add("Imputation - rate");
        question_textList.add("Model assumption error");
        question_textList.add("Seasonal adjustment");
        question_textList.add("Timeliness and punctuality");
        question_textList.add("Timeliness");
        question_textList.add("Time lag - first results");
        question_textList.add(" Time lag - final results");
        question_textList.add("Punctuality");
        question_textList.add("Punctuality - delivery and publication");
        question_textList.add("Coherence and comparability");
        question_textList.add("Comparability - geographical");
        question_textList.add("Asymmetry for mirror flows statistics - coefficient");

        return question_textList;
    }
}

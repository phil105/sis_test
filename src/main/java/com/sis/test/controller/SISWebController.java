package com.sis.test.controller;

import com.sis.test.model.Competition;
import com.sis.test.model.Owner;
import com.sis.test.model.Team;
import com.sis.test.service.CompetitionService;
import com.sis.test.service.OwnerService;
import com.sis.test.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SISWebController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired private TeamService teamService;
    @Autowired private OwnerService ownerService;
    @Autowired private CompetitionService competitionService;

    @RequestMapping(value = {"/", "/index" }, method = RequestMethod.GET, headers = "Accept=*")
    public String index(Model model) {
        log.debug("SISWebController.index() - Started");
        Team team = new Team();
        team.setId((new Random()).nextLong());
        model.addAttribute("teamFormModel", team);
        log.debug("SISWebController.index() - Ended");
        return "teamForm";
    }

    @RequestMapping(value = {"/error" }, method = RequestMethod.POST, headers = "Accept=*")
    public String error() {
        log.debug("SISWebController.error() - Started");
        log.debug("SISWebController.error() - Ended");
        return "errorPage";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "owners", new CustomCollectionEditor(List.class) {

            protected Object convertElement(Object element) {
                if(element instanceof String && (String)element != "NONE") {
                    int indexId = Integer.parseInt(element.toString());
                    Long longId = Long.valueOf(new Integer(indexId).longValue());
                    return ownerService.getOwner(longId);
                }
                return null;
            }

        });
        binder.registerCustomEditor(List.class, "competitions", new CustomCollectionEditor(List.class) {

            protected Object convertElement(Object element) {
                if(element instanceof String && (String)element != "NONE") {
                    int indexId = Integer.parseInt(element.toString());
                    Long longId = Long.valueOf(new Integer(indexId).longValue());
                    return competitionService.getCompetition(longId);
                }
                return null;
            }

        });
    }

    @RequestMapping(value = "/addTeam", method = RequestMethod.POST, headers = "Accept=*")
    public String addTeam(@ModelAttribute("teamFormModel") @Validated Team team,
                          BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        log.debug("SISWebController.addTeam() - Started");

        if (result.hasErrors()) {
            return "teamForm";
        } else {

            log.debug("SISWebController.addTeam() - add new team to database.");
            teamService.getTeams().add(team);

            log.debug("SISWebController.addTeam() - Ended");
            return "submitted";
        }
    }

    @ModelAttribute("ownerList")
    public List<Owner> ownerList() {
        log.debug("SISWebController.ownerList() - Started");
        return ownerService.getOwners();
    }

    @ModelAttribute("competitionList")
    public List<Competition> competitionList() {
        log.debug("SISWebController.competitionList() - Started");
        return competitionService.getCompetitions();
    }

}

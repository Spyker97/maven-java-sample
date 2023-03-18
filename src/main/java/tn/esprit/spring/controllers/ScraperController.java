package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Insurance;
import tn.esprit.spring.entities.MaisonVacance;
import tn.esprit.spring.entities.ResponseDTO;
import tn.esprit.spring.repository.MaisonVacanceRepository;
import tn.esprit.spring.service.ScraperServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = "api/user/client/Scrapping")
public class ScraperController {

    @Autowired
    ScraperServiceImpl scraperService;

    @Autowired
    MaisonVacanceRepository maisonVacanceRepository;
    @PostMapping(path = "/")
    @ResponseBody
    public Set<ResponseDTO> getPopulatioByRegion() {
        ResponseDTO responseDTO = new ResponseDTO();
        return  scraperService.getPopulatioByRegion(responseDTO);
    }

    @GetMapping(path = "/averageHouseByZone/{region}")

    public Map<String,Double> averageHouseByZone(@PathVariable String region){
        return scraperService.calculeDistance(region);
    }
    @PostMapping(path = "/getMaisonVacance")
    @ResponseBody
    public List<MaisonVacance> getMaisonVacance () throws IOException {
            MaisonVacance maisonVacance = new MaisonVacance();
        scraperService.scrapeMaisonVacances();
        return maisonVacanceRepository.findAll();
    }
}
package fr.clarisse.citations_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/citations")
public class CitationController {

    @Autowired
    private CitationService citationService;

    @GetMapping
    public List<Citation> GetAll(){
        return citationService.findAll();
    }

    @PostMapping
    public Citation create(@RequestBody Citation citation){
        return citationService.save(citation);
    }
    
}

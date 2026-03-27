package fr.clarisse.citations_api;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CitationService {

    private CitationRepository citationRepository;

    public CitationService(CitationRepository citationRepository) {
        this.citationRepository = citationRepository;
    }

    public List<Citation> findAll(){
        return citationRepository.findAll();
    }

    public Citation save(Citation citation) {
        return citationRepository.save(citation);
    }
    
}

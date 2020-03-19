package org.wirvsvirushackathon.projekt1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wirvsvirushackathon.projekt1.exception.ResourceNotFoundException;
import org.wirvsvirushackathon.projekt1.persistence.model.Capital;
import org.wirvsvirushackathon.projekt1.persistence.repository.CapitalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CapitalService {

//    @Autowired or a constructor would be necessary
//    with lombok @RequiredArgsConstructor constructor is created auto and therefore no autowired necessary
    private final CapitalRepository capitalRepository;

    public Capital create(Capital capital) {
        return capitalRepository.save(capital);
    }

    public void delete(Capital capital) {
        capitalRepository.delete(capital);
    }

    public Capital getByCountry(String country) {
        // throw exception with closure prefixed, because THIS supplier wants sth. like a method which returns an exception
        // for default return use: .orElse(new Capital());
        // lombok accessorChaining: .orElse(new Capital().setName("asd").setCountry("asd"));
        // necessary!!!: lombok.accessors.chain=true in lombok.config
        return capitalRepository.findByCountry(country).orElseThrow(()-> new ResourceNotFoundException("capital", "country", country));
    }

    public Capital getById(Long id) {
        return capitalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("capital", "id", id));
    }

    public List<Capital> getAll() {
        return capitalRepository.findAll();
    }
}

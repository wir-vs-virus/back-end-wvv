package org.wirvsvirushackathon.projekt1.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.wirvsvirushackathon.projekt1.persistence.model.Capital;
import org.wirvsvirushackathon.projekt1.service.CapitalService;
import org.wirvsvirushackathon.projekt1.web.model.CapitalModel;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/capitals")
@RequiredArgsConstructor
public class CapitalController {
    private final CapitalService capitalService; // final is a must because then it IS required

    @GetMapping("/{id}")
    public ResponseEntity<?> getCapitalById(@PathVariable Long id) {
        CapitalModel capitalModel = CapitalModel.of(capitalService.getById(id));
        return ResponseEntity.ok()
                .body(capitalModel);
    }

    @GetMapping()
    public ResponseEntity<?> getCapitalFromCountry(@RequestParam(name = "country", required = false) String country) { // country has to be the name of the query key in the get call
        if (!StringUtils.isEmpty(country)) {
            return ResponseEntity.ok(CapitalModel.of(capitalService.getByCountry(country)));
        }

        //.stream().map() manipulates every element with the given method
        // alternative: (capital) -> CapitalModel.of(capital)
        return ResponseEntity.ok(capitalService.getAll()
                .stream()
                .map(CapitalModel::of)
                .collect(Collectors.toList()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> addCapital(@Valid @RequestBody CapitalModel capitalModel) {
        Capital capital = capitalService.create(Capital.of(capitalModel));

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/")
                .buildAndExpand(capital.getId()).toUri();

        return ResponseEntity.created(location) // here the URI used for find by id
                .body(CapitalModel.of(capital));
    }
}

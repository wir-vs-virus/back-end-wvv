package org.wirvsvirushackathon.projekt1.web.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.wirvsvirushackathon.projekt1.persistence.model.Capital;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
@Builder
public class CapitalModel {
    @NotBlank
    private String name;

    @NotBlank
    private String country;

    public static CapitalModel of(Capital capital) {
        return CapitalModel
                .builder()
                .country(capital.getCountry())
                .name(capital.getName())
                .build();
    }
}

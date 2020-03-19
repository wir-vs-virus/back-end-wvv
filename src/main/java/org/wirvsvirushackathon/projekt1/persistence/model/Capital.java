package org.wirvsvirushackathon.projekt1.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.wirvsvirushackathon.projekt1.web.model.CapitalModel;

import javax.persistence.*;

@Entity
@Table(name = "capitals", uniqueConstraints = {@UniqueConstraint(columnNames = "country")})
@Data
//@Builder(access = AccessLevel.PRIVATE)
public class Capital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String name;

    public static Capital of(CapitalModel capitalModel) {
        Capital capital = new Capital();
        capital.setCountry(capitalModel.getCountry());
        capital.setName(capitalModel.getName());
        return capital;
    }
}

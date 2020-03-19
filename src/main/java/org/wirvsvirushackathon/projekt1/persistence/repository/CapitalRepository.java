package org.wirvsvirushackathon.projekt1.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wirvsvirushackathon.projekt1.persistence.model.Capital;

import java.util.Optional;

public interface CapitalRepository extends JpaRepository<Capital, Long> {
    // get by id, findAll and safe implemented

    // write method by 'some' rules and query will be generated automatically. e.g.
    Optional<Capital> findByCountry(String country);
}

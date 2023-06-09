package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Examen;
import tn.esprit.spring.entities.Offer;


@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {


}

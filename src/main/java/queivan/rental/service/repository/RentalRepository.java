package queivan.rental.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import queivan.rental.domain.Rental;

import java.util.UUID;

@Repository
public interface RentalRepository extends JpaRepository<Rental, UUID> {
}

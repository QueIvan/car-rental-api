package queivan.rental.exceptions;

import java.util.UUID;

public class RentalNotFoundException extends RuntimeException {
    public RentalNotFoundException(UUID id) {
        super(String.format("Rental with id %s, does not exist in DB", id));
    }
}
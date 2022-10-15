package queivan.rental.exceptions;

import java.util.UUID;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(UUID id){
        super(String.format("Car with id %s, does not exist in DB", id));
    }
}

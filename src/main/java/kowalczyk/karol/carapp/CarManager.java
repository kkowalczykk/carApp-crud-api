package kowalczyk.karol.carapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CarManager {

    private CarRepo carRepo;


    @Autowired
    public CarManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    /**
     *  Get all elements from database
     */
    public Optional<Car> findById(Long id){
        return carRepo.findById(id);
    }

    /**
     *  Get one element from database by ID
     */
    public Iterable<Car> findAll(){
        return carRepo.findAll();
    }

    /**
     *  Add element to database
     */
    public Car save(Car car) {
        return this.carRepo.save(car);
    }

    /**
     *  Delete element from database by ID
     */
    public void delete(Long id){
        carRepo.deleteById(id);
    }

    /**
     *  Fill Database with two examples after application starts working.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new Car(1, "Honda Accord", LocalDate.of(2009, 5, 10)));
        save(new Car(2, "Audi A6", LocalDate.of(2011, 7, 30)));
    }
}

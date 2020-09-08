package kowalczyk.karol.carapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/cars")
public class CarApi {

    private CarManager cars;

    @Autowired
    public CarApi(CarManager cars) {
        this.cars = cars;
    }

    @GetMapping("/all")
    public Iterable<Car> getAll() {
        return cars.findAll();
    }

    @GetMapping
    public Optional<Car> getbyId(@RequestParam Long index) {
        return cars.findById(index);
    }

    @PostMapping
    public Car addData(@RequestBody Car car){
        return cars.save(car);
    }

    @PutMapping
    public Car updateData(@RequestBody Car car){
        return cars.save(car);
    }

    @DeleteMapping
    public void deleteData(@RequestParam Long index){
        cars.delete(index);
    }


}
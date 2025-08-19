package com.cafe24.server.controller;

import com.cafe24.server.domain.user.Cafe;
import com.cafe24.server.domain.user.Place;
import com.cafe24.server.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService dataService;

    // GET
    @GetMapping("/places")
    public List<Place> getPlaces() {
        return dataService.getAllPlaces();
    }

    @GetMapping("/cafes")
    public List<Cafe> getCafes() {
        return dataService.getAllCafes();
    }

    // POST
    @PostMapping("/places")
    public Place addPlace(@RequestBody Place place) {
        return dataService.addPlace(place);
    }

    @PostMapping("/cafes")
    public Cafe addCafe(@RequestBody Cafe cafe) {
        return dataService.addCafe(cafe);
    }

    // PUT
    @PutMapping("/places/{id}")
    public Place updatePlace(@PathVariable String id, @RequestBody Place place) {
        return dataService.updatePlace(id, place);
    }

    @PutMapping("/cafes/{id}")
    public Cafe updateCafe(@PathVariable String id, @RequestBody Cafe cafe) {
        return dataService.updateCafe(id, cafe);
    }

    // DELETE
    @DeleteMapping("/places/{id}")
    public void deletePlace(@PathVariable String id) {
        dataService.deletePlace(id);
    }

    @DeleteMapping("/cafes/{id}")
    public void deleteCafe(@PathVariable String id) {
        dataService.deleteCafe(id);
    }
}

package com.cafe24.server.service;

import com.cafe24.server.domain.user.Cafe;
import com.cafe24.server.domain.user.Place;
import com.cafe24.server.repository.CafeRepository;
import com.cafe24.server.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final PlaceRepository placeRepository;
    private final CafeRepository cafeRepository;

    // GET
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public List<Cafe> getAllCafes() {
        return cafeRepository.findAll();
    }

    public Optional<Place> getPlaceById(String id) {
        return placeRepository.findById(id);
    }

    public Optional<Cafe> getCafeById(String id) {
        return cafeRepository.findById(id);
    }

    // POST / SET
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    public Cafe addCafe(Cafe cafe) {
        return cafeRepository.save(cafe);
    }

    // PUT / UPDATE
    public Place updatePlace(String id, Place updatedPlace) {
        return placeRepository.findById(id)
                .map(place -> {
                    place.setName(updatedPlace.getName());
                    place.setType(updatedPlace.getType());
                    place.setAddress(updatedPlace.getAddress());
                    place.setLatitude(updatedPlace.getLatitude());
                    place.setLongitude(updatedPlace.getLongitude());
                    place.setAdditional(updatedPlace.getAdditional());
                    place.setGroupName(updatedPlace.getGroupName());
                    place.setInternet(updatedPlace.getInternet());
                    place.setNumber(updatedPlace.getNumber());
                    place.setParking(updatedPlace.getParking());
                    place.setTableInfo(updatedPlace.getTableInfo());
                    place.setToilet(updatedPlace.getToilet());
                    return placeRepository.save(place);
                })
                .orElseThrow(() -> new RuntimeException("Place not found with id " + id));
    }

    public Cafe updateCafe(String id, Cafe updatedCafe) {
        return cafeRepository.findById(id)
                .map(cafe -> {
                    cafe.setName(updatedCafe.getName());
                    cafe.setType(updatedCafe.getType());
                    cafe.setAddress(updatedCafe.getAddress());
                    cafe.setLatitude(updatedCafe.getLatitude());
                    cafe.setLongitude(updatedCafe.getLongitude());
                    cafe.setInternet(updatedCafe.getInternet());
                    cafe.setGroupName(updatedCafe.getGroupName());
                    cafe.setNumber(updatedCafe.getNumber());
                    cafe.setParking(updatedCafe.getParking());
                    cafe.setTableInfo(updatedCafe.getTableInfo());
                    cafe.setToilet(updatedCafe.getToilet());
                    cafe.setDate(updatedCafe.getDate());
                    return cafeRepository.save(cafe);
                })
                .orElseThrow(() -> new RuntimeException("Cafe not found with id " + id));
    }

    // DELETE
    public void deletePlace(String id) {
        if (!placeRepository.existsById(id)) {
            throw new RuntimeException("Place not found with id " + id);
        }
        placeRepository.deleteById(id);
    }

    public void deleteCafe(String id) {
        if (!cafeRepository.existsById(id)) {
            throw new RuntimeException("Cafe not found with id " + id);
        }
        cafeRepository.deleteById(id);
    }
}

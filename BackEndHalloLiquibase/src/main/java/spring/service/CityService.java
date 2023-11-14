package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.controller.dto.CityDTO;
import spring.controller.dto.EventDTO;
import spring.domain.City;
import spring.domain.Event;
import spring.repository.CityRepository;
import spring.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private EventRepository eventRepository;

    public City findByName(String name) {
        City city = cityRepository.findByName(name);
        if (city != null) {
            city = new City(null, name);
            city = cityRepository.save(city);
        }
        return city;
    }

    public List<CityDTO> findAll() {
        List<City>sities = cityRepository.findAll();
        List<CityDTO>result = new ArrayList<>(sities.size());
        sities.forEach(city -> result.add(CityDTO.getInstance(city)));
        return result;
    }

    public CityDTO add(CityDTO city) {


        return null;
    }

    public CityDTO update(CityDTO city) {


        return null;
    }

    public CityDTO delete(Integer cityId) {
        City delCity = cityRepository.findById(cityId).orElse(null);
        if (delCity != null) {
            cityRepository.delete(delCity);
            return CityDTO.getInstance(delCity);
        }
        return null;
    }
}
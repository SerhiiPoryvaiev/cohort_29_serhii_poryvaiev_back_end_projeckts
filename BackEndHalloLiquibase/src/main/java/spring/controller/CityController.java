package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.controller.dto.CityDTO;
import spring.controller.dto.EventDTO;
import spring.service.CityService;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities/all")
    public List<CityDTO> findAll(){
        List<CityDTO> cities= cityService.findAll();
        return cities ;
    }
    @PostMapping("/cities/add")
    public CityDTO add(@RequestBody CityDTO city){

        return cityService.add(city);
    }

    @PutMapping("/cities/update")
    public CityDTO update(@RequestBody CityDTO city){

        return cityService.update(city);
    }

    @DeleteMapping("/cities/delete/{eventId}")
    public  CityDTO delete(@PathVariable Integer cityId){

        return cityService.delete(cityId);
    }
}

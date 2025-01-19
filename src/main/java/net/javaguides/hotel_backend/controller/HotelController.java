package net.javaguides.hotel_backend.controller;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import net.javaguides.hotel_backend.dto.HotelDto;
import net.javaguides.hotel_backend.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/hotels")
public class HotelController{
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto){
        HotelDto savedHotel = hotelService.createHotel(hotelDto);
        return new ResponseEntity<>(savedHotel , HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable("id") Long hotelId){
        HotelDto hotelDto = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotelDto);
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels(){
        List<HotelDto> hotels=  hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @PutMapping("{id}")
    public ResponseEntity<HotelDto> updateHotel(@PathVariable("id") Long hotelId, 
                                                @RequestBody HotelDto updatedHotel ){
        HotelDto hotel =  hotelService.updateHotel(hotelId, updatedHotel);
        return ResponseEntity.ok(hotel);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") Long hotelId){
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.ok("Hotel Deleted Successfully");
    }
}
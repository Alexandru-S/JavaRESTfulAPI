package net.javaguides.hotel_backend.service;

import net.javaguides.hotel_backend.dto.HotelDto;
import java.util.List;

public interface HotelService{
    HotelDto createHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long hotelId);

    List<HotelDto> getAllHotels();

    HotelDto updateHotel(Long hotelId, HotelDto updatedHotel);

    void deleteHotel(Long hotelId);
}
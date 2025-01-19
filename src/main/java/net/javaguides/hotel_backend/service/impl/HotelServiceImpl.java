package net.javaguides.hotel_backend.service.impl;
import jakarta.persistence.*;
import net.javaguides.hotel_backend.dto.HotelDto;
import net.javaguides.hotel_backend.service.HotelService;
import net.javaguides.hotel_backend.repository.HotelRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import net.javaguides.hotel_backend.mapper.HotelMapper;
import net.javaguides.hotel_backend.entity.Hotel;
import net.javaguides.hotel_backend.exception.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;
    @Override
    public HotelDto createHotel(HotelDto hotelDto){

        Hotel hotel = HotelMapper.maptoHotel(hotelDto);
        Hotel savedHotel = hotelRepository.save(hotel);
        return HotelMapper.mapToHotelDto(savedHotel);
    }
    @Override
    public HotelDto getHotelById(Long hotelId){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> 
            new ResourceNotFoundException("Hotel with given id not found, id: " + hotelId));
        return HotelMapper.mapToHotelDto(hotel);
    }

    @Override
    public List<HotelDto> getAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();

        return hotels.stream().map((hotel) -> HotelMapper.mapToHotelDto(hotel))
            .collect(Collectors.toList());
    }

    @Override
    public HotelDto updateHotel(Long hotelId, HotelDto updatedHotel){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel with id does not exist: "+hotelId));

        hotel.setName(updatedHotel.getName());
        hotel.setEmail(updatedHotel.getEmail());

        Hotel updatedHotelObj = hotelRepository.save(hotel);
        return HotelMapper.mapToHotelDto(updatedHotelObj);
    }

    @Override
    public void deleteHotel(Long hotelId){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel with id does not exist: "+hotelId));

        hotelRepository.deleteById(hotelId);

        //Hotel updatedHotelObj = hotelRepository.save(hotel);
       // return HotelMapper.mapToHotelDto(updatedHotelObj);
    }
}
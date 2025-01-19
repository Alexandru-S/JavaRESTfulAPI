package net.javaguides.hotel_backend.mapper;
import net.javaguides.hotel_backend.dto.HotelDto;
import net.javaguides.hotel_backend.entity.Hotel;

public class HotelMapper {
    public static HotelDto mapToHotelDto(Hotel hotel){
        return new HotelDto (
            hotel.getId(),
            hotel.getName(),
            hotel.getEmail()
        );
    }
    public static Hotel maptoHotel(HotelDto hotelDto){
        return new Hotel (
            hotelDto.getId(),
            hotelDto.getName(),
            hotelDto.getEmail()
        );
    }
}
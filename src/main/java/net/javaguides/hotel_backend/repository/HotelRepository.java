package net.javaguides.hotel_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.hotel_backend.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
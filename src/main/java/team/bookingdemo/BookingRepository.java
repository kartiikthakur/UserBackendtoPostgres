package team.bookingdemo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<TicketBooking,Long> {
    List<TicketBooking> findByPriceOfEventLessThan(double price);
}


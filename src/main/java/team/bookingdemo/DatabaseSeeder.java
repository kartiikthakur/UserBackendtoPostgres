package team.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        List<TicketBooking> bookings =  new ArrayList<>();

        bookings.add(new TicketBooking("Kygo" ,19.99, 2));
        bookings.add(new TicketBooking("Marshmello" ,15.49, 2));
        bookings.add(new TicketBooking("Ariana Grande" ,10.49, 3));

        bookingRepository.saveAll(bookings);

    }
}

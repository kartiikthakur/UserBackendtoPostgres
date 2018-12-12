package team.bookingdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
public class BookingController {
    private BookingRepository bookingRepository;


    //private  List<TicketBooking> bookings;
    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
        //bookings = new ArrayList<>();
        //bookings.add(new TicketBooking("Kygo" ,19.99, 2));
        //bookings.add(new TicketBooking("Marshmello" ,15.49, 2));
        //bookings.add(new TicketBooking("Ariana Grande" ,10.49, 3));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TicketBooking> getAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<TicketBooking> getAffordable(@PathVariable Double price){
        //return bookings.stream().filter(x -> x.getPriceOfEvent() <= price ).collect(Collectors.toList());
        return bookingRepository.findByPriceOfEventLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<TicketBooking> create(@RequestBody TicketBooking ticketBooking) {
        bookingRepository.save(ticketBooking);
        return bookingRepository.findAll();
    }

    public List<TicketBooking> remove(@PathVariable long id){
        bookingRepository.deleteById(id);
        return bookingRepository.findAll();
    }


}

package team.bookingdemo;



import javax.persistence.*;

@Entity
@Table(name="bookings")
public class TicketBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "eventName")
    private  String eventName;

    @Column(name = "priceOfEvent")
    private double priceOfEvent;

    @Column(name = "noOfTickets")
    private int noOfTickets;


    public TicketBooking(String eventName, double priceOfEvent, int noOfTickets){
            this.eventName= eventName;
            this.priceOfEvent = priceOfEvent;
            this.noOfTickets= noOfTickets;
    }
    public TicketBooking(){}

        public long getId(){
        return id;
    }
        public String getEventName() {
        return eventName;
    }
        public double getPriceOfEvent() {
            return priceOfEvent;
        }
        public int getNoOfTickets() {
            return noOfTickets;
        }




    }



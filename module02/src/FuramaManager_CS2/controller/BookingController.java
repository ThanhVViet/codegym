package FuramaManager_CS2.controller;

import FuramaManager_CS2.model.Booking;
import FuramaManager_CS2.service.BookingService;
import FuramaManager_CS2.service.BookingServiceImpl;

import java.util.List;

public class BookingController {
    private BookingService bookingService = new BookingServiceImpl();

    public void create(Booking booking){
        bookingService.create(booking);
    }

    public List<Booking> findAll(){
        return bookingService.findAll();
    }
}

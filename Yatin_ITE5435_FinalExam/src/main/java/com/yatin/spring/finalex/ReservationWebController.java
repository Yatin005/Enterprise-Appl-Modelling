package com.yatin.spring.finalex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationWebController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/form")
    public String showReservationForm(Model model) {
        model.addAttribute("reservationForm", new ReservationForm());
        return "reservation-form";
    }

    @PostMapping("/submit")
    public String submitReservation(@ModelAttribute ReservationForm reservationForm) {
        // Here, we convert the form data into our entity model
        Reservation reservation = new Reservation();
        Customer customer = new Customer();
        Payment payment = new Payment();

        customer.setName(reservationForm.getFirstName() + " " + reservationForm.getLastName());
        customer.setContactNumber(reservationForm.getPhoneNumber());

        payment.setAmount(500 * reservationForm.getNumberOfPassengers()); // Example price logic
        payment.setDate(reservationForm.getDepartingDate());

        reservation.setDetails("Class: " + reservationForm.getSelectedClass() + ", Time: " + reservationForm.getTime());
        reservation.setTicketNumber("TICKET-" + System.currentTimeMillis());
        reservation.setDate(reservationForm.getDepartingDate());
        reservation.setCustomer(customer);
        reservation.setPayment(payment);

        reservationService.createReservation(reservation);
        
        return "redirect:/reservations/confirmation";
    }

    @GetMapping("/confirmation")
    public String showConfirmationPage() {
        return "confirmation-page";
    }
}
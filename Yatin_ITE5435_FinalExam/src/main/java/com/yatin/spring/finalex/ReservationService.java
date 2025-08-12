package com.yatin.spring.finalex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PaymentService paymentService;

    public Reservation createReservation(Reservation reservation) {
        Customer savedCustomer = customerService.saveCustomer(reservation.getCustomer());
        Payment savedPayment = paymentService.savePayment(reservation.getPayment());
        
        reservation.setCustomer(savedCustomer);
        reservation.setPayment(savedPayment);
        
        return reservationRepository.save(reservation);
    }
}
package com.javarush.drogunov;

import com.javarush.drogunov.model.dao.CustomerDAO;
import com.javarush.drogunov.model.dao.FilmDAO;
import com.javarush.drogunov.model.dao.PaymentDAO;
import com.javarush.drogunov.model.dao.RentalDAO;
import com.javarush.drogunov.model.dto.*;
import com.javarush.drogunov.model.entity.Film;
import com.javarush.drogunov.model.entity.Payment;
import com.javarush.drogunov.model.entity.Rental;
import com.javarush.drogunov.repository.mysql.MysqlDb;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        createNewCustomer();
        wentToShop();
        newFilmInRental();
    }
    
    private static void newFilmInRental() {
        FilmDAO filmDAO = new FilmDAO(MysqlDb.getFactory());
        FilmDTO testFilmDTO = getTestFilmDTO();
        Film film = filmDAO.createAndGet(testFilmDTO);
        System.out.println(film);
    }
    
    private static FilmDTO getTestFilmDTO() {
        return FilmDTO.builder()
                .title("JavaRush")
                .rating("R")
                .rentalDuration(3)
                .description("Packed Yarn of a Secret A")
                .length(60)
                .rentalRate(BigDecimal.valueOf(4.99))
                .releaseYear(2022)
                .replacementCost(BigDecimal.valueOf(20.01))
                .specialFeatures("One, Two")
                .categories(new ArrayList<>() {{
                    add(CategoryDTO.builder()
                            .name("Horror")
                            .build());
                    add(CategoryDTO.builder()
                            .name("OldHorror")
                            .build());
                }})
                .language(LanguageDTO.builder()
                        .name("Japanese")
                        .build())
                .actors(new ArrayList<ActorDTO>() {{
                            add(ActorDTO.builder()
                                    .firstName("Shurik")
                                    .lastName("Shurikovich")
                                    .build());
                            add(ActorDTO.builder()
                                    .firstName("Javic")
                                    .lastName("Javikovich")
                                    .build());
                        }}
                )
                .build();
    }
    
    private static void wentToShop() {
        RentalDAO rentalDAO = new RentalDAO(MysqlDb.getFactory());
        RentalDTO rentalDTO = RentalDTO.builder()
                .staffId(1)
                .customerId(1)
                .inventoryId(1)
                .returnDate(Timestamp.from(Instant.now().plus(3, ChronoUnit.DAYS)))
                .build();
        Rental rental = rentalDAO.rentMovie(rentalDTO);
        
        PaymentDAO paymentDAO = new PaymentDAO(MysqlDb.getFactory());
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .rentalId(rental.getId())
                .amount(BigDecimal.valueOf(4.9))
                .build();
        Payment payment = paymentDAO.pay(paymentDTO);
    }
    
    private static void createNewCustomer() {
        AddressDTO addressDTO = new AddressDTO(
                "Смоленская 34",
                "Югозапад",
                new CityDTO("Moscow", new CountryDTO("Russia")),
                "3234",
                "1231234241");
        CustomerDTO customerDTO = new CustomerDTO(
                "Test",
                "Testov",
                "wqeqwe@dsdsad.com",
                1,
                addressDTO
        );
        CustomerDAO customerDAO = new CustomerDAO(MysqlDb.getFactory());
        customerDAO.create(customerDTO);
    }
    
}
    


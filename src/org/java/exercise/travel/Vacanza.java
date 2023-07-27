package org.java.exercise.travel;

/*
creare la classe Vacanza caratterizzata da:
- destinazione
- data inizio
- data fine
Quando viene creata una nuova Vacanza vanno effettuati dei controlli:
- destinazione, data inizio e data fine non possono essere null
- la data inizio non può essere già passata
- la data fine non può essere prima della data inizio
Se fallisce la validazione vanno sollevate opportune eccezioni
La classe Vacanza espone un metodo per calcolare la durata in giorni della vacanza.
 */

import java.time.LocalDate;
import java.time.Period;

public class Vacanza {

    // CAMPI
    private String destination;
    private LocalDate dateBegin;
    private LocalDate dateEnd;


    // COSTRUTTORI

    public Vacanza(String destination, LocalDate dateBegin, LocalDate dateEnd) throws RuntimeException {
        // se destination è null
        if (destination == null || destination.isEmpty()) {
            // sollevo un'eccezione
            throw new RuntimeException("destination must not be null or empty");
        }

        // se dateBegin è null
        if (dateBegin == null || dateBegin.isBefore(LocalDate.now())) {
            throw new RuntimeException("dateBegin must not be null and must be in the future");
        }

        // se dateEnd è null
        if (dateEnd == null || dateEnd.isBefore(dateBegin)) {
            throw new RuntimeException("dateEnd must not be null and must be after dateBegin");
        }
        this.destination = destination;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }


    // GETTER E SETTER


    // METODI
    // calcolo i giorni di vacanza
    public int getVacation(){
        Period vacationPeriod =Period.between(dateBegin, dateEnd);
        return vacationPeriod.getDays();
    }

    @Override
    public String toString() {
        return "Vacanza{" +
                "destination='" + destination + '\'' +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                '}';
    }
}

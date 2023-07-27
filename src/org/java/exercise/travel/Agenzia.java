package org.java.exercise.travel;

/*
Aggiungere una classe Agenzia con metodo main, dove chiediamo all’operatore se vuole inserire una nuova vacanza o uscire.
Se vuole proseguire con l’inserimento va chiesta la destinazione, il giorno, mese e anno di partenza e il giorno, mese anno di ritorno.
Con questi dati va generata una nuova vacanza e in console verrà stampato un messaggio del tipo:
“Hai prenotato una vacanza di [numero di giorni] giorni a [destinazione] dal [data inizio formattata] al [data fine formattata]“.
Se la creazione della vacanza genera un errore, il programma non deve interrompersi ma va gestito con dei messaggi di errore
che permettono all’utente di capire cosa è andato storto e di ripetere l’inserimento.
 */

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Agenzia {

    public static void main(String[] args) {
        // creo lo scanner
        Scanner input = new Scanner(System.in);
        // creo una variabile booleana exit
        boolean exit = false;
        // itero un ciclo while
        while (!exit){
            System.out.println("Benvenuto nella nostra agenzia di viaggi!");
            System.out.println("Cosa vuoi fare? 1-Inserisci una nuova vacanza, 2- Esci");
            String choice = input.nextLine();
            // provo con un if
            switch (choice){
                case "1":
                    System.out.println("Inserisci la destinazione: ");
                    String destination = input.nextLine();
                    System.out.println("Inserisci la data di partenza (yyyy-mm-dd): ");
                    LocalDate dateBegin =LocalDate.parse(input.nextLine());
                    System.out.println("Inserisci la data di ritorno (yyyy-mm-dd): ");
                    LocalDate dateEnd = LocalDate.parse(input.nextLine());
                try {
                    Vacanza vacanza = new Vacanza(destination, dateBegin, dateEnd);
                    System.out.println(vacanza);
                    System.out.println("Hai prenotato una vacanza di " + vacanza.getVacation() + " giorni a " + destination +" dal " + dateBegin + " al " + dateEnd);
                } catch (Exception e){
                    System.out.println("Parametri non validi");
                    System.out.println(e.getMessage());

                }
                    break;
                case "2":
                    exit = true;
                    break;

            }

        }

        System.out.println("Grazie di averci scelto! A presto!");

        input.close();
    }
}

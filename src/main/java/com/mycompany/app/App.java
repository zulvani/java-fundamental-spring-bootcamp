package com.mycompany.app;

import com.mycompany.myapp.service.*;

import java.awt.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final String APP_VERSION = "1.0.1";


    public App() throws InvalidInputException {
        testDate();
    }

    private void staticVsObject(){
        Person danang = new Person("Danang", "Prakoso");
        Person budi = new Person("Budi", "Setiawan");

        danang.showAppVersion();
        danang.showFullName();

        budi.showAppVersion();
        budi.showFullName();

        Student dandi = new Student("Dandi", "Kurniawan", "ST");
        System.out.println(dandi.getFullName());
    }

    private void testInterface(){
        RegistrationService registrationService = new RegistrationImpl();
        PersonService personService = new RegistrationImpl();

        registrationService.getRegisteredStudents();
        RegistrationService.cancel();

        personService.getPersonByFirstName();
    }

    private void testAbstractClass(){
        Authentication authentication = new DatabaseAuthentication();
        authentication.authenticate("admin", "admin");
    }

    private void testDate(){
        LocalDate ld = LocalDate.now(); // Create a date object
        System.out.println(ld); // Display the current date

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);

        String date = "";
        LocalDate localDate = null;
        DateTimeFormatter formatter = null;

        // Converting 'dd-MMM-yyyy' String format to LocalDate
        date = "22-Apr-2017";
        formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        localDate = LocalDate.parse(date, formatter);
        System.out.println("Input Date?= "+ date);
        System.out.println("Converted Date?= "+ localDate + "\n");

        LocalDate lDate  = LocalDate.parse("2018-11-13");
        LocalDate after10Days = lDate.plusDays(10);
        LocalDate after2Months = lDate.plusMonths(2);
        LocalDate after2Weeks = lDate.plusWeeks(2);
        LocalDate after2Years = lDate.plusWeeks(2);

        System.out.println("noq = "+ lDate);
        System.out.println("plus 10 days = "+ after10Days);
        System.out.println("plus 2 months = "+ after2Months);
        System.out.println("plus 2 years = "+ after2Years);
        System.out.println("plus 2 weeks = "+ after2Weeks);

        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime after10Minutes = ldt.plusMinutes(10);
        LocalDateTime after10Hours = ldt.plusHours(10);
        LocalDateTime after10Seconds = ldt.plusSeconds(10);
        System.out.println("now = "+ ldt);
        System.out.println("plus 10 minutes = "+ after10Minutes);
        System.out.println("plus 10 hours = "+ after10Hours);
        System.out.println("plus 10 seconds = "+ after10Seconds);

        Instant now = Instant.now();
        ZonedDateTime chicago = now.atZone(ZoneId.of("America/New_York"));
        System.out.println("Chicago: " + chicago);
        System.out.println("Chicago formated: " + chicago.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)));

        ZonedDateTime tokyo = now.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println("Tokyo: " + tokyo);
        System.out.println("Tokyo formated: " + tokyo.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)));
    }

    public static void main(String[] args ) {
        try {
            new App();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }


    }
}

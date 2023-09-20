package com.fshtank.sanbox.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Function;

public class TimeLibrarySamplesCLI {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeLibrarySamplesCLI.class);

    /**
     * Comparator vs. Comparable
     * https://www.baeldung.com/java-comparator-comparable
     * https://www.baeldung.com/java-8-comparator-comparing
     * @param keyExtractor
     * @return
     * @param <T>
     * @param <U>
     */
    static <T,U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T,? extends U> keyExtractor)

    public static void main (String[] args) {
        TimeLibrarySamplesCLI cli = new TimeLibrarySamplesCLI();
        cli.printTimes();
        cli.printZonesIds();
    }

    private void printTimes() {
        LOGGER.info("LocalDate NOW!:"+ LocalDate.now()) ;
        LOGGER.info("LocalTime NOW!:"+ LocalTime.now()) ;
        LOGGER.info("LocalDateTime NOW!:"+ LocalDateTime.now()) ;
    }

    private void printZonesIds() {

        Set<String> zonesIds = ZoneId.getAvailableZoneIds();
        Comparator<String> zoneComparator = Comparator.comparing(zonesIds::forEach)



        int id=0;
        for (String zoneID : zonesIds) {
            String toPrint = id+ ". timezone: " + zoneID;
            LOGGER.info(toPrint);
            // System.out.println(toPrint);
        }
    }



}

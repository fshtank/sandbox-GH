package com.fshtank.sanbox.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeLibrarySamplesCLI {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeLibrarySamplesCLI.class);

    public static void main (String[] args) {
        TimeLibrarySamplesCLI cli = new TimeLibrarySamplesCLI();
        cli.printTimes();
    }

    private void printTimes() {
        LOGGER.info("LocalDate NOW!:"+ LocalDate.now()) ;
        LOGGER.info("LocalTime NOW!:"+ LocalTime.now()) ;
        LOGGER.info("LocalDateTime NOW!:"+ LocalDateTime.now()) ;
    }

    private void printZonesIds() {

    }



}

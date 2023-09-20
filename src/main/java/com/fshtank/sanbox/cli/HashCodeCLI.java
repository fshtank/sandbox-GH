package com.fshtank.sanbox.cli;

import com.fshtank.sanbox.model.SboxRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class HashCodeCLI {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashCodeCLI.class);

    public static void main (String[] args) {
        HashCodeCLI cli = new HashCodeCLI();
        cli.printHash();
    }

    private void printHash() {
        LOGGER.info("Hash of SboxRequest:"+this.getNewSboxRequest().hashCode());
        LOGGER.info("Simple Hash ('Rick', 54):" + Objects.hash("Rick", 54));

    }

    private SboxRequest getNewSboxRequest() {

        SboxRequest sboxRequest = new SboxRequest();
        sboxRequest.setLocale("en");
        sboxRequest.setLanguage("en");
        sboxRequest.setDigitToShift(1);
        sboxRequest.setSampleId(544007);
        return sboxRequest;
    }
}

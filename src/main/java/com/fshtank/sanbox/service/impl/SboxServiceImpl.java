package com.fshtank.sanbox.service.impl;

import com.fshtank.sanbox.model.SboxResponse;
import com.fshtank.sanbox.model.SboxRequest;
import com.fshtank.sanbox.service.SboxService;

import java.nio.charset.Charset;
import java.util.Random;

public class SboxServiceImpl implements SboxService {
    private static final String SHIFT_LEFT="LEFT";
    private static final String SHIFT_RIGHT="RIGHT";

    @Override
    public SboxResponse doSomething(SboxRequest req) {

        var resp = new SboxResponse();

        resp.setLanguage(req.getLanguage());
        resp.setLocale(req.getLocale());
        resp.setSampleId(req.getSampleId());

        resp.setRandomValue(generateRandomString());

        return resp;
    }

    /**
     * 20210416 - I wanted to try bitwise Shift operators (pp40 Java2 Little black book)
     * @param req
     * @return
     */
    @Override
    public SboxResponse doShiftThing(SboxRequest req) {

        SboxResponse response = new SboxResponse();

        int shiftResult = 0;
        String shiftDirection=null;

        if (req.getShiftDirection().equals(SHIFT_LEFT)) {
            shiftResult = req.getDigitToShift()<<req.getShiftOperator();
            shiftDirection = "<<";

        } else if (req.getShiftDirection().equals(SHIFT_RIGHT)) {
            shiftResult = req.getDigitToShift()<<req.getShiftOperator();
            shiftDirection = ">>";
        }

        response.setShiftOperation(req.getDigitToShift(), req.getShiftOperator(), shiftResult, shiftDirection);

        return response;

    }

    /**
     * Generate some random string to fill the last response value randomValue
     * @return
     */
    private String generateRandomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }
}

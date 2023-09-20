package com.fshtank.sanbox.controller;

import com.fshtank.sanbox.model.SboxRequest;
import com.fshtank.sanbox.model.SboxResponse;
import com.fshtank.sanbox.service.SboxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Example REST resource controller.
 *
 * @author Rick Fisher (richard.fisher@gm.com)
 */
@RestController
@RequestMapping("/sandbox")
public class SboxController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SboxController.class);
    @Autowired
    SboxService sbxService;
    @Autowired
    private SboxRequest sanboxWebRequest;

    /**
     * @return Collection of Collection<PbcOfertaVeiculo>
     */
    @RequestMapping(value = "/demo/{locale}/{language}",
            method = RequestMethod.GET,
            produces = {"application/vnd.status.v1+json;version=1.0",
                    "application/vnd.status.v1+xml;version=1.0"}
    )
    public SboxResponse getDemo(@PathVariable("locale") String locale,
                                @PathVariable("language") String language,
                                @RequestParam(value = "sampleId", required = false) Integer sampleId) {

        sanboxWebRequest.setLocale(locale);
        sanboxWebRequest.setLanguage(language);
        sanboxWebRequest.setSampleId(sampleId);

        SboxResponse sboxResponse = sbxService.doSomething(sanboxWebRequest);

        return sboxResponse;
    }


    /**
     * @return Collection of Collection<PbcOfertaVeiculo>
     */
    @RequestMapping(value = "/bitwise/{digit}",
            method = RequestMethod.GET,
            produces = {"application/vnd.status.v1+json;version=1.0",
                    "application/vnd.status.v1+xml;version=1.0"}
    )
    public SboxResponse getShiftDemo(@PathVariable("digit") int digitInt,
                                     @RequestParam(value = "direction", required = true) String shiftDirection,
                                     @RequestParam(value = "shift", required = true) Integer shiftInt)  {
        sanboxWebRequest.setDigitToShift(digitInt);
        sanboxWebRequest.setShiftOperator(shiftInt);
        sanboxWebRequest.setShiftDirection(shiftDirection);

        SboxResponse sboxResponse = sbxService.doShiftThing(sanboxWebRequest);

        return sboxResponse;
    }



    @RequestMapping(value = "alive",
            method = RequestMethod.GET,
            produces = {"application/vnd.currentoffers.v2+json;version=2.0",
                    "application/vnd.currentoffers.v2+xml;version=2.0"}
    )

    public String imAlive () { return "Pearl Jam: 'Im Alive!'";
    }

}

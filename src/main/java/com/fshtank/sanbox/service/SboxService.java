package com.fshtank.sanbox.service;

import com.fshtank.sanbox.model.SboxRequest;
import com.fshtank.sanbox.model.SboxResponse;

public interface SboxService {
    public SboxResponse doSomething (SboxRequest req);

    public SboxResponse doShiftThing (SboxRequest req);


}

package com.cow.facade;

import com.cow.model.CowFaceModel;

public interface CowFacade {
    String say(CowFaceModel face, String message);
}

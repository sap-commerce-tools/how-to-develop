package com.cow.facade.impl;

import com.cow.data.CowParams;
import com.cow.facade.CowFacade;
import com.cow.model.CowFaceModel;
import com.cow.service.CowSay;
import de.hybris.platform.servicelayer.dto.converter.Converter;

public class DefaultCowFacade implements CowFacade {

    private final CowSay cowSay;
    private final Converter<CowFaceModel, CowParams> faceToParams;

    public DefaultCowFacade(CowSay cowSay, Converter<CowFaceModel, CowParams> faceToParams) {
        this.cowSay = cowSay;
        this.faceToParams = faceToParams;
    }

    @Override
    public String say(CowFaceModel face, String message) {
        CowParams convert = faceToParams.convert(face);
        return cowSay.say(convert, message);
    }
}

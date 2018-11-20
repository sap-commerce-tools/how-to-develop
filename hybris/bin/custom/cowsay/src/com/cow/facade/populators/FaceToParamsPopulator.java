package com.cow.facade.populators;

import com.cow.data.CowParams;
import com.cow.model.CowFaceModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class FaceToParamsPopulator implements Populator<CowFaceModel, CowParams> {
    @Override
    public void populate(CowFaceModel cowFaceModel, CowParams cowParams) throws ConversionException {
        if (cowFaceModel == null || cowParams == null) {
            return;
        }
        cowParams.setTongue(cowFaceModel.getTongue());
        cowParams.setEyes(cowFaceModel.getEyes());
        cowParams.setThink(cowFaceModel.getThink());
        cowParams.setFaceCode(cowFaceModel.getCode());
    }
}

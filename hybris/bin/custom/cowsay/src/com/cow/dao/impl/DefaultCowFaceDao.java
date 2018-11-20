package com.cow.dao.impl;

import com.cow.dao.CowFaceDao;
import com.cow.model.CowFaceModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class DefaultCowFaceDao extends DefaultGenericDao<CowFaceModel> implements CowFaceDao {

    public DefaultCowFaceDao() {
        super(CowFaceModel._TYPECODE);
    }

    @Override
    public Optional<CowFaceModel> getForCode(String code) {
        List<CowFaceModel> cowFaceModels = find(Collections.singletonMap(CowFaceModel.CODE, code));
        if (cowFaceModels.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(cowFaceModels.iterator().next());
        }
    }
}

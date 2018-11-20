package com.cow.dao;

import com.cow.model.CowFaceModel;

import java.util.Optional;

public interface CowFaceDao {

    Optional<CowFaceModel> getForCode(String code);
}

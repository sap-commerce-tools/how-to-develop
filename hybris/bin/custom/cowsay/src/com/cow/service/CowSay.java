package com.cow.service;


import com.cow.data.CowParams;

import javax.annotation.Nonnull;

public interface CowSay {
    String say(@Nonnull String message);
    String say(@Nonnull CowParams cow, @Nonnull String message);
}

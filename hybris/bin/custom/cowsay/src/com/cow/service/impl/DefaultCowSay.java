package com.cow.service.impl;

import com.cow.data.CowParams;
import com.cow.service.CowSay;
import com.github.ricksbrown.cowsay.plugin.CowExecutor;

import javax.annotation.Nonnull;


public class DefaultCowSay implements CowSay {

    @Override
    public String say(@Nonnull String message) {
        CowExecutor executor = new CowExecutor();
        executor.setMessage(message);
        return executor.execute();
    }

    @Override
    public String say(@Nonnull CowParams cow, @Nonnull String message) {
        CowExecutor executor = new CowExecutor();
        executor.setThink(cow.isThink());
        executor.setEyes(cow.getEyes());
        executor.setTongue(cow.getTongue());
        executor.setMessage(message);
        return executor.execute();
    }
}

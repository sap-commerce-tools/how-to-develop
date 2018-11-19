package com.cow.service.impl;

import com.cow.service.CowSay;
import com.github.ricksbrown.cowsay.plugin.CowExecutor;

public class DefaultCowSay implements CowSay {

    @Override
    public String say(String message) {
        CowExecutor executor = new CowExecutor();
        executor.setMessage(message);
        return executor.execute();
    }
}

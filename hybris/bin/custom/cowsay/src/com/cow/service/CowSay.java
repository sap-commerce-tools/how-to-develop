package com.cow.service;


import com.cow.data.CowParams;

public interface CowSay {
    String say(String message);
    String say(CowParams cow, String message);
}

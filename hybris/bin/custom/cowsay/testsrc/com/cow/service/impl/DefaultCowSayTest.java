package com.cow.service.impl;

import com.cow.service.CowSay;
import de.hybris.bootstrap.annotations.UnitTest;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

@UnitTest
public class DefaultCowSayTest {

    CowSay cowSay;

    @Before
    public void setUp() throws Exception {
        cowSay = new DefaultCowSay();
    }

    @Test
    public void say() {
        String result = cowSay.say("test");
        assertThat(result).isEqualTo(
                " ______\n" +
                        "< test >\n" +
                        " ------\n" +
                        "        \\   ^__^\n" +
                        "         \\  (oo)\\_______\n" +
                        "            (__)\\       )\\/\\\n" +
                        "                ||----w |\n" +
                        "                ||     ||\n"
        );
    }
}
package com.cow.facade.impl

import com.cow.data.CowParams
import com.cow.model.CowFaceModel
import com.cow.service.CowSay
import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.servicelayer.dto.converter.Converter
import org.junit.Test
import spock.lang.Specification

@UnitTest
class DefaultCowFacadeTest extends Specification {

    @Test
    def "facade uses converter and service"() {
        given:
        CowSay cowSay = Mock(CowSay)
        Converter<CowFaceModel, CowParams> converter = Mock()
        CowParams p = Mock()

        def facade = new DefaultCowFacade(cowSay, converter)

        when:
        def result = facade.say(Mock(CowFaceModel), "test")

        then:
        1 * converter.convert(_ as CowFaceModel) >> p
        1 * cowSay.say(p, "test") >> "cowSay"
        result == "cowSay"
    }
}

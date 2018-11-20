package com.cow.addon.renderer;

import com.cow.addon.model.CowComponentModel;
import com.cow.facade.CowFacade;
import de.hybris.platform.addonsupport.renderer.impl.DefaultAddOnCMSComponentRenderer;

import javax.servlet.jsp.PageContext;
import java.util.Collections;
import java.util.Map;

//use a renderer -> faster than a regular ComponentController
public class CowSayComponentRenderer extends DefaultAddOnCMSComponentRenderer<CowComponentModel> {

    private final CowFacade cowFacade;

    public CowSayComponentRenderer(CowFacade cowFacade) {
        this.cowFacade = cowFacade;
    }

    @Override
    protected Map<String, Object> getVariablesToExpose(PageContext pageContext, CowComponentModel component) {
        String say = cowFacade.say(component.getCowFace(), component.getText());
        return Collections.singletonMap("cowsay", say);
//        return super.getVariablesToExpose(pageContext, component);
    }
}

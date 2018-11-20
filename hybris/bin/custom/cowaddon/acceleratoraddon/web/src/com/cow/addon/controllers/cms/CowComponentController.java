package com.cow.addon.controllers.cms;

import com.cow.addon.model.CowComponentModel;
import com.cow.facade.CowFacade;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//this is the config for a regular ComponentController, but better don't use it
//check com.cow.addon.renderer.CowSayComponentRenderer for a faster alternative

//@Controller("CowComponentController")
//@RequestMapping("/view/CowComponentController")
public class CowComponentController extends AbstractCMSAddOnComponentController<CowComponentModel> {

    @Resource
    private CowFacade cowFacade;

    @Override
    protected void fillModel(HttpServletRequest request, Model model, CowComponentModel component) {
        String say = cowFacade.say(component.getCowFace(), component.getText());
        model.addAttribute("cowsay", say);
    }

}

package com.cow.backoffice.actions;

import com.cow.model.CowFaceModel;
import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.actions.ActionResult;
import com.hybris.cockpitng.actions.CockpitAction;
import com.hybris.cockpitng.engine.impl.AbstractComponentWidgetAdapterAware;

public class CowPreviewAction extends AbstractComponentWidgetAdapterAware implements CockpitAction {

    @Override
    public ActionResult perform(ActionContext actionContext) {
        sendOutput("cowFace", actionContext.getData());
        return new ActionResult(ActionResult.SUCCESS);
    }

    @Override
    public boolean canPerform(ActionContext ctx) {
        return ctx.getData() instanceof CowFaceModel;
    }
}

package com.cow.addon.renderer;

import com.cow.addon.model.CowComponentModel;
import com.cow.facade.CowFacade;
import com.cow.model.CowFaceModel;
import de.hybris.bootstrap.annotations.UnitTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.servlet.jsp.PageContext;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@UnitTest
public class CowSayComponentRendererTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    PageContext pageContext;

    @Mock
    CowFacade cowFacade;

    @Mock
    CowComponentModel cowComponentModel;

    @Mock
    CowFaceModel componentFace;

    CowSayComponentRenderer rendererUnderTest;


    @Before
    public void setUp() throws Exception {
        rendererUnderTest = new CowSayComponentRenderer(cowFacade) {
            @Override
            protected String getView(CowComponentModel component) {
                return "testview";
            }
        };
        when(cowComponentModel.getCowFace()).thenReturn(componentFace);
        when(cowComponentModel.getText()).thenReturn("test");

        when(cowFacade.say(any(), any())).thenReturn("testsay");
    }

    @Test
    public void render_adds_cowsay_to_model() throws Exception {

        rendererUnderTest.renderComponent(pageContext, cowComponentModel);

        verify(cowFacade).say(componentFace, "test");
        verify(pageContext).setAttribute("cowsay", "testsay", PageContext.REQUEST_SCOPE);

    }
}
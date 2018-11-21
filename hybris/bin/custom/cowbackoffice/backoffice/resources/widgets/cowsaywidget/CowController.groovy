package widgets.CowbackofficeWidget

import com.cow.service.CowSay
import com.hybris.cockpitng.util.DefaultWidgetController
import org.zkoss.zhtml.Pre
import org.zkoss.zhtml.Text
import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.select.annotation.WireVariable

import javax.annotation.Resource


//using a groovy controller enables rapid prototyping without requiring DCEVM or JRebel
//change the source and reload, even Spring beans are correctly injected
class CowController extends DefaultWidgetController {

    private static final long serialVersionUID = 1L

    //elements from the *.zul view are wired automatically
    //the match happens via the 'id' + type of the element
    Pre container

    @Resource
    CowSay cowService

    @Override
    void initialize(final Component comp)
    {
        super.initialize(comp)
        def text = getLabel("hello")
        def cowsay = cowService.say(text)
        container.appendChild(new Text(cowsay))
    }
}

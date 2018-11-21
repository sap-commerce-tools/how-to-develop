package widgets.cowpopup

import com.cow.facade.CowFacade
import com.cow.model.CowFaceModel
import com.hybris.cockpitng.annotations.SocketEvent
import com.hybris.cockpitng.util.DefaultWidgetController
import org.zkoss.zhtml.Pre
import org.zkoss.zhtml.Text

import javax.annotation.Resource

class CowPopupController extends DefaultWidgetController {

    Pre preview

    @Resource
    private CowFacade cowFacade

    @SocketEvent(socketId = "previewContext")
    void displayPreview(CowFaceModel cowFace) {
        String title = getLabel("preview.title", cowFace.code)
        setWidgetTitle(title)
        String cowSay = cowFacade.say(cowFace, getLabel("preview.text"))
        preview.appendChild(new Text(cowSay))
    }

}

package com.cow.tests.setup;

import de.hybris.platform.servicelayer.event.events.AfterInitializationEndEvent;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.impex.ImpExResource;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.ClasspathImpExResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//regular @SystemSetup classes aren't triggered by `ant yunitinit` -> use the AfterInitializationEndEvent as workaround
public class CowTestDataSetup extends AbstractEventListener<AfterInitializationEndEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(CowTestDataSetup.class);

    private ImportService importService;

    @Override
    protected void onEvent(AfterInitializationEndEvent afterInitializationEndEvent) {
        if (isJunitInit(afterInitializationEndEvent)) {
            importOrFail("/cowsaytests/default-test-cowfaces.impex");
        }
    }

    private void importOrFail(String classpath) {
        LOG.info("Importing classpath resource '{}' ...", classpath);
        ImpExResource r = new ClasspathImpExResource(classpath, "UTF-8");
        ImportConfig cfg = new ImportConfig();
        cfg.setFailOnError(true);
        cfg.setScript(r);
        importService.importData(cfg);
        LOG.info("Importing classpath resource '{}' DONE", classpath);
    }

    private boolean isJunitInit(AfterInitializationEndEvent event) {
        return event.getScope() != null && "junit".equals(event.getScope().getTenantId());
    }

    public ImportService getImportService() {
        return importService;
    }

    public void setImportService(ImportService importService) {
        this.importService = importService;
    }
}

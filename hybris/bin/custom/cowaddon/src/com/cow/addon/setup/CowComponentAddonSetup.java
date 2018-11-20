package com.cow.addon.setup;

import com.cow.addon.constants.CowaddonConstants;
import de.hybris.platform.commerceservices.setup.SetupImpexService;
import de.hybris.platform.commerceservices.setup.SetupSyncJobService;
import de.hybris.platform.core.initialization.SystemSetup;

@SystemSetup(extension = CowaddonConstants.EXTENSIONNAME, process = SystemSetup.Process.ALL, type = SystemSetup.Type.PROJECT)
public class CowComponentAddonSetup {

    private final SetupImpexService setupImpexService;
    private final SetupSyncJobService setupSyncJobService;

    public CowComponentAddonSetup(SetupImpexService setupImpexService, SetupSyncJobService setupSyncJobService) {
        this.setupImpexService = setupImpexService;
        this.setupSyncJobService = setupSyncJobService;
    }

    @SystemSetup(patch = true)
    public void addCowToHomepage() throws Exception {
        setupImpexService.importImpexFile("/cowaddon/import/contentCatalogs/electronicsContentCatalog/cms-content.impex", true);
        setupSyncJobService.executeCatalogSyncJob("electronicsContentCatalog");
    }
}

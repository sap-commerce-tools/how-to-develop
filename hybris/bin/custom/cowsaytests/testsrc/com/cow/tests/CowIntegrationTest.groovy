package com.cow.tests

import com.cow.dao.CowFaceDao
import com.cow.model.CowFaceModel
import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.servicelayer.ServicelayerTransactionalSpockSpecification
import org.junit.Test

import javax.annotation.Resource

@IntegrationTest
class CowIntegrationTest extends ServicelayerTransactionalSpockSpecification {

    @Resource
    private CowFaceDao cowFaceDao

    //JUnit @Test annotation is necessary for the platform build to detect the test correctly
    @Test
    void "dao should work as expected"() {
        given:
        importData("/cowsaytests/cowfaces.impex", "UTF-8")

        when:
        Optional<CowFaceModel> borg = cowFaceDao.getForCode("borg")

        then:
        borg.isPresent()
        borg.get().code == "borg"
        borg.get().eyes == "=="
        borg.get().tongue == ""
    }

    //every test runs in its own DB transaction, so you can add/modify/delete data without impacting other test cases
    @Test
    void "dao doesn't see non-existing data"() {
        when:
        // the 'hybris' face is imported by your hook into yunitinit, CowTestDataSetup,
        Optional<CowFaceModel> hybris = cowFaceDao.getForCode("hybris")
        Optional<CowFaceModel> borg = cowFaceDao.getForCode("borg")

        then:
        hybris.isPresent()
        !borg.isPresent()
    }
}

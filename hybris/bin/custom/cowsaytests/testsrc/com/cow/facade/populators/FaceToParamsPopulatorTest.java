package com.cow.facade.populators;

import com.cow.data.CowParams;
import com.cow.model.CowFaceModel;
import de.hybris.bootstrap.annotations.UnitTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.*;

@UnitTest
public class FaceToParamsPopulatorTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    public CowFaceModel source;

    FaceToParamsPopulator populator;

    @Before
    public void setUp() throws Exception {
        when(source.getCode()).thenReturn("test");
        when(source.getEyes()).thenReturn("yy");
        when(source.getTongue()).thenReturn("UU");
        when(source.getThink()).thenReturn(true);

        populator = new FaceToParamsPopulator();
    }

    @Test
    public void test_populate() {
        CowParams target = new CowParams();

        populator.populate(source, target);

        assertThat(target.getFaceCode()).isEqualTo("test");
        assertThat(target.getEyes()).isEqualTo("yy");
        assertThat(target.getTongue()).isEqualTo("UU");
        assertThat(target.isThink()).isTrue();
    }

    @Test(expected = Test.None.class)
    public void populate_ignores_null() {
        populator.populate(null, null);
        populator.populate(null, new CowParams());
        populator.populate(source, null);

    }
}

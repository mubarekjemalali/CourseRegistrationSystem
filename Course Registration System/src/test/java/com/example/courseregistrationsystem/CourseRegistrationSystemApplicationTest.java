package com.example.courseregistrationsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.internal.InheritingConfiguration;
import org.modelmapper.internal.TypeResolvingList;
import org.modelmapper.spi.NameTokenizer;
import org.modelmapper.spi.ValueReader;
import org.modelmapper.spi.ValueWriter;

public class CourseRegistrationSystemApplicationTest {
    /**
     * Method under test: {@link CourseRegistrationSystemApplication#modelMapper()}
     */
    @Test
    public void testModelMapper() {
        ModelMapper actualModelMapperResult = (new CourseRegistrationSystemApplication()).modelMapper();
        assertTrue(actualModelMapperResult.getTypeMaps().isEmpty());
        Configuration configuration = actualModelMapperResult.getConfiguration();
        assertEquals(11, configuration.getConverters().size());
        assertNull(configuration.getPropertyCondition());
        assertEquals(Configuration.AccessLevel.PUBLIC, configuration.getFieldAccessLevel());
        NameTokenizer expectedSourceNameTokenizer = configuration.getDestinationNameTokenizer();
        assertSame(expectedSourceNameTokenizer, configuration.getSourceNameTokenizer());
        List<ValueWriter<?>> valueWriters = configuration.getValueWriters();
        assertTrue(valueWriters instanceof TypeResolvingList);
        List<ValueReader<?>> valueReaders = configuration.getValueReaders();
        assertTrue(valueReaders instanceof TypeResolvingList);
        assertEquals(Configuration.AccessLevel.PUBLIC, configuration.getMethodAccessLevel());
        assertSame(valueReaders, ((InheritingConfiguration) configuration).valueAccessStore.getValueReaders());
        assertSame(valueWriters, ((InheritingConfiguration) configuration).valueMutateStore.getValueWriters());
    }
}


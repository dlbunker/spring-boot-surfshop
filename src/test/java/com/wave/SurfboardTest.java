package com.wave;

import com.wave.controllers.SurfboardController;
import com.wave.models.Surfboard;
import com.wave.repositories.SurfboardRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class SurfboardTest {

    @InjectMocks
    private SurfboardController sc;

    @Mock
    private SurfboardRepository surfboardRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSurfboardList() {
        Surfboard s = new Surfboard();
        s.setId(1l);
        List<Surfboard> mockBoards = new ArrayList<>();
        mockBoards.add(s);
        Mockito.when(surfboardRepository.findAll()).thenReturn(mockBoards);

        List<Surfboard> boards = sc.list();
        Assert.assertNotNull(boards);
    }

}

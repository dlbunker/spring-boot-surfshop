package com.wave;

import com.wave.models.Surfboard;
import com.wave.repositories.SurfboardRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurfboardIntegrationTest {
    @Autowired
    private SurfboardRepository surfboardRepository;

    @Test
    public void testRepo() {
        List<Surfboard> boards = surfboardRepository.findAll();
        Assert.assertThat(boards.size(), Matchers.is(Matchers.greaterThanOrEqualTo(0)));
    }

}

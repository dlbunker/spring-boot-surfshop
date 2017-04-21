package com.wave;

import com.wave.models.Surfboard;
import com.wave.repositories.SurfboardRepository;
import com.wave.util.Calculator;
import com.wave.util.WaxCalculator;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurfshopApplicationTests {
	@Autowired
//	@Qualifier("wax")
	private Calculator waxCalc;

	@Autowired
	private SurfboardRepository surfboardRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void waxTest() {
		String waxType = waxCalc.getWax(72);
		Assert.assertEquals("Warm", waxType);
	}

	@Test
	public void createSurfboard() {
		Surfboard s = new Surfboard();
		s.setBrand("Hobie");
		s.setModel("Colin Noserider");
		s.setMsrp(new BigDecimal(1099));
		s = surfboardRepository.save(s);
		Assert.assertNotNull(s.getId());
	}

}

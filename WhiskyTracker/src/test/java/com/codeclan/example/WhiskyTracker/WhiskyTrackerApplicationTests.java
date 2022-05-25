package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllWhiskysForAGivenYear(){
		List<Whisky> whiskeyByYear= whiskyRepository.findAllByYear(2007);
		assertEquals(2, whiskeyByYear.size());
	}

	@Test
	public void canGetAllDistilleriesFromGivenRegion(){
		List<Distillery> distilleriesByRegion = distilleryRepository.findAllByRegion("Lowland");
		assertEquals("Rosebank", distilleriesByRegion.get(0).getName());
	}

	@Test
	public void canGetWhiskysFromDistilleryOfGivenAge(){
		List<Whisky> whiskies = whiskyRepository.findByDistilleryNameAndAge("Glendronach", 15);
		assertEquals("The Glendronach Revival", whiskies.get(0).getName());
	}

	@Test
	public void canGetWhiskyFromAParticularRegion(){
		List<Whisky> whiskies = whiskyRepository.findAllByDistilleryRegion("Highland");
		assertEquals(7, whiskies.size());
	}

	@Test
	public void canGetDistilleriesThatHaveWhiskysOfCertainAge(){
		List<Distillery> distilleries = distilleryRepository.findAllByWhiskiesAge(12);
		assertEquals(6, distilleries.size());
	}

}

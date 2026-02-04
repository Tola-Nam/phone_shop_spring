package com.tola.dev.phoneShope;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@SpringBootTest(properties = {"app.cors.allowed-origins=http://localhost:4200"})
class PhoneShopeApplicationTests {

	@Test
	void contextLoads() {
	}

}

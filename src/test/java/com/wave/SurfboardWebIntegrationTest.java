package com.wave;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wave.models.Surfboard;
import com.wave.repositories.SurfboardRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurfboardWebIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${security.user.name}")
    private String username;

    @Value("${security.user.password}")
    private String pass;

    @Test
    public void testList() throws IOException {
        ResponseEntity<String> response = restTemplate.withBasicAuth(username, pass).getForEntity("/api/v1/surfboards", String.class);

        Assert.assertThat( response.getStatusCode() , Matchers.equalTo(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());

        Assert.assertThat( responseJson.isMissingNode() , Matchers.is(false) );
        Assert.assertThat( responseJson.toString() , Matchers.equalTo("[]") );

    }

}

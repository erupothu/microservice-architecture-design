package com.example.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.example.student.client.LibraryClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import wiremock.org.apache.commons.io.IOUtils;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9091)
class StudentApplicationTests {

	@Autowired
	LibraryClient libraryClient;

	@Test
	void contextLoads() {
	}

	@Test
    public void getAllPosts_whenValidClient_returnValidResponse() throws Exception {
        // Using WireMock to mock client API:

        String posts = libraryClient.echoLibrary().getBody();

		assertEquals(posts, "");
    }

}

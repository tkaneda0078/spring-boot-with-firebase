package com.example.demo.domain.services;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {
	@PostConstruct
	public void initialize() throws IOException {
		FileInputStream serviceAccount = new FileInputStream(
				"src/main/java/com/example/demo/domain/config/service_account_pk.json");

		FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://spring-boot-with-firebase.firebaseio.com/")
				.build();

		if (FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(firebaseOptions);
		}
	}
}

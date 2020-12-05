package com.example.demo.domain.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class UserService {
	public List<QueryDocumentSnapshot> getAll() throws InterruptedException, ExecutionException {
		// TODO: 親クラス作成する
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> query = db.collection("users").get();

		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			System.out.println(document.getId());
			System.out.println(document.getString("firstName"));
			System.out.println(document.getString("lastName"));
		}

		return documents;
	}
}

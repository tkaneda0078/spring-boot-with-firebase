package com.example.demo.domain.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@Service
public class UserService extends FirebaseService {
	public List<QueryDocumentSnapshot> getAll() throws InterruptedException, ExecutionException {
		ApiFuture<QuerySnapshot> collection = this.getFirestoreCollectionBy("users");

		QuerySnapshot querySnapshot = collection.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			System.out.println(document.getId());
			System.out.println(document.getString("firstName"));
			System.out.println(document.getString("lastName"));
		}

		return documents;
	}
}

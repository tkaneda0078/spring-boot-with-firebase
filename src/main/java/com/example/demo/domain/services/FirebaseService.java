package com.example.demo.domain.services;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
	private Firestore firestore;

	public FirebaseService() {
		this.firestore = FirestoreClient.getFirestore();
	}

	/**
	 * @param String collectionName
	 * @return ApiFuture<QuerySnapshot> collection
	 */
	public ApiFuture<QuerySnapshot> getFirestoreCollectionBy(String collectionName) {
		return this.firestore.collection(collectionName).get();
	}
}

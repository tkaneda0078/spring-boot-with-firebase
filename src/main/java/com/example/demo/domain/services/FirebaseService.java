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
public class FirebaseService {
	private Firestore firestore;

	public FirebaseService() {
		this.firestore = FirestoreClient.getFirestore();
	}

	/**
	 * @param collectionName
	 * @return collection
	 */
	public ApiFuture<QuerySnapshot> getFirestoreCollectionBy(String collectionName) {
		return this.firestore.collection(collectionName).get();
	}

	/**
	 * @param collection
	 * @return document
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public List<QueryDocumentSnapshot> getFirestoreDocuments(ApiFuture<QuerySnapshot> collection)
			throws InterruptedException, ExecutionException {
		QuerySnapshot querySnapshot = collection.get();

		return querySnapshot.getDocuments();
	}
}

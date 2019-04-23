package com.fastiel.croupierchallenge.managers

import android.util.Log
import com.fastiel.croupierchallenge.model.User
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseManager {
    const val USERS_DB = "users"


    fun createUser(userData: User, someId: String) {

        val db = FirebaseFirestore.getInstance()

        db.collection(USERS_DB).document(someId).set(userData)
            .addOnFailureListener {
                Log.e("firestore", "Error uploading document")
            }
    }
}
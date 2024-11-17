package com.geekymusketeers.medify.ui.auth.signInScreen

import com.geekymusketeers.medify.model.Doctor
import com.geekymusketeers.medify.model.User
import com.geekymusketeers.medify.utils.Logger
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await


class SignInRepository {
    suspend fun loginUser(email: String, password: String): User? {
        /*return try {
            val authResult = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
            authResult.user
        } catch (e: FirebaseAuthInvalidUserException) {
            null // Return null if the user is not registered
        } catch (e: Exception) {
            null
        }*/
        Logger.debugLog("Current Email: $email")
        return User(
            Name = "test",
            Email = email,
            Phone = "123-456-7890",
            UID = "12345",
            isDoctor = Doctor.IS_NOT_DOCTOR.toItemString(),
            Age = 30,
            Gender = "Prefer not to say",
            Address = "123 Mock Street, Faketown",
            Specialist = null,
            Stats = "0:0:0:0:0?0:0:0:0:0?0:0:0:0:0?0:0:0:0:0",
            Prescription = "None",
            totalRating = 5F,
            ratings = emptyList()
        )
    }
}
package com.fastiel.croupierchallenge.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fastiel.croupierchallenge.R
import com.fastiel.croupierchallenge.main.MainActivity
import com.fastiel.croupierchallenge.managers.FirebaseManager
import com.fastiel.croupierchallenge.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.signup_frag.*

class SignUpFragment :Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      val view = inflater.inflate(R.layout.signup_frag, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        signUpBtn.setOnClickListener {
            createUser(emailField.text.toString(), signupPasswordField.text.toString())
        }
    }

    fun createUser(email: String, password: String){
        if (password != repeatPasswordField.text.toString()){return}

        val activity = activity ?:return
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser ?:return@addOnCompleteListener

                    val user1 = User(countryEditText.text.toString(), emailField.text.toString(), nickNameEditText.text.toString())
                    FirebaseManager.createUser(user1,user.uid)
                    Toast.makeText(activity, "user created", Toast.LENGTH_LONG).show()

                    goToLandingActivity()

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("1", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun goToLandingActivity(){
        val activity = activity ?:return
        val loginIntent = Intent(context, MainActivity::class.java)
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        activity.finish()
        startActivity(loginIntent)
    }
}
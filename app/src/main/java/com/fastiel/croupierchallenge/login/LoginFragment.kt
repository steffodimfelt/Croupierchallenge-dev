package com.fastiel.croupierchallenge.login

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fastiel.croupierchallenge.R
import com.fastiel.croupierchallenge.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()
        val activity = activity ?:return

        createUserBtn.setOnClickListener {

            val fragmentManager = activity.supportFragmentManager ?: return@setOnClickListener
            val signUpFrag = SignUpFragment()
            val trans = fragmentManager.beginTransaction()
            trans.replace(R.id.LoginFrame, signUpFrag).addToBackStack(null).commit()
        }
        loginBtn.setOnClickListener {
            signIn(emailField.text.toString(), passwordField.text.toString(), activity)
        }
    }

    fun signIn(email:String, password:String, activity: FragmentActivity){
        if (email == "" || password == "" ){showDialog(); return}
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser

                    val loginIntent = Intent(context, MainActivity::class.java)
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    activity.finish()
                    startActivity(loginIntent)

                } else {
                    //sign in failed, message
                    Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()

                }
            }
    }

    fun showDialog(){
        val context = getContext() ?: return
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle("Alert")
        alertDialog.setMessage("Missing data in log in form")
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
        alertDialog.show()
    }
}
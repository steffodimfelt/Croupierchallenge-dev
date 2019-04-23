package com.fastiel.croupierchallenge.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fastiel.croupierchallenge.R
import com.fastiel.croupierchallenge.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val actionBar = supportActionBar ?: return
        actionBar.hide()

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null){
            val loginIntent = Intent(this, MainActivity::class.java)
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
            startActivity(loginIntent)
        }
        val fragMan = supportFragmentManager ?: return
        val splashFragment = SplashFragment()
        val trans = fragMan.beginTransaction()
        trans.replace(R.id.LoginFrame, splashFragment).addToBackStack(null).commit()
    }

}

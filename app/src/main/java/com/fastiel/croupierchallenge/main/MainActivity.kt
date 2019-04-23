package com.fastiel.croupierchallenge.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fastiel.croupierchallenge.R
import com.fastiel.croupierchallenge.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        val frag = HomeFragment()
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.mainFrame, frag).commit()

        bottomNav.setOnNavigationItemSelectedListener {
            val fragment =
                when (it.itemId) {
                    R.id.action_home -> HomeFragment()
                    R.id.action_practice -> PracticeChoiceFrag()
                else -> null
            }

            if (fragment != null) {
                supportFragmentManager.popBackStackImmediate()
                val trans1 = supportFragmentManager.beginTransaction()
                trans1.replace(R.id.mainFrame, fragment).addToBackStack(null).commit()
            }
            fragment != null
        }
    }

    override fun onResume() {
        super.onResume()
        checkLogIn()

    }

    fun checkLogIn(){
        if (auth.currentUser == null){
            val loginIntent = Intent(this, LoginActivity::class.java)
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
            startActivity(loginIntent)
        }
    }
}
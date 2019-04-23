package com.fastiel.croupierchallenge.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fastiel.croupierchallenge.R
import com.fastiel.croupierchallenge.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()

        signOutBtn.setOnClickListener {
            auth.signOut()
            val activity = activity ?: return@setOnClickListener
            val logOutIntent = Intent(activity, LoginActivity::class.java)
            logOutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            activity.finish()
            startActivity(logOutIntent)

        }
    }
}
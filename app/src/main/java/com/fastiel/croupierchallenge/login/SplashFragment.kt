package com.fastiel.croupierchallenge.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fastiel.croupierchallenge.R
import com.fastiel.croupierchallenge.main.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.splash.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {
    lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.splash, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        startProgress()
    }

    fun startProgress() {
        //launching coroutine in the main UI context,
        //UI is not frozen while delay waits
        GlobalScope.launch(Dispatchers.Main) {
            for (i in 0..100) {
                progressBar.setProgress(i)
                splashTitle.text = "$i %" // update text
                delay(30)
            }
            splashTitle.text = "Done"
            checkUser()
        }
    }


    fun checkUser() {
        if (auth.currentUser == null) {
            val fragMan = fragmentManager ?: return
            val frag = LoginFragment()
            val trans = fragMan.beginTransaction()
            trans.replace(R.id.LoginFrame, frag).commit()
        } else {
            val activity = activity ?: return
            val loginIntent = Intent(activity, MainActivity::class.java)
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            activity.finish()
            startActivity(loginIntent)
        }
    }
}
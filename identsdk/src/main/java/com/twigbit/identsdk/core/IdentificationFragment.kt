package com.twigbit.identsdk.core

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class IdentificationFragment : androidx.fragment.app.Fragment() {
    var identificationManager = IdentificationManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.let { identificationManager.bind(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        context?.let { identificationManager.unBind(it) }
    }

    override fun onStart() {
        super.onStart()
//        context?.let { identificationManager.bind(it) }
    }

    override fun onStop() {
        super.onStop()
//        context?.let { identificationManager.unBind(it) }
    }

    companion object {
        val TAG = "com.twigbit.identsdk.core.IdentificationFragment"

        fun newInstance(activity: AppCompatActivity): IdentificationFragment {
            // try to get the fragment instance if it is already attached
            val fm = activity.supportFragmentManager
            var identificationFragment: IdentificationFragment? = fm.findFragmentByTag(TAG) as IdentificationFragment?
            if (identificationFragment == null) {
                identificationFragment = IdentificationFragment()
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        try {
                            fm.beginTransaction().add(identificationFragment, TAG).commitNow()
                        } catch (e: IllegalStateException) {
                            fm.beginTransaction().add(identificationFragment, TAG).commit()
                            try {
                                fm.executePendingTransactions()
                            } catch (ignored: IllegalStateException) {
                            }

                        } catch (e: NullPointerException) {
                            fm.beginTransaction().add(identificationFragment, TAG).commit()
                            try {
                                fm.executePendingTransactions()
                            } catch (ignored: IllegalStateException) {
                            }
                        }

                    } else {
                        fm.beginTransaction().add(identificationFragment, TAG).commit()
                        try {
                            fm.executePendingTransactions()
                        } catch (ignored: IllegalStateException) {
                        }

                    }
                } catch (e: IllegalStateException) {
                    throw Exception(e.message)
                }

            }
            return identificationFragment
        }
    }
}
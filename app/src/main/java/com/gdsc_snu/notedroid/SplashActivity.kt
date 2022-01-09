/*
 * Copyright (C) 2022 Google Developer Student Clubs SNU
 *
 * Licensed under the BSD 3-Clause "New" or "Revised" License;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://opensource.org/licenses/BSD-3-Clause
 *
 *  A permissive license similar to the BSD 2-Clause License, but with a 3rd clause
 *  that prohibits others from using the name of the project or its contributors to
 *  to promote derived products without written consent.
 *
 */

package com.gdsc_snu.notedroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
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

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.main_container)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.noteFragment, R.id.importantNoteFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
    }
}
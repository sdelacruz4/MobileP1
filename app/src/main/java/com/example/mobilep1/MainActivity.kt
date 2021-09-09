package com.example.mobilep1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.*
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var three1button: Button
    private lateinit var three2button: Button
    private lateinit var two1button: Button
    private lateinit var two2button: Button
    private lateinit var free1button: Button
    private lateinit var free2button: Button
    private lateinit var resetbutton: Button

    private var teamAScore: Int = 0;
    private var teamBScore: Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Three point button creation and onclick
        three1button = findViewById(R.id.three1_button) as Button

        three1button.setOnClickListener { v ->
            threePointHandler("A")
        }

        three2button = findViewById(R.id.three2_button) as Button

        three2button.setOnClickListener { v ->
            threePointHandler("B")
        }


        //Two point button creation and onclick
        two1button = findViewById(R.id.two1_button) as Button

        two1button.setOnClickListener { v ->
            twoPointHandler("A")
        }

        two2button = findViewById(R.id.two2_button) as Button

        two2button.setOnClickListener { v ->
            twoPointHandler("B")
        }


        //Free Throw button creation and onclick
        free1button = findViewById(R.id.free1_button) as Button

        free1button.setOnClickListener { v ->
            onePointHandler("A")
        }

        free2button = findViewById(R.id.free2_button) as Button

        free2button.setOnClickListener { v ->
            onePointHandler("A")
        }

        //Reset button creation and onclick
        resetbutton = findViewById(R.id.reset_button) as Button

        resetbutton.setOnClickListener { v ->
            resetButtonHandler();
        }

    }

    private fun threePointHandler(team: String) {
        if (team === "A") {
            //call function to display points
            teamAScore = teamAScore +3
            displayA(teamAScore)
        } else if (team === "B") {
            //call function to display points
            teamBScore = teamBScore +3
            displayB(teamBScore)
        } else {
            Log.e("Team Error", "An invalid team was used")
        }

    }

    private fun twoPointHandler(team: String) {
        if (team === "A") {
            //call function to display points
            teamAScore = teamAScore +2
            displayA(teamAScore)
        } else if (team === "B") {
            //call function to display points
            teamBScore = teamBScore +2
            displayB(teamBScore)
        } else {
            Log.e("Team Error", "An invalid team was used")
        }

    }

    private fun onePointHandler(team: String) {
        if (team === "A") {
            //call function to display points
            teamAScore = teamAScore +1
            displayA(teamAScore)
        } else if (team === "B") {
            //call function to display points
            teamBScore = teamBScore +1
            displayB(teamBScore)
        } else {
            Log.e("Team Error", "An invalid team was used")
        }

    }

    private fun resetButtonHandler() {
        teamAScore = 0;
        teamBScore = 0;
        displayA(teamAScore)
        displayB(teamBScore)
    }

    private fun displayA(score: Int){
        var scoreViewModel: TextView = findViewById(R.id.scoreA) as TextView
        scoreViewModel.setText(score.toString())

    }

    private fun displayB(score: Int){
        var scoreViewModel: TextView = findViewById(R.id.scoreB) as TextView
        scoreViewModel.setText(score.toString())
    }
}
package com.example.mobilep1


import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider



class MainActivity : AppCompatActivity() {
    private lateinit var three1button: Button
    private lateinit var three2button: Button
    private lateinit var two1button: Button
    private lateinit var two2button: Button
    private lateinit var free1button: Button
    private lateinit var free2button: Button
    private lateinit var resetbutton: Button

    private lateinit var viewModel: ScoreView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ScoreView::class.java)

        //Three point button creation and onclick
        three1button = findViewById<Button>(R.id.three1_button)

        three1button.setOnClickListener { v ->
            threePointHandler("A")
        }

        three2button = findViewById<Button>(R.id.three2_button)

        three2button.setOnClickListener { v ->
            threePointHandler("B")
        }


        //Two point button creation and onclick
        two1button = findViewById<Button>(R.id.two1_button)

        two1button.setOnClickListener { v ->
            twoPointHandler("A")
        }

        two2button = findViewById<Button>(R.id.two2_button)

        two2button.setOnClickListener { v ->
            twoPointHandler("B")
        }


        //Free Throw button creation and onclick
        free1button = findViewById<Button>(R.id.free1_button)

        free1button.setOnClickListener { v ->
            onePointHandler("A")
        }

        free2button = findViewById<Button>(R.id.free2_button)

        free2button.setOnClickListener { v ->
            onePointHandler("B")
        }

        //Reset button creation and onclick
        resetbutton = findViewById<Button>(R.id.reset_button)

        resetbutton.setOnClickListener { v ->
            resetButtonHandler()
        }


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        displayA()
        displayB()
    }

    private fun threePointHandler(team: String) {
        if (team === "A") {
            //call function to display points
            viewModel.updateTeamAScore(3)
            displayA()
        } else if (team === "B") {
            //call function to display points
            viewModel.updateTeamBScore(3)
            displayB()
        } else {
            Log.e("Team Error", "An invalid team was used")
        }

    }

    private fun twoPointHandler(team: String) {
        if (team === "A") {
            //call function to display points
            viewModel.updateTeamAScore(2)
            displayA()
        } else if (team === "B") {
            //call function to display points
            viewModel.updateTeamBScore(2)
            displayB()
        } else {
            Log.e("Team Error", "An invalid team was used")
        }

    }

    private fun onePointHandler(team: String) {
        if (team === "A") {
            //call function to display points
            viewModel.updateTeamAScore(1)
            displayA()
        } else if (team === "B") {
            //call function to display points
            viewModel.updateTeamBScore(1)
            displayB()
        } else {
            Log.e("Team Error", "An invalid team was used")
        }

    }

    private fun resetButtonHandler() {
        viewModel.resetScores()
        displayA()
        displayB()
    }

    private fun displayA(){
        val scoreViewModel: TextView = findViewById<TextView>(R.id.scoreA)
        scoreViewModel.text = viewModel.getTeamAScore().toString()

    }

    private fun displayB(){
        val scoreViewModel: TextView = findViewById<TextView>(R.id.scoreB)
        scoreViewModel.text = viewModel.getTeamBScore().toString()
    }
}
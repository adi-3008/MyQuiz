package com.example.myquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private var tvUserName: TextView? = null
    private var tvScore: TextView? = null
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0
    private var btnFinish: Button? = null
    private var mTotalQuestion: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        mUserName = intent.getStringExtra(Constant.USER_NAME)
        mCorrectAnswers = intent.getIntExtra(Constant.CORRECT_ANSWERS, 0)
        mTotalQuestion = intent.getIntExtra(Constant.TOTAL_QUESTION, 0)

        btnFinish = findViewById(R.id.btnFinish)
        tvUserName = findViewById(R.id.tvUserName)
        tvScore = findViewById(R.id.tvScore)

        tvUserName?.text = mUserName
        tvScore?.text = "Your Score is ${mCorrectAnswers} out of ${mTotalQuestion}"

        btnFinish?.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
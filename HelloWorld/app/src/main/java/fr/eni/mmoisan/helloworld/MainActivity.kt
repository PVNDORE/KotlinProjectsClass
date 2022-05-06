package fr.eni.mmoisan.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.switchmaterial.SwitchMaterial
import fr.eni.mmoisan.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val q1 = QuestionAnswer("Epik High is here ?", true)
        val q2 = QuestionAnswer("Swervy is here ?", false)
        val q3 = QuestionAnswer("Giriboy is here ?", true)

        var index = 0

        val qList = listOf<QuestionAnswer>(q1, q2, q3)

        vb.tvQuestion.text = qList.get(index).question


        vb.btnTrue.setOnClickListener {
            if (q1.correctAnswer(true)) {
                vb.tvPoints.text = "1"
            }

            nextQuestion(vb, q2)

        }
    }

    private fun nextQuestion(activity: ActivityMainBinding, myQuestionAnswer: QuestionAnswer) {
        activity.tvQuestion.text = myQuestionAnswer.question
    }
}

data class QuestionAnswer(val question : String, val answer: Boolean) {

    fun correctAnswer(userAnswer: Boolean): Boolean {
        return this.answer == userAnswer
    }
}
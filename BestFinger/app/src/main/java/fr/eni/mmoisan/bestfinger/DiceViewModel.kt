package fr.eni.mmoisan.bestfinger

import android.media.Image
import android.text.Html
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel: ViewModel() {

    var totalLaunch = MutableLiveData(0);
    var leftLaunch = 0
    var rightLaunch = 0

    var leftScore = 0
    var rightScore = 0

    var imgDice = R.drawable.dice1

    fun rightPlusOne() {
        rightLaunch ++
        rightScore += launchDice()
    }

    fun leftPlusOne() {
        leftLaunch ++
        leftScore += launchDice()
    }

    fun launchDice(): Int {
        totalLaunch.value = totalLaunch.value?.plus(1)
        var diceScore = (1..6).random()
        getImg(diceScore)
        return diceScore
    }

    fun getImg(index: Int) {
        imgDice = when(index) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
    }
}
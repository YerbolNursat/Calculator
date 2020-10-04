package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var result = ""
    private var actions = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {

        button_division.setOnClickListener {
            try {
                if (result.last() != '/' && result.last() != '*' && result.last() != '+' && result.last() != '-') {
                    result += "/"
                    actions += "/"
                    setData()
                }

            } catch (e: Exception) {
            }
        }

        button_multiplication.setOnClickListener {
            try {
                if (result.last() != '/' && result.last() != '*' && result.last() != '+' && result.last() != '-') {
                    result += "*"
                    actions += "*"
                    setData()

                }
            } catch (e: Exception) {
            }
        }

        button_subtraction.setOnClickListener {
            try {
                if (result.last() != '/' && result.last() != '*' && result.last() != '+' && result.last() != '-') {
                    result += "-"
                    actions += "-"
                    setData()
                }

            } catch (e: Exception) {
            }
        }
        button_addition.setOnClickListener {
            try {
                if (result.last() != '/' && result.last() != '*' && result.last() != '+' && result.last() != '-') {
                    result += "+"
                    actions += "+"
                    setData()
                }

            } catch (e: Exception) {
            }
        }

        button_clear.setOnClickListener {
            result = ""
            actions = ""
            setData()
        }

        button_seven.setOnClickListener {
            result += "7"
            setData()
        }
        button_eight.setOnClickListener {
            result += "8"
            setData()
        }
        button_nine.setOnClickListener {
            result += "9"
            setData()
        }

        button_four.setOnClickListener {
            result += "4"
            setData()
        }
        button_five.setOnClickListener {
            result += "5"
            setData()
        }
        button_six.setOnClickListener {
            result += "6"
            setData()
        }

        button_one.setOnClickListener {
            result += "1"
            setData()
        }
        button_two.setOnClickListener {
            result += "2"
            setData()
        }
        button_three.setOnClickListener {
            result += "3"
            setData()
        }

        button_zero.setOnClickListener {
            result += "0"
            setData()
        }
        button_equal.setOnClickListener {
            getResult()
            actions = ""
            setData()

        }

    }

    private fun getResult() {
        var answer = 0
        result.split("*", "/", "+", "-").forEachIndexed { i, it ->
            if (answer == 0) {
                answer = it.toInt()
            }
            try {


                when (actions.split("")[i]) {
                    "*" -> {
                        answer *= it.toInt()
                    }
                    "/" -> {
                        answer /= it.toInt()
                    }
                    "+" -> {
                        answer += it.toInt()
                    }
                    "-" -> {
                        answer -= it.toInt()
                    }
                }
            } catch (e: Exception) {

            }
        }
        result = answer.toString()
    }


    private fun setData() {
        textView_input_numbers.text = result
    }

}
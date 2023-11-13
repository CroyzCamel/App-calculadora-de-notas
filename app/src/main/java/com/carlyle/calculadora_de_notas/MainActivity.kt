package com.carlyle.calculadora_de_notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlyle.calculadora_de_notas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btCalculate.setOnClickListener {
            val num1 = binding.note1.text
            val num2 = binding.note2.text
            val num3 = binding.note3.text
            val num4 = binding.note4.text
            val absences = binding.numberAbsences.text
            val result = binding.txtResult

            val number1 = Integer.parseInt(num1.toString())
            val number2 = Integer.parseInt(num2.toString())
            val number3 = Integer.parseInt(num3.toString())
            val number4 = Integer.parseInt(num4.toString())
            val numberAbsences = Integer.parseInt(absences.toString())

            val average = (number1 + number2 + number3 + number4) / 4

            if (average >= 5 && numberAbsences <= 20) {
                result.setText("Aluno aprovado \n Média final $average")
                result.setTextColor(getColor(R.color.green))
            } else if (numberAbsences > 20) {
                result.setText("Aluno reprovado por faltas \n número de faltas: $numberAbsences " +
                        "\n (faltas mínimas: 20)")
                result.setTextColor(getColor(R.color.red))
            } else if (average < 5) {
                result.setText("Aluno reprovado por nota \n média: $average")
                result.setTextColor(getColor(R.color.red))
            }
        }
    }
}
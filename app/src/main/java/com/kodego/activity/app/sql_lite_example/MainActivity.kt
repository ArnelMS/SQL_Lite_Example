package com.kodego.activity.app.sql_lite_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Toast
import com.kodego.activity.app.sql_lite_example.databinding.ActivityMainBinding
import java.time.DayOfWeek

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSave.setOnClickListener(){
            lateinit var employeeModel: EmployeeModel
            try{
                var name = binding.etName.text.toString()
                var salary = binding.etSalary.text.toString().toInt()

                employeeModel = EmployeeModel(-1,name, salary)

                var databaseHelper = DatabaseHelper(applicationContext)
                databaseHelper.addOne(employeeModel)
                Toast.makeText(applicationContext,"Success!",Toast.LENGTH_SHORT).show()
            }catch (e: Exception) {
                Toast.makeText(applicationContext, "Error Occurred!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnView.setOnClickListener(){
            var databaseHelper = DatabaseHelper(applicationContext)
            var everyEmployee : List<EmployeeModel> = databaseHelper.getAllData()
            Toast.makeText(applicationContext,everyEmployee.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}
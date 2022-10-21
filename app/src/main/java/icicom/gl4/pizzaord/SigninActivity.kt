package icicom.gl4.pizzaord

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SigninActivity : AppCompatActivity() {

    lateinit var txtEmail : EditText
    lateinit var txtFirstName : EditText
    lateinit var txtLastName : EditText
    lateinit var btnSignin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        btnSignin = findViewById(R.id.btnsignin)
        btnSignin.setOnClickListener { view ->
            txtFirstName = findViewById(R.id.firstname)
            var firstName = txtFirstName.text
            txtLastName = findViewById(R.id.lastname)
            var lastName = txtLastName.text
            txtEmail = findViewById(R.id.email)
            var email = txtEmail.text
            if(email.isNullOrBlank() || firstName.isNullOrBlank()|| lastName.isNullOrBlank()){
                Toast.makeText(this,"Please fill is the required fields !! ", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, email.toString()+", "+firstName.toString()+", "+lastName.toString(), Toast.LENGTH_LONG).show()
                val intent = Intent(view.context,MainActivity::class.java)
                intent.putExtra("credientials",email.toString()+","+firstName.toString()+","+lastName.toString())
                startActivity(intent)
            }
        }
    }
}
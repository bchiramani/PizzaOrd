package icicom.gl4.pizzaord

import android.content.Intent
import android.net.Uri
import android.net.Uri.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import icicom.gl4.pizzaord.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private var orderCredentials: String="";
    private var orderSize: String="";
    private var orderSupp:String="";
     var order :String="";
    private var price:Int=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.orderCredentials = intent.getStringExtra("credientials").toString()

        val radioGroup=findViewById<RadioGroup>(R.id.radioGroup);

        val cheese = findViewById<CheckBox>(R.id.cheese)
        val mushroom = findViewById<CheckBox>(R.id.mushroom)
        val fries = findViewById<CheckBox>(R.id.fries)

        val buttonOrder=findViewById<Button>(R.id.buttonOrder)
        buttonOrder.setOnClickListener(View.OnClickListener{

            val selectedBtn:Int=radioGroup!!.checkedRadioButtonId
            val btnChecked =findViewById<RadioButton>(selectedBtn)


            this.orderSize+=btnChecked.text;
            if(this.orderSize=="Small(12dt)"){
                this.price+=12
            }else if(this.orderSize=="Medium(15dt)"){
                this.price+=15
            }else if(this.orderSize=="Large(18dt)"){
                this.price+=18
            }


            if(cheese.isChecked){
                this.orderSupp+=" Cheese "
                this.price+=4
            }
            if(mushroom.isChecked){
                this.orderSupp+=" Mushroom "
                this.price+=2
            }
            if(fries.isChecked){
                this.orderSupp+=" Fries "
                this.price+=3
            }
            this.order="Client credentials : "+this.orderCredentials+"\n"
            this.order+="Pizza size : "+this.orderSize+"\n";
            if (this.orderSupp!=""){
                this.order+="Suppliments: "+this.orderSupp+"\n"
            }
            this.order+="Pizza price : "+this.price+" dt \n";



            val intent = Intent(Intent.ACTION_SEND)
            intent.data=Uri.parse("Mail to :")
            intent.type="text/plain"

            intent.putExtra(Intent.EXTRA_EMAIL,arrayOf("amanibchir07@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT,"Pizza Order".trim())
            intent.putExtra(Intent.EXTRA_TEXT,order.trim())

            startActivity(Intent.createChooser(intent,"choose email client"))

            this.order=""
            this.orderSupp=""
            this.orderSize=""
            //this.orderCredentials=""

        })

    }
}
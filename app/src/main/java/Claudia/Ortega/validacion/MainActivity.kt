package Claudia.Ortega.validacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1.Mandar a llamar a todos los elementos
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreoElectronico)
        val txtContrasena= findViewById<EditText>(R.id.txtContraseña)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtDui = findViewById<EditText>(R.id.txtDUI)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        //2.Programamos el boton
        btnIngresar.setOnClickListener {
            //Validamos que los campos no esten vacios
        if(txtNombre.text.isEmpty()  ||  txtCorreo.text.isEmpty()
            || txtContrasena.text.isEmpty()  || txtEdad.text.isEmpty()
            ||txtDui.text.isEmpty()
            ){
            Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show()
        }else {
            if (!txtEdad.text.matches("[0-9]+".toRegex())){
                Toast.makeText(this, "Ingrese numeros", Toast.LENGTH_SHORT).show()
            }else{
                //Validad correo electronico
                if(!txtCorreo.text.matches("[a-zA-Z0-9.-_]@[a-z]+\\.+[a-z]+".toRegex())){
                    Toast.makeText(this, "Ingrese correo valido", Toast.LENGTH_SHORT).show()}
                else{
                    //Validar que la contraseña tenga minimo 6 caracteres
                    if (txtContrasena.text.length < 8 || txtContrasena.text.matches("[0-9]+".toRegex())){
                        Toast.makeText(this, "La clave debe contener mas de 6 digitos", Toast.LENGTH_SHORT).show()
                }else{
                    //Validar el Dui con 9 numeros y un guion//
                    if(txtDui.text.length == 10 || txtDui.text.matches("[0-9]+-[0-9]".toRegex()) )
                        Toast.makeText(this, "Ingrese su Dui", Toast.LENGTH_SHORT).show()
                    }
                }
            }
         }
        }
    }

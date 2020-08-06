package zw.co.guava.soterio.ui.onboarding.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_verify_personal_details.*
import zw.co.guava.soterio.R

class VerifyPersonalDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_personal_details)

        nextButton.setOnClickListener {
            val intent = Intent(baseContext, VerifyAddress::class.java)
            startActivity(intent)
        }
    }
}
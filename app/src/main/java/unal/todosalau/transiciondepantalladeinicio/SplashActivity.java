package unal.todosalau.transiciondepantalladeinicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

private static final int SPLASH_TIME_OUT = 3000; // Tiempo de espera en milisegundos

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    ImageView logo = findViewById(R.id.imageViewLogo);
    Animation fadeIn = new AlphaAnimation(0, 1);
    fadeIn.setDuration(2000);
    logo.startAnimation(fadeIn);

    logo.postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }, SPLASH_TIME_OUT);
}

@Override
protected void onDestroy() {
    super.onDestroy();
    // Limpia cualquier cola pendiente de Runnable para evitar pérdidas de memoria
    ImageView logo = findViewById(R.id.imageViewLogo);
    logo.removeCallbacks(null);
}
}
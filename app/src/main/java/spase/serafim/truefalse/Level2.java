package spase.serafim.truefalse;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; // переменная для левой картинки + текст
    public int numRight; // переменная для правой картинки + текст
    Array array = new Array(); // Создали новый обьект из класса Array
    Random random = new Random(); // Для генерации случайных чисел
    public int count = 0; // Счётчик правильных ответов

    TextView button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        // создаём переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level_2);

        // код который скруглит углы картинки начало
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        // путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);
        // путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);
        // код который скруглит углы картинки конец

        // развернуть игру на весь экран начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // развернуть игру на всесь экран конец

        // Вызов диалогового окна в начале игры
        dialog = new Dialog(this); // Создаём новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок
        dialog.setContentView(R.layout.previewdialog); // путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialog.setCancelable(false); // окно нельзя закрыть кнопкой назад

        // кнопка которая закрывает диалоговое окно начало
        TextView btnClose = (TextView)dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level2.this, CameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });
        // кнопка которая закрывает диалоговое окно нконец
        // кнопка продолжить начало
        TextView btnContinue = (TextView) dialog.findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        // кнопка продолжить конец


        dialog.show();// покозать диалоговое окно

        //__________________________________________
        // Вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this); // Создаём новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend); // путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialogEnd.setCancelable(false); // окно нельзя закрыть кнопкой назад

        // кнопка которая закрывает диалоговое окно начало
        TextView btnClose2 = (TextView)dialogEnd.findViewById(R.id.btnClose);
        btnClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level2.this, CameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });
        // кнопка которая закрывает диалоговое окно нконец
        // кнопка продолжить начало
        TextView btnContinue2 = (TextView) dialogEnd.findViewById(R.id.btnContinue);
        btnContinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level2.this, CameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

                dialogEnd.dismiss();
            }
        });
        // кнопка продолжить конец

        //__________________________________________

        // кнопка назад начало
        button_back = (TextView) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level2.this, CameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });
        // кнопка назад конец

        //Массив для прогресса игры начало
        final int [] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        } ;
        //Массив для прогреса игры конец
        // Подключаем анимацию начало
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);
        // Подключаем анимацию конец

        numLeft = random.nextInt(12); //Генерируем случайное число от 0 до 11
        img_left.setImageResource(array.images2[numLeft]); // Достаём из массива картинку
        text_left.setText(array.texts2[numLeft]); // Достаём из массива текст

        numRight = random.nextInt(12);
        //Цикл с предусловиемб проверяющий равенство чисел начало
        while (numLeft == numRight){
            numRight = random.nextInt(12);
        }
        //Цикл с предусловиемб проверяющий равенство чисел конец
        img_right.setImageResource(array.images2[numRight]); // Достаём из массива картинку
        text_right.setText(array.texts2[numRight]); // Достаём из массива текст
        // Обрабатываем нажатие на левую картинку начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Условие касание картинки начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    // Если каснулся картинки ночало
                    img_right.setEnabled(false); // Блокируем правую каринку
                    if (numLeft>numRight) {
                        img_left.setImageResource(R.drawable.img_true);
                    }else {
                        img_left.setImageResource(R.drawable.img_false);
                        // Если каснулся картинки конц
                    }
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    // Если опустил палец начало
                    if (numLeft > numRight){
                        // Если левая картинка больше
                        if (count < 20) {
                            count = count+1;
                        }
                        // Закрашиваем прогрресс серым цветом начало
                        for (int i = 0; i < 20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stil_points);
                        }
                        // Закрашиваем прогрресс серым цветом конц

                        // определяем правильные ответы начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stil_points_green);
                        }
                        // определяем правильные ответы и закрашиваем зелёным конц
                    }else {
                        //Если левая картинка меньше
                        if (count > 0){
                            if (count == 1){
                                count = 0;
                            }else {
                                count = count-2;
                            }
                        }
                        // Закрашиваем прогрресс серым цветом начало
                        for (int i = 0; i < 19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stil_points);
                        }
                        // Закрашиваем прогрресс серым цветом конц

                        // определяем правильные ответы начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stil_points_green);
                        }
                        // определяем правильные ответы и закрашиваем зелёным конц

                    }
                    // Если опустил палец конец
                    if (count == 20){
                        // выход из уровня
                        //dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(12); //Генерируем случайное число от 0 до 9
                        img_left.setImageResource(array.images2[numLeft]); // Достаём из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]); // Достаём из массива текст

                        numRight = random.nextInt(12);
                        //Цикл с предусловиемб проверяющий равенство чисел начало
                        while (numLeft == numRight){
                            numRight = random.nextInt(12);
                        }
                        //Цикл с предусловиемб проверяющий равенство чисел конец
                        img_right.setImageResource(array.images2[numRight]); // Достаём из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[numRight]); // Достаём из массива текст
                        img_right.setEnabled(true); // запускаем обратно правую картинку
                    }
                }
                // Условие касание картинки конец
                return true;
            }
        });
        // Обрабатываем нажатие на левую картинку конец

        // Обрабатываем нажатие на правую картинку конец
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Условие касание картинки начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    // Если каснулся картинки ночало
                    img_left.setEnabled(false); // Блокируем левую каринку
                    if (numLeft < numRight) {
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false);
                        // Если каснулся картинки конц
                    }
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    // Если опустил палец начало
                    if (numLeft < numRight){
                        // Если правая картинка больше
                        if (count < 20) {
                            count = count+1;
                        }
                        // Закрашиваем прогрресс серым цветом начало
                        for (int i = 0; i < 20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stil_points);
                        }
                        // Закрашиваем прогрресс серым цветом конц

                        // определяем правильные ответы начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stil_points_green);
                        }
                        // определяем правильные ответы и закрашиваем зелёным конц
                    }else {
                        //Если правая картинка меньше
                        if (count > 0){
                            if (count == 1){
                                count = 0;
                            }else {
                                count = count-2;
                            }
                        }
                        // Закрашиваем прогрресс серым цветом начало
                        for (int i = 0; i < 19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stil_points);
                        }
                        // Закрашиваем прогрресс серым цветом конц

                        // определяем правильные ответы начало
                        for (int i = 0; i < count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.stil_points_green);
                        }
                        // определяем правильные ответы и закрашиваем зелёным конц

                    }
                    // Если опустил палец конец
                    if (count == 20){
                        // выход из уровня
                        //dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(12); //Генерируем случайное число от 0 до 11
                        img_left.setImageResource(array.images2[numLeft]); // Достаём из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]); // Достаём из массива текст

                        numRight = random.nextInt(12);
                        //Цикл с предусловиемб проверяющий равенство чисел начало
                        while (numLeft == numRight){
                            numRight = random.nextInt(12);
                        }
                        //Цикл с предусловиемб проверяющий равенство чисел конец
                        img_right.setImageResource(array.images2[numRight]); // Достаём из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[numRight]); // Достаём из массива текст
                        img_left.setEnabled(true); // запускаем обратно левую картинку
                    }
                }
                // Условие касание картинки конец
                return true;

            }
        });
        // Обрабатываем нажатие на правую картинку конец


    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(Level2.this, CameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}
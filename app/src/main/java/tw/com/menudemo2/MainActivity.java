package tw.com.menudemo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MENU_BTN1 = Menu.FIRST;
    public static final int MENU_BTN2 = Menu.FIRST+1;
    public static final int MENU_BTN3 = Menu.FIRST+2;
    public static final int MENU_BTN4 = Menu.FIRST+3;

    private Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(v ->{
            Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
        });

        registerForContextMenu(btn1);   //註冊到contextmenu去

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("飛機的飲料有:");
        menu.add(0,MENU_BTN1,0,"白開水");
        menu.add(0,MENU_BTN2,0,"可樂");
        menu.add(0,MENU_BTN3,0,"咖啡");
        menu.add(0,MENU_BTN4,0,"酒");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case MENU_BTN1:
                Toast.makeText(getApplicationContext(),"白開水",Toast.LENGTH_SHORT).show();
                break;
            case MENU_BTN2:
                Toast.makeText(getApplicationContext(),"可樂",Toast.LENGTH_SHORT).show();
                break;
            case MENU_BTN3:
                Toast.makeText(getApplicationContext(),"咖啡",Toast.LENGTH_SHORT).show();
                break;
            case MENU_BTN4:
                Toast.makeText(getApplicationContext(),"酒",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
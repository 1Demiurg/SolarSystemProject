package itschool.samsung.ru.space.framework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by vv on 14.11.2016.0
 */
public class GameView extends View {
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        float d=25;
        objects.add(new TestObj("Солнце",139.1f/2,0,"RED",0,0));
        objects.add(new TestObj("Меркурий",0.24f*2,3+1.48f,"GREEN",1,d*3));
        objects.add(new TestObj("Венера",0.6f*2,3+1.5f,"YELLOW",2,d*1.5f));
        objects.add(new TestObj("Земля",0.63f*2+1,2.97f,"GREEN",3,d*1.25f));
        objects.add(new TestObj("Марс",0.33f*2+1,2.41f,"RED",4,d));
        objects.add(new TestObj("Юпитер",6.99f*2+1,1.3f,"GREEN",5,d));
        objects.add(new TestObj("Сатурн",5.82f*2+1,0.96f,"YELLOW",6,d));
        objects.add(new TestObj("Уран",2.53f*2+1,0.68f,"BLUE",7,d));
        objects.add(new TestObj("Нептун",2.46f*2+1,0.54f,"BLUE",8,d));
    }
    ArrayList<Object> objects = new ArrayList<>();

    long lastUpdate = System.currentTimeMillis();

    @Override

    protected void onDraw(Canvas canvas){
        long currentTime = System.currentTimeMillis();
        drawObjects(canvas);
        updateObjects((currentTime - lastUpdate)*0.01f);
        lastUpdate = currentTime;
        invalidate();
    }
    void drawObjects(Canvas canvas)
    {
        for (int i = 0; i< objects.size(); i++){
            if (objects.get(i) instanceof Renderable)
            {
                ((Renderable)objects.get(i)).render(canvas);
            }

        }
    }
    void updateObjects(float dt)
    {
        for (int i = 0; i< objects.size(); i++){
            if (objects.get(i) instanceof Updatable)
            {

                ((Updatable)objects.get(i)).update(dt);
            }

        }
    }
}
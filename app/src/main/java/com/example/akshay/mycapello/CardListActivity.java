package com.example.akshay.mycapello;

/**
 * Created by Akshay on 14-01-2016.
 */

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;


public class CardListActivity extends ActionBarActivity {

    private Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        int listImages[] = new int[]{R.drawable.icon,R.drawable.icon_1,R.drawable.icon_2,R.drawable.icon_3};

        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0;i<4;i++){

            card = new Card(this);
            CardHeader header = new CardHeader(this);
            header.setTitle("Item: "+ i);
            card.setTitle("Details : ");
            card.addCardHeader(header);

            CardThumbnail thumb = new CardThumbnail(this);
            thumb.setDrawableResource(listImages[i]);
            card.addCardThumbnail(thumb);

            cards.add(card);

        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards);

        CardListView listView = (CardListView)this.findViewById(R.id.myList);
        if (listView != null){
            listView.setAdapter(mCardArrayAdapter);
        }

        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Intent intent = new Intent(CardListActivity.this,MainFragActivity.class);
                startActivity(intent);

                //This code sends all cards to single Activity.!
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


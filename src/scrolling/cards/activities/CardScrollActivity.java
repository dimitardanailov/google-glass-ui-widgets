package scrolling.cards.activities;

import java.util.ArrayList;
import java.util.List;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.googleglassuiwidgets.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

/**
 * The Glass display and touchpad are great for displaying swipable cards, like in the Glass timeline. 
 * If you're building an activity, you can create the same type of effect with the CardScrollView widget.
 * 
 * For more information: https://developers.google.com/glass/develop/gdk/ui-widgets
 * 
 * @author Dimitar Danailov
 */
public class CardScrollActivity extends Activity {

	//List contains all cards
	private List<Card> mCards;
	private CardScrollView mCardScrollView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Add to mCards collection three simple cards
		createCards();
		
		// Create a new Scroll view
		mCardScrollView = new CardScrollView(this);
		MyCardScrollAdapter myAdapter = new MyCardScrollAdapter();
		mCardScrollView.setAdapter(myAdapter);
		mCardScrollView.activate();
		
		setContentView(mCardScrollView);
	}
	
	private void createCards() {
		mCards = new ArrayList<Card>();
		
		Card cardText = new Card(this);
		cardText.setText("This card has a footer.");
		cardText.setFootnote("I'm the footer !");
		mCards.add(cardText);
		
		Card backgroundCard = new Card(this);
		backgroundCard.setText("Card contains nice dog !!!");
		backgroundCard.setFootnote("How can you resist ?");
		backgroundCard.setImageLayout(Card.ImageLayout.FULL);
		backgroundCard.addImage(R.drawable.dog_640x360);
		mCards.add(backgroundCard);
		
		Card mosaicCard = new Card(this);
		mosaicCard.setText("This card has a mosaic of puppies and dogs.");
		mosaicCard.setFootnote("Aren't the precious ?");
		mosaicCard.setImageLayout(Card.ImageLayout.LEFT);
		mosaicCard.addImage(R.drawable.dogs_120x120);
		mosaicCard.addImage(R.drawable.dog_1_60x60);
		mosaicCard.addImage(R.drawable.dog_2_60x60);
		mCards.add(mosaicCard);
	}
	
	private class MyCardScrollAdapter extends CardScrollAdapter {

		@Override
		public int getPosition(Object item) {
			int position = mCards.indexOf(item);

			return position;
		}

		@Override
		public int getCount() {
			int size = mCards.size();

			return size;
		}

		@Override
		public Object getItem(int position) {
			Object card = mCards.get(position);

			return card;
		}

		@Override
		public int getViewTypeCount() {
			int type = Card.getViewTypeCount();

			return type;
		}

		@Override
		public int getItemViewType(int position){
			int itemType = mCards.get(position).getItemViewType();

			return itemType; 
		}

		@Override
		public View getView(int position, View convertView,
				ViewGroup parent) {
			View cardView = mCards.get(position).getView(convertView, parent);

			return cardView;
		}
	}
}

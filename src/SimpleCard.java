

import com.google.android.glass.app.Card;
import com.googleglassuiwidgets.R;

import android.content.Context;
import android.view.View;

/**
 * Demo follow -> https://developers.google.com/glass/develop/gdk/ui-widgets 
 * 
 * @author Dimitar Danailov
 */
public class SimpleCard {
	
	/**
	 * Create a card with simple text and footer
	 * @param context
	 * @return
	 */
	public View generateSimpleTextCard(Context context) {
		Card cardText = new Card(context);
		cardText.setText("This card has a footer.");
		cardText.setFootnote("I'm the footer !");
		// Call Card.getView() to convert the card to an Android view.
		// Use the view in your activities, layouts, or in a CardScrollView.
		View viewCardText =  cardText.getView();
		
		return viewCardText;
	}
	
	/**
	 * Create a card with a full screen background image.
	 * @param context
	 * @return
	 */
	public View generateFullBackgroundcard(Context context) {
		
		Card backgroundCard = new Card(context);
		backgroundCard.setText("Card contains nice dog !!!");
		backgroundCard.setFootnote("How can you resist ?");
		backgroundCard.setImageLayout(Card.ImageLayout.FULL);
		backgroundCard.addImage(R.drawable.dog_640x360);
		View viewCardBackground = backgroundCard.getView();
		
		return viewCardBackground;
	}
	
	/**
	 * Create a card with multiple images displayed as a mosaic.
	 * @param context
	 * @return
	 */
	public View generateMultipleImagesCard(Context context) {
		Card mosaicCard = new Card(context);
		mosaicCard.setText("This card has a mosaic of puppies and dogs.");
		mosaicCard.setFootnote("Aren't the precious ?");
		mosaicCard.setImageLayout(Card.ImageLayout.LEFT);
		mosaicCard.addImage(R.drawable.dogs_120x120);
		mosaicCard.addImage(R.drawable.dog_1_60x60);
		mosaicCard.addImage(R.drawable.dog_2_60x60);
		View viewMosaicCard = mosaicCard.getView();
		
		return viewMosaicCard;
	}
}

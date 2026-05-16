package del5_8;

import java.util.ArrayList;
import java.util.Collection;


public class BidListenerTester implements BidListener{
	
	public Collection<Bid> bids = new ArrayList<>();

	@Override
	public void propertyBid(Bid bid) {
		bids.add(bid);
	}
	

}

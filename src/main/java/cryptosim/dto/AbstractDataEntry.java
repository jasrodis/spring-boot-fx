package cryptosim.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AbstractDataEntry {

	@Id
	private String id;

	private String vol;
	private String base;
	private String quote;
	private String ask;
	private String bid;
	private String ts;

	public String getVol() {
		return vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAskPrice() {
		return ask;
	}

	public void setAskPrice(String askPrice) {
		this.ask = askPrice;
	}

	public String getBidPrice() {
		return bid;
	}

	public void setBidPrice(String bidPrice) {
		this.bid = bidPrice;
	}

	public String getTimestamp() {
		return ts;
	}

	public void setTimestamp(String timestamp) {
		this.ts = timestamp;
	}

	@Override
	public String toString() {
		return String.format("Entry[id='%s', vol='%s', quote='%s', ask='%s', base='%s', bid='%s', ts='%s']", id, vol,
				quote, ask, base, bid, ts);
	}

}
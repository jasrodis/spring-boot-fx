package cryptosim.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "binance")
public class BinanceDataEntry extends AbstractDataEntry {
}

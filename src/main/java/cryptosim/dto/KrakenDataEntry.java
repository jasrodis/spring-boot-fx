package cryptosim.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "kraken")
public class KrakenDataEntry extends AbstractDataEntry {

}

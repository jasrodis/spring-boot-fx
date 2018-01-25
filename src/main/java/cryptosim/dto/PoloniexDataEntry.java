package cryptosim.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "poloniex")
public class PoloniexDataEntry extends AbstractDataEntry {

}

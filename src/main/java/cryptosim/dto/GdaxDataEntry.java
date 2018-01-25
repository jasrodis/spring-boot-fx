package cryptosim.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "gdax")
public class GdaxDataEntry extends AbstractDataEntry{

}

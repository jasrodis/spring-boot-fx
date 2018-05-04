package org.jasrodis.bootfx.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AbstractDataEntry {

	@Id
	private String id;

}
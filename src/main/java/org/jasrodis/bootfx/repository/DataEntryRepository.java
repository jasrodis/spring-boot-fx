package org.jasrodis.bootfx.repository;

import org.jasrodis.bootfx.dto.DataEntry;
import org.springframework.stereotype.Repository;

@Repository
public interface DataEntryRepository extends AbstractDataEntryRepository<DataEntry> {

//	@Query("{field1: ?0, field2: ?1}")
//	public List<DataEntry> findByField(String field1, String field2);
	
}

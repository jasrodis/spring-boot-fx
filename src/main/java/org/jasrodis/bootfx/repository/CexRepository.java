package org.jasrodis.bootfx.repository;

import java.util.List;

import org.jasrodis.bootfx.dto.CexDataEntry;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CexRepository extends AbstractDataEntryRepository<CexDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<CexDataEntry> findByPair(String base, String quote);

}

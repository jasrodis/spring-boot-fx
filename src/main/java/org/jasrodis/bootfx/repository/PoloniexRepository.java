package org.jasrodis.bootfx.repository;

import java.util.List;

import org.jasrodis.bootfx.dto.PoloniexDataEntry;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PoloniexRepository extends AbstractDataEntryRepository<PoloniexDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<PoloniexDataEntry> findByPair(String base, String quote);

}

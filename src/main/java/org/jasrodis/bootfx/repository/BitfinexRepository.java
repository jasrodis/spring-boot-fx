package org.jasrodis.bootfx.repository;

import java.util.List;

import org.jasrodis.bootfx.dto.BitfinexDataEntry;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BitfinexRepository extends AbstractDataEntryRepository<BitfinexDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<BitfinexDataEntry> findByPair(String base, String quote);

}

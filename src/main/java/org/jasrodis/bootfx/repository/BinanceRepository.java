package org.jasrodis.bootfx.repository;

import java.util.List;

import org.jasrodis.bootfx.dto.BinanceDataEntry;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BinanceRepository extends AbstractDataEntryRepository<BinanceDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<BinanceDataEntry> findByPair(String base, String quote);
	
}

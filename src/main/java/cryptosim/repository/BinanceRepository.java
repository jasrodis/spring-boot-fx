package cryptosim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cryptosim.dto.BinanceDataEntry;

@Repository
public interface BinanceRepository extends AbstractDataEntryRepository<BinanceDataEntry> {

	@Query("{base: ?0, quote: ?1}")
	public List<BinanceDataEntry> findByPair(String base, String quote);
	
}

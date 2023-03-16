package dev.rhy.astrapaytools.cache.repository;

import dev.rhy.astrapaytools.cache.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    Merchant findByName(String name);
}

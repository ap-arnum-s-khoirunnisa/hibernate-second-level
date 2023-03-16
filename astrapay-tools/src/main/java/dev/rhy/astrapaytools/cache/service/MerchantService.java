package dev.rhy.astrapaytools.cache.service;

import dev.rhy.astrapaytools.cache.controller.dto.MerchantDto;
import dev.rhy.astrapaytools.cache.entity.Merchant;
import dev.rhy.astrapaytools.cache.repository.MerchantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MerchantService {

    @Autowired MerchantRepository merchantRepository;

    public List<Merchant> getAll (){
       return merchantRepository.findAll();
    }

    public Merchant getMerchantDetail(long id) {
        var result = merchantRepository.findById(id)
                .orElseThrow();
        return result;
    }

    public Merchant getMerchantDetailFirstLevel(long id) {
        var result = merchantRepository.findById(id)
                .orElseThrow();

        //query yg sama utk kedua-kalinya.
        result = merchantRepository.findById(id).orElseThrow();
        return result;
    }

    public Merchant getMerchantDetailFirstLevelOnOtherThread(long id) {
        var result = merchantRepository.findById(id)
                .orElseThrow();

        log.info("result-first: {}", result.getName());

        //query yg sama utk kedua-kalinya di thread yg berbeda.
        testQueryMerchantOnOtherThread(id);
        return result;
    }

    @Async
    void testQueryMerchantOnOtherThread(long id) {
        var result = merchantRepository.findById(id)
                .orElseThrow();
        //log.info("result-second: {}", result.getName());
        System.out.println(result);
    }

    public Merchant patch(long id, MerchantDto merchantDto) {
        var data = merchantRepository.findById(id).orElseThrow();
        data.setName(merchantDto.getName());
        return merchantRepository.save(data);
    }

    public Merchant getByName(String name) {
        return merchantRepository.findByName(name);
    }
}

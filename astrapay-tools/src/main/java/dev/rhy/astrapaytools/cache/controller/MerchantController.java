package dev.rhy.astrapaytools.cache.controller;

import dev.rhy.astrapaytools.cache.controller.dto.MerchantDto;
import dev.rhy.astrapaytools.cache.entity.Merchant;
import dev.rhy.astrapaytools.cache.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant")
public class MerchantController {

    @Autowired MerchantService merchantService;

    @GetMapping("")
    List<Merchant> getAll (){
        return merchantService.getAll();
    }
    @GetMapping("{id}")
    Merchant get(@PathVariable("id")long id) {
        return merchantService.getMerchantDetail(id);
    }

    @GetMapping("firstlevel/{id}")
    Merchant get1stLevel(@PathVariable("id")long id) {
        return merchantService.getMerchantDetailFirstLevel(id);
    }

    @GetMapping("firstlevel/otherthread/{id}")
    Merchant get1stLevelOnOtherThread(@PathVariable("id")long id) {
        return merchantService.getMerchantDetailFirstLevelOnOtherThread(id);
    }

    @PatchMapping("{id}")
    Merchant addNew(@PathVariable("id")long id,
                    @RequestBody MerchantDto merchantDto) {
        return merchantService.patch(id, merchantDto);
    }

    @GetMapping("byname")
    Merchant getMerchantByName(@RequestParam("name")String name) {
        return merchantService.getByName(name);
    }
}

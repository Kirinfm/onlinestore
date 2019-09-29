package com.kirinsoft.onlinestore.onlinestore.goods.controller;

import com.kirinsoft.onlinestore.onlinestore.goods.entity.GoodsEntity;
import com.kirinsoft.onlinestore.onlinestore.goods.service.GoodsService;
import com.kirinsoft.onlinestore.onlinestore.goods.vo.GoodsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping
    public Page<GoodsVo> getGoodsList(@RequestParam int page, @RequestParam int size) {
        return goodsService.findGoodsList(PageRequest.of(page - 1, size, Sort.by(Sort.Order.by("name"), Sort.Order.desc("size"))));
    }

    @PostMapping
    public ResponseEntity saveGoods(@RequestBody GoodsVo goodsVo) {
        GoodsEntity goodsEntity = new GoodsEntity();
        BeanUtils.copyProperties(goodsVo, goodsEntity);
        return new ResponseEntity(goodsService.saveGoods(goodsEntity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateGoods(@PathVariable String id, @RequestBody GoodsVo goodsVo) {
        GoodsEntity goodsEntity = new GoodsEntity();
        BeanUtils.copyProperties(goodsVo, goodsEntity);
        goodsEntity.setId(id);
        return new ResponseEntity(goodsService.updateGoods(goodsEntity), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteGoods(@RequestParam String ids) {
        goodsService.deleteGoods(ids);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

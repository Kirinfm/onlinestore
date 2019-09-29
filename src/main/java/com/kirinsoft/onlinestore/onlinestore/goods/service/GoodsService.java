package com.kirinsoft.onlinestore.onlinestore.goods.service;

import com.kirinsoft.onlinestore.onlinestore.goods.entity.GoodsEntity;
import com.kirinsoft.onlinestore.onlinestore.goods.repository.GoodsRepository;
import com.kirinsoft.onlinestore.onlinestore.goods.vo.GoodsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public GoodsVo saveGoods(GoodsEntity goodsEntity) {
        GoodsVo goodsVo = new GoodsVo();
        BeanUtils.copyProperties(goodsRepository.save(goodsEntity), goodsVo);
        return goodsVo;
    }

    public GoodsVo updateGoods(GoodsEntity goodsEntity) {
        GoodsVo goodsVo = new GoodsVo();
        BeanUtils.copyProperties(goodsRepository.save(goodsEntity), goodsVo);
        return goodsVo;
    }

    public GoodsVo updateGoodsNum(String goodsId, Integer num) {
        GoodsVo goodsVo = new GoodsVo();
        Optional<GoodsEntity> goodsEntityOptional = goodsRepository.findById(goodsId);
        if (goodsEntityOptional.isPresent()) {
            GoodsEntity goodsEntity = goodsEntityOptional.get();
            goodsEntity.setNum(num);
            goodsRepository.save(goodsEntity);
            BeanUtils.copyProperties(goodsEntity, goodsVo);
        }
        return goodsVo;
    }

    public void deleteGoods(String ids) {
        if (!StringUtils.isEmpty(ids)) {
            String[] idArray = ids.split(",");
            goodsRepository.deleteAll(goodsRepository.findAllById(Arrays.asList(idArray)));
        }
    }

    public Page<GoodsVo> findGoodsList(PageRequest pageRequest) {
        Page<GoodsEntity> goodsEntities = goodsRepository.findAll(pageRequest);
        List<GoodsVo> goodsVos = new ArrayList<>();
        for (GoodsEntity goodsEntity : goodsEntities.getContent()) {
            GoodsVo goodsVo = new GoodsVo();
            BeanUtils.copyProperties(goodsEntity, goodsVo);
            goodsVos.add(goodsVo);
        }
        return new PageImpl<>(goodsVos, pageRequest, goodsEntities.getTotalElements());
    }

}

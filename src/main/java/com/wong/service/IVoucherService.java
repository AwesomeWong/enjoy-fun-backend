package com.wong.service;

import com.wong.dto.Result;
import com.wong.entity.Voucher;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IVoucherService extends IService<Voucher> {

    Result queryVoucherOfShop(Long shopId);

    void addSeckillVoucher(Voucher voucher);
}

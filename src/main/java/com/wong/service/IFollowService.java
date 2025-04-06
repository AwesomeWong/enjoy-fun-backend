package com.wong.service;

import com.wong.dto.Result;
import com.wong.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
  */
public interface IFollowService extends IService<Follow> {
    Result follow(Long followUserId, Boolean isFollow);

    Result isFollow(Long followUserId);

    Result followCommons(Long id);
}

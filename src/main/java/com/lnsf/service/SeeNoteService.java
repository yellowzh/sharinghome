package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.SeeNoteDTO;
import com.lnsf.entity.SeeNoteEntity;
import com.lnsf.vo.SeeListVO;
import com.lnsf.vo.SeeVo;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-26 15:11
 */
public interface SeeNoteService {
    SeeNoteEntity create(SeeNoteDTO dto);

    SeeListVO SeeVo();
}

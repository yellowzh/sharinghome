package com.lnsf.dao;

import com.lnsf.entity.SeeNoteEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.SeeNoteDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-26 15:11
 */
@Repository
public interface SeeNoteMapper extends BaseMapper<SeeNoteEntity> {

    List<SeeNoteEntity> page(@Param("dto")SeeNoteDTO dto, IPage<SeeNoteEntity> page);

}

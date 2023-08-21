package com.imooc.pan.server.modules.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.pan.server.modules.log.entity.RPanFile;
import com.imooc.pan.server.modules.log.service.RPanFileService;
import com.imooc.pan.server.modules.log.mapper.RPanFileMapper;
import org.springframework.stereotype.Service;

/**
* @author HJT
* @description 针对表【r_pan_file(物理文件信息表)】的数据库操作Service实现
* @createDate 2023-08-21 22:35:22
*/
@Service
public class RPanFileServiceImpl extends ServiceImpl<RPanFileMapper, RPanFile>
    implements RPanFileService{

}





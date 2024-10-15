package org.example.demo.convert;

import org.example.demo.model.UserDO;
import org.example.demo.model.dto.user.UserVerifyDTO;
import org.example.demo.model.vo.user.UserBriefVO;
import org.example.demo.model.vo.user.UserDetailVO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    //One-way
    UserDO userDetailVOToUser(UserDetailVO userDetailVO);
    UserDO userBriefVOToUser(UserBriefVO userBriefVO);

    //UserDOto
    UserDetailVO userToDetailVO(UserDO userDO);
    UserBriefVO userToBriefVO(UserDO userDO);

    //UserVerify
    UserVerifyDTO userDOToUserVerifyDTO(UserDO userDO);

    UserDO verifyDTOToUserDO(UserVerifyDTO userDTO);
    UserVerifyDTO userDOToVerifyDTO(UserDO userDO);

}

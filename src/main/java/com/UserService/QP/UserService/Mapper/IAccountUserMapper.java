package com.UserService.QP.UserService.Mapper;

import com.UserService.QP.UserService.controller.request.AccountUserPostRequest;
import com.UserService.QP.UserService.controller.request.AccountUserUpdateRequest;
import com.UserService.QP.UserService.controller.response.AccountResponse;
import com.UserService.QP.UserService.controller.response.AccountUserResponse;
import com.UserService.QP.UserService.model.AccountEntity;
import com.UserService.QP.UserService.model.AccountUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IAccountUserMapper {
    IAccountUserMapper INSTANCE = Mappers.getMapper(IAccountUserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "account", ignore = true)
    void entityToEntity(AccountUserEntity sourceEntity, @MappingTarget AccountUserEntity destinationEntity);

    List<AccountUserResponse> map(List<AccountUserEntity> accountEntities);

    @Mapping(target = " account_Id", source = "account.id")
    AccountUserResponse entityToResponse(AccountUserEntity accountUserEntity);

    AccountUserEntity postRequestToEntity(AccountUserPostRequest accountUserPostRequest);
    AccountUserEntity updateRequestToEntity(AccountUserUpdateRequest accountUserUpdateRequest);





}

package com.UserService.QP.UserService.Mapper;

import com.UserService.QP.UserService.controller.request.AccountPostRequest;
import com.UserService.QP.UserService.controller.request.AccountUpdateRequest;
import com.UserService.QP.UserService.controller.response.AccountResponse;
import com.UserService.QP.UserService.model.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Target;
import java.util.List;

@Mapper
public interface IAccountMapper {
    IAccountMapper INSTANCE = Mappers.getMapper(IAccountMapper.class);
    @Mapping(target = "id", ignore = true)
    AccountEntity requestToEntity(AccountPostRequest request);

    AccountResponse entityToResponse(AccountEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountUserEntityList", ignore = true)
    @Mapping(target = "numberOfUsers", ignore = true)
    AccountEntity  updateRequestToEntity(AccountUpdateRequest request);

    @Mapping(target = "accountUserEntityList", ignore = true)
    @Mapping(target = "id", ignore = true)
    void entityToEntity(AccountEntity sourceEntity, @MappingTarget AccountEntity destinationEntity);

    List<AccountResponse> map(List<AccountEntity> accountEntities);


}

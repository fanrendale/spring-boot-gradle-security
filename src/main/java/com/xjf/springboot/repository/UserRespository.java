package com.xjf.springboot.repository;

import com.xjf.springboot.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author xjf
 * @date 2019/1/28 13:34
 */
public interface UserRespository extends CrudRepository<User,Long> {

}

/*
 * DISCLAIMER
 *
 * Copyright 2017 ArangoDB GmbH, Cologne, Germany
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright holder is ArangoDB GmbH, Cologne, Germany
 */

package com.arangodb.spring.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.query.Param;

import com.arangodb.ArangoCursor;
import com.arangodb.entity.BaseDocument;
import com.arangodb.spring.demo.entity.UserInfo;
import com.arangodb.springframework.annotation.BindVars;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.annotation.QueryOptions;
import com.arangodb.springframework.repository.ArangoRepository;

/**
 * @author Mark Vollmary
 *
 */
public interface UserInfoRepository extends ArangoRepository<UserInfo, String> {
	@Query("FOR c IN userinfo FILTER c.userId == @userId RETURN c._id")
	String getDbIdByUserId(@Param("userId") String userId);
	
	@Query("FOR c IN userinfo FILTER c.name == @name RETURN c._id")
	String getDbIdByName(@Param("name") String name);
	
	@Query("FOR c IN userinfo FILTER c.userId == @userId RETURN c")
	UserInfo getUserInfo(@Param("userId") String userId);
	
	UserInfo findByUserId(String userId);
	
	UserInfo findByName(String name);
	
//	Iterable<UserInfo> findBySurname(String surname);
//
//	Collection<UserInfo> findTop2DistinctBySurnameIgnoreCaseOrderByAgeDesc(String surname);
//
//	List<UserInfo> findBySurnameEndsWithAndAgeBetweenAndNameInAllIgnoreCase(
//		String suffix,
//		int lowerBound,
//		int upperBound,
//		String[] nameList);
//
//	Optional<UserInfo> findByNameAndSurname(String name, String surname);
//	
//	
//	
//	
//	Integer countByAliveTrue();
//
//	void removeBySurnameNotLikeOrAliveFalse(String surname);
//
//	Iterable<UserInfo> findByChildsName(String name);
//
//	Iterable<UserInfo> findByChildsAgeBetween(int lowerBound, int upperBound);
//
//	@Query("FOR c IN characters FILTER c.age > @value SORT c.age DESC RETURN c")
//	Iterable<UserInfo> getOlderThan(int value);
//
//	@Query("FOR c IN characters FILTER c.surname == @surname SORT c.age ASC RETURN c")
//	Iterable<UserInfo> getWithSurname(@Param("surname") String value);
//
//	@Query("FOR c IN @@col FILTER c.surname == @surname AND c.age > @age RETURN c")
//	@QueryOptions(count = true)
//	ArangoCursor<UserInfo> getWithSurnameOlderThan(@Param("age") int value, @BindVars Map<String, Object> bindvars);
//
//	@Query("FOR v IN 1..2 INBOUND @id @@edgeCol SORT v.age DESC RETURN DISTINCT v")
//	Set<UserInfo> getAllChildsAndGrandchilds(@Param("id") String id, @Param("@edgeCol") Class<?> edgeCollection);

}

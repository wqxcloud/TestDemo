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

package com.arangodb.spring.demo.entity;

import java.util.Collection;

import org.springframework.data.annotation.Id;

import com.arangodb.entity.DocumentField;
import com.arangodb.entity.DocumentField.Type;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndex;
import com.arangodb.springframework.annotation.Relations;

/**
 * @author Mark Vollmary
 *
 */
@Document("userinfo")
@HashIndex(fields = {"userId" }, unique = true)
@HashIndex(fields = {"name" }, unique = true)
public class UserInfo {

	@Id
	private String id;
	private String userId;
	private String name;
	private int sex;
	private boolean alive;
	private Integer age;
	@Relations(edges = RelationOf.class, lazy = true)
	private Collection<UserInfo> childs;

	public UserInfo() {
		super();
	}
	
	public UserInfo(final String userId,final String name, final int sex,final boolean alive) {
		super();
		this.userId = userId;
		this.name = name;
		this.alive = alive;
		this.sex = sex;
	}

	public UserInfo(final String name, final boolean alive) {
		super();
		this.name = name;
		this.alive = alive;
	}

	public UserInfo(final String name,  final boolean alive, final Integer age) {
		super();
		this.name = name;
		this.alive = alive;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(final boolean alive) {
		this.alive = alive;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	public Collection<UserInfo> getChilds() {
		return childs;
	}

	public void setChilds(final Collection<UserInfo> childs) {
		this.childs = childs;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", userId =" + userId+ ", alive=" + alive + ", age=" + age
				+ "]";
	}

}

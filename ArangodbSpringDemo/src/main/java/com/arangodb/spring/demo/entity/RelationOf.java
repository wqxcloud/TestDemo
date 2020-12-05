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

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

/**
 * @author Mark Vollmary
 *
 */
@Edge
public class RelationOf {

	@Id
	private String id;

	@From
	private UserInfo fromUserInfo;

	@To
	private UserInfo toUserInfo;
	
	private String relation;
	
	private int show;

	public RelationOf(final UserInfo fromUserInfo, final UserInfo toUserInfo,final String relation,final int show) {
		super();
		this.fromUserInfo = fromUserInfo;
		this.toUserInfo = toUserInfo;
		this.relation = relation;
		this.show = show;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	

	public UserInfo getFromUserInfo() {
		return fromUserInfo;
	}

	public void setFromUserInfo(UserInfo fromUserInfo) {
		this.fromUserInfo = fromUserInfo;
	}

	public UserInfo getToUserInfo() {
		return toUserInfo;
	}

	public void setToUserInfo(UserInfo toUserInfo) {
		this.toUserInfo = toUserInfo;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	
	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "ChildOf [id=" + id + ", fromUserInfo=" + fromUserInfo + ", toUserInfo=" + toUserInfo + "]";
	}

}

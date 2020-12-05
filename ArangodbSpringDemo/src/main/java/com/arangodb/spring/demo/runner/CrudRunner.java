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

package com.arangodb.spring.demo.runner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.arangodb.spring.demo.entity.UserInfo;
import com.arangodb.spring.demo.repository.UserInfoRepository;
import com.arangodb.springframework.core.ArangoOperations;

/**
 * @author Mark Vollmary
 *
 */
@ComponentScan("com.arangodb.spring.demo")
public class CrudRunner implements CommandLineRunner {

	static final Collection<UserInfo> characters = createCharacters();

	@Autowired
	private ArangoOperations operations;
	@Autowired
	private UserInfoRepository repository;

	@Override
	public void run(final String... args) throws Exception {
		// first drop the database so that we can run this multiple times with the same dataset
		operations.dropDatabase();
//		System.out.println("# CRUD operations");
//
//		// save a single entity in the database
//		// there is no need of creating the collection first. This happen automatically
//		final UserInfo nedStark = characters.stream()
//				.filter(it-> "洁".equals(it.getName()) && "王".equals(it.getSurname()))
//				.findFirst().orElseThrow();
//		repository.save(nedStark);
//		// the generated id from the database is set in the original entity
//		System.out.println(String.format("洁 王 saved in the database with id: '%s'", nedStark.getId()));
//
//		// lets take a look whether we can find 洁 王 in the database
//		final UserInfo foundNed = repository.findById(nedStark.getId()).get();
//		System.out.println(String.format("Found %s", foundNed));
//
//		// as everyone probably knows 洁 王 died in the first season.
//		// So we have to update his 'alive' flag
//		nedStark.setAlive(false);
//		repository.save(nedStark);
//		final UserInfo deadNed = repository.findById(nedStark.getId()).get();
//		System.out.println(String.format("洁 王 after 'alive' flag was updated: %s", deadNed));
//
//		// lets save some additional characters
//		System.out.println(String.format("Save %s additional characters", characters.size()));
//		repository.saveAll(characters);
//
//		final Iterable<UserInfo> all = repository.findAll();
//		final long count = StreamSupport.stream(Spliterators.spliteratorUnknownSize(all.iterator(), 0), false).count();
//		System.out.println(String.format("A total of %s characters are persisted in the database", count));
//
//		System.out.println("## Return all characters sorted by name");
//		final Iterable<UserInfo> allSorted = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
//		allSorted.forEach(System.out::println);
//
//		System.out.println("## Return the first 5 characters sorted by name");
//		final Page<UserInfo> first5Sorted = repository
//				.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "name")));
//		first5Sorted.forEach(System.out::println);
	}

	public static Collection<UserInfo> createCharacters() {
		return Arrays.asList(
//			new Character("洁", "王", true, 41), new Character("Robert", "Baratheon", false),
//			new Character("Jaime", "Lannister", true, 36), new Character("Catelyn", "王", false, 40),
//			new Character("Cersei", "Lannister", true, 36), new Character("Daenerys", "Targaryen", true, 16),
//			new Character("Jorah", "Mormont", false), new Character("Petyr", "Baelish", false),
//			new Character("Viserys", "Targaryen", false), new Character("Jon", "Snow", true, 16),
//			new Character("Sansa", "王", true, 13), new Character("Arya", "王", true, 11),
//			new Character("Robb", "王", false), new Character("Theon", "Greyjoy", true, 16),
//			new Character("Bran", "王", true, 10), new Character("Joffrey", "Baratheon", false, 19),
//			new Character("Sandor", "Clegane", true), new Character("Tyrion", "Lannister", true, 32),
//			new Character("Khal", "Drogo", false), new Character("Tywin", "Lannister", false),
//			new Character("Davos", "Seaworth", true, 49), new Character("Samwell", "Tarly", true, 17),
//			new Character("Stannis", "Baratheon", false), new Character("Melisandre", null, true),
//			new Character("Margaery", "Tyrell", false), new Character("Jeor", "Mormont", false),
//			new Character("Bronn", null, true), new Character("Varys", null, true), new Character("Shae", null, false),
//			new Character("Talisa", "Maegyr", false), new Character("Gendry", null, false),
//			new Character("Ygritte", null, false), new Character("Tormund", "Giantsbane", true),
//			new Character("Gilly", null, true), new Character("Brienne", "Tarth", true, 32),
//			new Character("Ramsay", "Bolton", true), new Character("Ellaria", "Sand", true),
//			new Character("Daario", "Naharis", true), new Character("Missandei", null, true),
//			new Character("Tommen", "Baratheon", true), new Character("Jaqen", "H'ghar", true),
//			new Character("Roose", "Bolton", true), new Character("The High Sparrow", null, true));
			new UserInfo("2020010201","一中二班A", 0,true),
			new UserInfo("2020010202","一中二班B", 0,true),
			new UserInfo("2020010203","一中二班C", 1,true),
			new UserInfo("2020010204","一中二班D", 0,true),
			new UserInfo("2020010205","一中二班班长", 0,false),
			
			new UserInfo("1000201","一中二班语文教师", 1,true),
			new UserInfo("1000202","一中二班班主任", 0, true),
			
			new UserInfo("2020010501","一中五班A", 0,true),
			new UserInfo("2020010502","一中五班B", 0,true),
			new UserInfo("2020010503","一中五班C", 1,true),
			new UserInfo("2020010504","一中五班D", 0,true),
			new UserInfo("2020010505","一中五班班长", 0,false),
			
			new UserInfo("1000501","一中五班语文教师", 1,true),
			new UserInfo("1000502","一中五班班主任", 0, true),
			
			new UserInfo("110001","一中教导主任", 0, true),
			new UserInfo("100001","一中校长", 0, true),
		
			new UserInfo("2020020201","二中二班A", 0,true),
			new UserInfo("2020020202","二中二班B", 0,true),
			new UserInfo("2020020203","二中二班C", 1,true),
			new UserInfo("2020020204","二中二班D", 0,true),
			new UserInfo("2020020205","二中二班班长", 0,false),
			
			
			new UserInfo("2000101","二中二班语文教师", 1,true),
			new UserInfo("2000102","二中二班班主任", 0, true),
			
			
			new UserInfo("2020020501","二中五班A", 0,true),
			new UserInfo("2020020502","二中五班B", 0,true),
			new UserInfo("2020020503","二中五班C", 1,true),
			new UserInfo("2020020504","二中五班D", 0,true),
			new UserInfo("2020020505","二中五班班长", 0,false),
			
			new UserInfo("2000501","二中五班语文教师", 1,true),
			new UserInfo("2000502","二中五班班主任", 0, true),
			
			new UserInfo("210001","二中教导主任", 0, true),
			new UserInfo("200001","二中校长", 0, true),
			
		new UserInfo("10001","教育局局长", 0, true));
	}
}

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
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import com.arangodb.ArangoCursor;
import com.arangodb.entity.BaseDocument;
import com.arangodb.spring.demo.entity.UserInfo;
import com.arangodb.spring.demo.entity.RelationOf;
import com.arangodb.spring.demo.repository.UserInfoRepository;
import com.arangodb.spring.demo.repository.RelationOfRepository;
import com.arangodb.springframework.core.ArangoOperations;
import com.arangodb.util.MapBuilder;

/**
 * @author Mark Vollmary
 *
 */
@ComponentScan("com.arangodb.spring.demo")
public class RelationsRunner implements CommandLineRunner {

	@Autowired
	private UserInfoRepository characterRepo;
	@Autowired
	private RelationOfRepository relationOfRepo;
	@Autowired
	private ArangoOperations operations;
	@Override
	public void run(final String... args) throws Exception {
		System.out.println("# Relations");
		characterRepo.saveAll(CrudRunner.characters);
		/*
		 characterRepo.saveAll(CrudRunner.characters);
		 

		// first create some relations for the Starks and Lannisters
		characterRepo.findByNameAndSurname("Ned", "Stark").ifPresent(new Consumer<Character>() {
			@Override
			public void accept(Character ned) {
				characterRepo.findByNameAndSurname("Catelyn", "Stark").ifPresent(new Consumer<Character>() {
					@Override
					public void accept(Character catelyn) {
						characterRepo.findByNameAndSurname("Robb", "Stark").ifPresent(new Consumer<Character>() {
							@Override
							public void accept(Character robb) {
								relationOfRepo.saveAll(Arrays.asList(new ChildOf(robb, ned), new ChildOf(robb, catelyn)));
							}
						});
						characterRepo.findByNameAndSurname("Sansa", "Stark").ifPresent(new Consumer<Character>() {
							@Override
							public void accept(Character sansa) {
								relationOfRepo.saveAll(Arrays.asList(new ChildOf(sansa, ned), new ChildOf(sansa, catelyn)));
							}
						});
						characterRepo.findByNameAndSurname("Arya", "Stark").ifPresent(new Consumer<Character>() {
							@Override
							public void accept(Character arya) {
								relationOfRepo.saveAll(Arrays.asList(new ChildOf(arya, ned), new ChildOf(arya, catelyn)));
							}
						});
						characterRepo.findByNameAndSurname("Bran", "Stark").ifPresent((Character bran) -> {
							relationOfRepo.saveAll(Arrays.asList(new ChildOf(bran, ned), new ChildOf(bran, catelyn)));
						});
					}
				});
				characterRepo.findByNameAndSurname("Jon", "Snow")
						.ifPresent(new Consumer<Character>() {
							@Override
							public void accept(Character bran) {
								relationOfRepo.save(new ChildOf(bran, ned));
							}
						});
			}
		});

		characterRepo.findByNameAndSurname("Tywin", "Lannister").ifPresent(tywin -> {
			characterRepo.findByNameAndSurname("Jaime", "Lannister").ifPresent(jaime -> {
				relationOfRepo.save(new ChildOf(jaime, tywin));
				characterRepo.findByNameAndSurname("Cersei", "Lannister").ifPresent(cersei -> {
					relationOfRepo.save(new ChildOf(cersei, tywin));
					characterRepo.findByNameAndSurname("Joffrey", "Baratheon").ifPresent(joffrey -> {
						relationOfRepo.saveAll(Arrays.asList(new ChildOf(joffrey, jaime), new ChildOf(joffrey, cersei)));
					});
				});
			});
			characterRepo.findByNameAndSurname("Tyrion", "Lannister")
					.ifPresent(tyrion -> relationOfRepo.save(new ChildOf(tyrion, tywin)));
		});

		// after we add `@Relations(edges = ChildOf.class, lazy = true) Collection<Character> childs;` in Character
		// we can now load all children of a Character when we fetch the character
		characterRepo.findByNameAndSurname("Ned", "Stark").ifPresent(nedStark -> {
			System.out.println(String.format("## These are the children of %s:", nedStark));
			nedStark.getChilds().forEach(System.out::println);
		});

		// the fields 'childs' isn't persisted in the character document itself, it's represented through
		// the edges. Nevertheless we can write a derived method which includes properties of the connected character
		System.out.println("## These are the parents of 'Sansa'");
		final Iterable<Character> parentsOfSansa = characterRepo.findByChildsName("Sansa");
		parentsOfSansa.forEach(System.out::println);
		for(Character c:parentsOfSansa) {
			System.out.println(c.getId());
		}

		System.out.println("## These parents have a child which is between 16 and 20 years old");
		final Iterable<Character> childsBetween16a20 = characterRepo.findByChildsAgeBetween(16, 20);
		childsBetween16a20.forEach(System.out::println);
		*/

		System.out.println("查询："+characterRepo.getDbIdByName("洁"));
		//relationOfRepo.save(new ChildOf(jieShu.getId(), jieYe.getId()));
		System.out.println("characterRepo:"+characterRepo);
		
//		characterRepo.findByNameAndSurname("洁爸", "王").ifPresent(new Consumer<UserInfo>() {
//			@Override
//			public void accept(UserInfo jieBa) {
//				System.out.println("jieBa:"+jieBa);
//				characterRepo.findByNameAndSurname("洁", "王")
//				.ifPresent(new Consumer<UserInfo>() {
//					@Override
//					public void accept(UserInfo jie) {
//						relationOfRepo.save(new ChildOf(jie, jieBa));
//					}
//				});
//				}
//			});
		relationOfRepo.saveAll(Arrays.asList(
				new RelationOf(characterRepo.findByName("一中二班A"),characterRepo.findByName("一中二班B"),"同学",1),
				new RelationOf(characterRepo.findByName("一中二班A"),characterRepo.findByName("一中二班C"),"同学",1),
				new RelationOf(characterRepo.findByName("一中二班A"),characterRepo.findByName("一中二班D"),"同学",1),
				new RelationOf(characterRepo.findByName("一中二班A"),characterRepo.findByName("一中二班班长"),"同学",1),
				
				new RelationOf(characterRepo.findByName("一中二班B"),characterRepo.findByName("一中二班班长"),"同学",1),
				new RelationOf(characterRepo.findByName("一中二班班长"),characterRepo.findByName("一中五班班长"),"校友",1),
				new RelationOf(characterRepo.findByName("一中五班A"),characterRepo.findByName("一中五班班长"),"同学",1),
				new RelationOf(characterRepo.findByName("一中五班B"),characterRepo.findByName("一中五班班长"),"同学",1),
				new RelationOf(characterRepo.findByName("一中五班C"),characterRepo.findByName("一中五班班长"),"同学",1),
				new RelationOf(characterRepo.findByName("一中五班D"),characterRepo.findByName("一中五班班长"),"同学",1),
		
				new RelationOf(characterRepo.findByName("二中二班班长"),characterRepo.findByName("二中二班B"),"同学",1),
				new RelationOf(characterRepo.findByName("二中二班班长"),characterRepo.findByName("二中二班C"),"同学",1),
				new RelationOf(characterRepo.findByName("二中二班班长"),characterRepo.findByName("二中二班D"),"同学",1),
				new RelationOf(characterRepo.findByName("二中二班班长"),characterRepo.findByName("二中二班A"),"同学",1),
				
				new RelationOf(characterRepo.findByName("二中二班B"),characterRepo.findByName("二中二班A"),"邻居",1),
				new RelationOf(characterRepo.findByName("二中二班班长"),characterRepo.findByName("二中五班班长"),"同学",1),
				new RelationOf(characterRepo.findByName("二中五班A"),characterRepo.findByName("二中五班D"),"同学",1),
				new RelationOf(characterRepo.findByName("二中五班B"),characterRepo.findByName("二中五班D"),"同学",1),
				new RelationOf(characterRepo.findByName("二中五班C"),characterRepo.findByName("二中五班D"),"同学",1),
				new RelationOf(characterRepo.findByName("二中五班班长"),characterRepo.findByName("二中五班D"),"同学",1),
				new RelationOf(characterRepo.findByName("二中五班B"),characterRepo.findByName("一中二班D"),"邻居",1),
				new RelationOf(characterRepo.findByName("一中二班A"),characterRepo.findByName("一中五班A"),"姐弟",1),
				new RelationOf(characterRepo.findByName("一中二班班长"),characterRepo.findByName("一中二班语文教师"),"师生",1),
				new RelationOf(characterRepo.findByName("一中五班班长"),characterRepo.findByName("一中五班语文教师"),"师生",1),
				new RelationOf(characterRepo.findByName("一中五班班长"),characterRepo.findByName("二中二班班主任"),"亲戚",1),
				
				new RelationOf(characterRepo.findByName("一中校长"),characterRepo.findByName("教育局局长"),"同事",1),
				new RelationOf(characterRepo.findByName("二中校长"),characterRepo.findByName("教育局局长"),"同事",1),
				new RelationOf(characterRepo.findByName("教育局局长"),characterRepo.findByName("一中二班班主任"),"夫妻",1),
				new RelationOf(characterRepo.findByName("教育局局长"),characterRepo.findByName("二中五班B"),"父子",0),
				new RelationOf(characterRepo.findByName("一中二班班主任"),characterRepo.findByName("二中五班B"),"母子",1),
				new RelationOf(characterRepo.findByName("一中校长"),characterRepo.findByName("二中校长"),"同事",1),
				new RelationOf(characterRepo.findByName("一中教导主任"),characterRepo.findByName("一中校长"),"同事",1),
				new RelationOf(characterRepo.findByName("二中教导主任"),characterRepo.findByName("二中校长"),"同事",1),
				
				new RelationOf(characterRepo.findByName("一中二班班主任"),characterRepo.findByName("一中校长"),"同事",1),
				new RelationOf(characterRepo.findByName("一中五班班主任"),characterRepo.findByName("一中教导主任"),"同事",1),
				
				new RelationOf(characterRepo.findByName("二中二班班主任"),characterRepo.findByName("二中教导主任"),"邻居",1),
				new RelationOf(characterRepo.findByName("二中五班班主任"),characterRepo.findByName("二中校长"),"亲戚",1),
				
				new RelationOf(characterRepo.findByName("一中二班A"),characterRepo.findByName("一中教导主任"),"父子",1),
				new RelationOf(characterRepo.findByName("二中二班班主任"),characterRepo.findByName("一中校长"),"夫妻",1)
				
				));

        List<UserInfo> curso = relationOfRepo.getShortestPath(
        		characterRepo.getDbIdByName("一中二班B"),
        		characterRepo.getDbIdByName("二中二班班主任"));
		curso.forEach(aDocumen -> {
			System.err.println("查询的名称： " + aDocumen.getName());
		});
		
		//String queryStr = "FOR p IN ANY SHORTEST_PATH @child TO @parent childOf return p";
		String queryStr = "FOR p IN ANY SHORTEST_PATH @child TO @parent childOf return p";
		
		
//		Map<String, Object> bindVar = new MapBuilder()
//				.put("child", characterRepo.getDbIdByName("洁"))
//				.put("parent", characterRepo.getDbIdByName("洁爷")).get();
//		System.out.println("名称： " + operations.driver().db());
//		
//		ArangoCursor<Character> curso = operations.driver().db("spring-demo").query(queryStr, bindVar , null, Character.class);
//		
//		System.out.println("名称： " + curso.hasNext());
//		curso.forEachRemaining(aDocumen -> {
//			System.out.println("名称： " + aDocumen.getName());
//		});
		
	}

}

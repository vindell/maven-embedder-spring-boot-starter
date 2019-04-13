# spring-boot-starter-maven-embedder
Spring Boot Starter For Maven Embedder

### 说明


 > 基于 maven-embedder 的 Spring Boot Starter 实现

1. 整合 maven-embedder

### Maven

``` xml
<dependency>
	<groupId>${project.groupId}</groupId>
	<artifactId>spring-boot-starter-maven-embedder</artifactId>
	<version>${project.version}</version>
</dependency>
```

### Sample

```java

import javax.annotation.PostConstruct;

import org.apache.maven.spring.boot.ext.MavenCliTemplate;
import org.apache.maven.spring.boot.ext.MavenEmbedderTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMavenEmbedder
@SpringBootApplication
public class Application {
	
	@Autowired
	private MavenCliTemplate mavenCliTemplate;
	
	@Autowired
	private MavenEmbedderTemplate mavenEmbedderTemplate;
	
	@PostConstruct
	private void init() {
		
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}

```

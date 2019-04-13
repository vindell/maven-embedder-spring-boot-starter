package org.apache.maven.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(MavenEmbedderProperties.PREFIX)
public class MavenEmbedderProperties {

	public static final String PREFIX = "maven.embedder";
	
	
}
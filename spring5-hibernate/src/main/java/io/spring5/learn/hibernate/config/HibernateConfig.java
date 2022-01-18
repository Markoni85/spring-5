package io.spring5.learn.hibernate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hibernate")
public class HibernateConfig {

	private String hbm2ddlAuto;
	private String namingStrategy;
	private Integer maxFetchDepth;
	private Integer batchSize;
	private Integer fetchSize;
	private String dialect;
	public String getHbm2ddlAuto() {
		return hbm2ddlAuto;
	}
	public void setHbm2ddlAuto(String hbm2ddlAuto) {
		this.hbm2ddlAuto = hbm2ddlAuto;
	}
	public String getNamingStrategy() {
		return namingStrategy;
	}
	public void setNamingStrategy(String namingStrategy) {
		this.namingStrategy = namingStrategy;
	}
	public Integer getMaxFetchDepth() {
		return maxFetchDepth;
	}
	public void setMaxFetchDepth(Integer maxFetchDepth) {
		this.maxFetchDepth = maxFetchDepth;
	}
	public Integer getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(Integer batchSize) {
		this.batchSize = batchSize;
	}
	public Integer getFetchSize() {
		return fetchSize;
	}
	public void setFetchSize(Integer fetchSize) {
		this.fetchSize = fetchSize;
	}
	public String getDialect() {
		return dialect;
	}
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	
	
}
